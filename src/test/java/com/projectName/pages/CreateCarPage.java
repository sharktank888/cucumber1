package com.projectName.pages;

import com.projectName.utils.BrowserUtils;
import com.projectName.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateCarPage extends BasePage{
    @FindBy(css="[title='Create Car']")
    private WebElement createCarBtn;

    @FindBy(name ="custom_entity_type[LicensePlate]")

    private WebElement licencePlateInputBox;

    @FindBy(name = "custom_entity_type[ModelYear]")
    private WebElement modelYearInputBox;
    public void clickOnCreateCar(){
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),20);
        wait.until(ExpectedConditions.elementToBeClickable(createCarBtn)).click();
        System.out.println("Clicking on  'create car ' button");
    }
    public void   enterLicensePlate(String licensePlate){
        WebDriverWait wait =new WebDriverWait(Driver.getDriver(),20);
        wait.until(ExpectedConditions.visibilityOf(licencePlateInputBox));

        licencePlateInputBox.clear();
    BrowserUtils.enterText(licencePlateInputBox,licensePlate);
    }
    public void enterModelYear(String modelYear){
        BrowserUtils.enterText(modelYearInputBox,modelYear);
    }

}
