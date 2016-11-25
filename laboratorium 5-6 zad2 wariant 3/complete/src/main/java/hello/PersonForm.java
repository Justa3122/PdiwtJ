package hello;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PersonForm {

    @NotNull
    @Size(min=2, max=30)
    private String firstName;

    @NotNull
    @Size(min=2, max=30)
    private String lastName;

    @NotNull
    @Size(min=16, max=16)
    private Short accountNumber;

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

     public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Short getAccountNumber() {
        return accountNumber;
    }

    public void setAcccountNumber(Short accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String toString() {
        return "Person(First name: " + this.firstName + ", Last name: " + this.lastName + ", Account number: " + this.accountNumber + ")";
    }
}