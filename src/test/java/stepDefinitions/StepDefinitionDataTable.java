package stepDefinitions;

import core.resources.lombokPackage.AddressLom;
import core.resources.lombokPackage.UserRegistrationLom;
import core.resources.pojos.Address;
import core.resources.pojos.UserRegistration;
import core.resources.pojos.Users;
import core.resources.lombokPackage.UsersLom;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.bouncycastle.tsp.TSPUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StepDefinitionDataTable {

    @Given("I am using a datatable as maps")
    public void i_am_using_a_datatable_as_maps(DataTable datatable) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(datatable.asMap());
    }
    @Then("I can fetch data from Datatable")
    public void i_can_fetch_data_from_datatable() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("I am using a Datatable which will fetch username and password")
    public void i_am_using_a_datatable_which_will_fetch_username_and_password(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> datatableMap = dataTable.asMaps(String.class, String.class);
        System.out.println( datatableMap.get(1).get("username"));
        System.out.println( datatableMap.get(1).get("password"));
        System.out.println( datatableMap.get(1).get("EmployeeID"));

        //Looping through the list of HashMap.
        for(Map<String,String> map: datatableMap){
            map.get("username");
            map.get("password");
            map.get("EmployeeID");
        }

//        Map<String, String> datatableMap2  = dataTable.asMap(String.class, String.class);
//        System.out.println( datatableMap.get(2).get("EmployeeID"));

    }

    @Given("I am using a Datatable using NestedPojo")
    public void i_am_using_a_datatable_using_nested_pojo(io.cucumber.datatable.DataTable dataTable) {

//        This is for single row as POJO
//        Map<String, String> data = dataTable.asMap(String.class, String.class);
//
//        Address a= new Address();
//        a.setCity(data.get("city"));
//        a.setZip(Integer.parseInt(String.valueOf(data.get("zip"))));
//
//        Users u = new Users();
//        u.setFirstName(data.get("firstName"));
//        u.setLastName(data.get("lastName"));
//        u.setAddress((a));

//        For Json Arrays

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        List<Users> users = new ArrayList<>();

        for(Map<String,String> m : data) {
            Address address = new Address(m.get("city"), m.get("zip"));
            Users user = new Users(m.get("firstName"), m.get("lastName"), address);
            users.add(user);
        }
        UserRegistration userRegistration = new UserRegistration(users);
        System.out.println("Request body is " + userRegistration);
//        -- this can be passed as a request body.
    }

    @Given("I am using a Datatable using NestedPojo and lombok")
    public void i_am_using_a_datatable_using_nested_pojo_and_lombok(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String,String>> rows = dataTable.asMaps(String.class, String.class);
        List<UsersLom> users = rows.stream().map(row -> UsersLom.builder()
                .firstName(row.get("firstName"))
                .lastName(row.get("lastName"))
                .address(AddressLom.builder()
                        .city(row.get("city"))
                        .zip(row.get("zip")).build()).build()).toList();

        UserRegistrationLom userRegistrationLom = UserRegistrationLom.builder().users(users).build();

        for(UsersLom u : userRegistrationLom.getUsers()){
            System.out.println("-------------------------------");
            System.out.println(u.getFirstName());
            System.out.println(u.getLastName());
            System.out.println(u.getAddress());
        }

        System.out.println(userRegistrationLom.getUsers().getFirst());
//        response = given()
//                .contentType(ContentType.JSON)
//                .body(request)
//                .post("/users/bulk");
    }
}
