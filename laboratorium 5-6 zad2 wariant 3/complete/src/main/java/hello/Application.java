package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) throws Exception {
        SpringApplication.run(Application.class, args);
    }
    @Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
            storageService.deleteAll();
            storageService.init();
		};
	}
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... strings) throws Exception {

        log.info("Creating tables");

        jdbcTemplate.execute("DROP TABLE customers IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE customers(" +
                "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255), account_number SHORT(16))");

      
        List<Object[]> splitUpData = Arrays.asList("John Woo 5555444488889999", "Jeff Dean 4444777755552222", "Josh Bloch 4444111122225555", "Josh Long 4444777722221111").stream()
                .map(data -> data.split(" "))
                .collect(Collectors.toList());

        // Use a Java 8 stream to print out each tuple of the list
        splitUpData.forEach(data -> log.info(String.format("Inserting customer record for %s %s %d", data[0], data[1], data[2])));

        // Uses JdbcTemplate's batchUpdate operation to bulk load data
        jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name, account_number) VALUES (?,?, ?)", splitUpData);

        log.info("Querying for customer records where first_name = 'Josh':");
        jdbcTemplate.query(
                "SELECT id, first_name, last_name, account_number FROM customers WHERE first_name = ?", new Object[] { "Josh" },
                (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("account_number"))
        ).forEach(customer -> log.info(customer.toString()));
    }
}