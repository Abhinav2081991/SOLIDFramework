package stepDefinitions;

import core.context.ScenarioContext;
import core.context.TestContext;
import core.resources.lombokPackage.AddressLom;
import core.resources.lombokPackage.UserRegistrationLom;
import core.resources.lombokPackage.UsersLom;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class ScenarioContextStepDefinitions {

    private final ScenarioContext scenarioContext;

    public ScenarioContextStepDefinitions(TestContext testContext){
        this.scenarioContext = testContext.getScenarioContext();
    }

    @Given("I am using a Datatable for Scenario Context")
    public void i_am_using_a_datatable_for_scenario_context(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        List<UsersLom> users = rows.stream().map(row -> UsersLom.builder()
                .firstName(row.get("firstName"))
                .lastName(row.get("lastName"))
                .address(AddressLom.builder().city(row.get("city")).zip(row.get("zip")).build()).build()).toList();
        UserRegistrationLom userRegistrationLom = UserRegistrationLom.builder().users(users).build();
        scenarioContext.setContext("USERS", userRegistrationLom.getUsers());
    }
    @Then("I am validating the same in the UI")
    public void i_am_validating_the_same_in_the_ui() {
       List<UsersLom> users = scenarioContext.getContext("USERS");
       for(UsersLom user: users){
           System.out.println("AAAAAA "+user.getFirstName());
           System.out.println("bbbbbb "+user.getLastName());
           System.out.println("CCCCCC "+user.getAddress());
       }
    }
}
