package com.projectName.step_definitions;

import com.projectName.pages.LoginPage;
import com.projectName.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {

    LoginPage loginPage=new LoginPage();
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
       Driver.getDriver().get("http://qa1.vytrack.com");
    }
    @When("user logs in as a {string}")
    public void user_logs_in_as_a(String string) {
       loginPage.login("storemanager.username");
       // throw new io.cucumber.java.PendingException();
    }
    @Then("user should see dashboard page")
    public void user_should_see_dashboard_page() {
        System.out.println("I see dashboard page");
        String expected="Dashboard";
        String actual=loginPage.getPageSubTitleText().trim();
        Assert.assertEquals("Title is not correct!",expected,actual);
       // Driver.closeDriver();

    }

    @Then("user should see {string} page")
    public void user_should_see_page(String string) {
       String actual =loginPage.getPageSubTitleText().trim();
       Assert.assertEquals("page tilte is not correct!",string,actual);
    }
    @When("user logs in with {string} username and {string} password")
    public void user_logs_in_with_username_and_password(String string, String string2) {
      loginPage.login(string,string2);
        System.out.println("Hallllloooooooo");
    }



    @Then("user verifies that {string} message is displayed")
    public void user_verifies_that_message_is_displayed(String expected) {
        String actualResult= loginPage.getWarningMessageText();
       Assert.assertEquals(expected,actualResult);
    }

}
