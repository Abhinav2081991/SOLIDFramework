package core.resources.pojos;

import org.apache.commons.math3.analysis.function.Add;

import java.util.List;

public class Users {

    private String firstName;
    private String lastName;
    private Address address;

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }

    public String getFirstName() {
        return firstName;
    }

    public Users(String firstName, String lastName, Address address){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

}
