package hello;

public class Customer {
    private long id;
    private String firstName, lastName;
    private short accountNumber;

    public Customer(long id, String firstName, String lastName, short accountNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s', accountNumber='%d']",
                id, firstName, lastName, accountNumber);
    }

    // getters & setters omitted for brevity
}