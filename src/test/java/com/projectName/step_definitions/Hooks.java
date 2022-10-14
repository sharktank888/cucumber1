package com.projectName.step_definitions;

import com.projectName.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before("@login")
    public void setUp(){
        System.out.println(":::Starting Automation ::::");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

//    @Before("@login")
//    public void dbSetUp(Scenario scenario){
//        scenario.getSourceTagNames().forEach(tag->{
//            if (tag.contains("edge")){
//                Driver.getDriver();
//            }
//        });




    @After("@db")
    public void dbTeardown(){
        Driver.closeDriver();
    }
//    @After
//    public void teardown(Scenario scenario){
//
//        //this is a hook after = @AfterMethod in TestNG
//        // runs automatically after every test
//
//        if (scenario.isFailed()){
//            byte[] data=((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(data,"image/png",scenario.getName());
//        }
//
//        Driver.closeDriver();
//        System.out.println(":::(***) End of test execution (***) :::");
//    }
//

}
