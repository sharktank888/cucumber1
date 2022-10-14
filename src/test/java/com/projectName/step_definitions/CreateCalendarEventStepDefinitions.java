package com.projectName.step_definitions;

import com.projectName.pages.CreateCalendarEventPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class CreateCalendarEventStepDefinitions {
    CreateCalendarEventPage createCalendarEventPage =new CreateCalendarEventPage();
    @Given("user clicks on create calendar event button")
    public void user_clicks_on_create_calendar_event_button() {
     createCalendarEventPage.clickOnCreateCalendarEvent();
    }



    @When("user adds new calendar event information")
    public void user_adds_new_calendar_event_information(Map<String,String> data) {
      String title=data.get("Title");
      String description=data.get("Description");

      createCalendarEventPage.enterDescription(description);
      createCalendarEventPage.enterTitle(title);

    }
//    @Then("user verifies that new calendar event is displayed:")
//    public void user_verifies_that_new_calendar_event_is_displayed(Map<String,String> data) {
//       String title=data.get("Title");
//       String description=data.get("description");
//        Assert.assertEquals(title,createCalendarEventPage.getDataFromGeneralInfo("title"));
//    }




}
