package com.projectName.step_definitions;

import com.projectName.pages.CreateCarPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.Map;

public class CreateCarStepDefinitions {

    CreateCarPage createCarPage=new CreateCarPage();
    @Given("user clicks on create car button")
    public void user_clicks_on_create_car_button() {
  createCarPage.clickOnCreateCar();
    }
    @When("user adds new vehicle information")
    public void user_adds_new_vehicle_information(Map<String,String> dataTable) {
     // to get all keys and values on by one
        //dataTable.forEach((key,value) -> System.out.println("Key: "+key+",value: "+value));
        System.out.println("License plate: "+dataTable.get("License Plate"));
        System.out.println("Model yar: "+dataTable.get("Model Year"));
        createCarPage.enterLicensePlate(dataTable.get("License Plate"));
        createCarPage.enterModelYear(dataTable.get("Model Year"));
    }
}
