package com.projectName.pages;

import com.projectName.utils.BrowserUtils;
import com.projectName.utils.ConfigurationReader;
import com.projectName.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BasePage {
    @FindBy(className = "oro-subtitle")
    protected WebElement pageSubTitle;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    protected WebElement saveAndCloseBtn;

    @FindBy(css="[class='loader-mask']")
    protected List<WebElement> loaderMask;

    public BasePage (){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    public String getPageSubTitleText(){
        return pageSubTitle.getText();
    }

    // Method for favigation in vytrack app
        // for example :Fleet, Dashboard, Sales, activities..
    // Module, One of the values that will be visible after clicking on the tab.
    // for Fleet, these are the modules: vehicles, vEHICLE oDOMETER, vvEHICLE cOSTES, ETS..
    public void navigateTo(String tab,String module){
        WebDriverWait wait =new WebDriverWait(Driver.getDriver(),30);
        String tabXpath="//*[contains(text(),'"+tab+"') and @class='title title-level-1']";
        String moduleXpath="//*[contains(text(),'"+module+"') and @class='title title-level-2']";

        // wait until loader mask disappears
        wait.until(ExpectedConditions.invisibilityOfAllElements(loaderMask));


        //wait for presence and ablitiy click on element
        WebElement tabElement= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(tabXpath)));
      wait.until(ExpectedConditions.elementToBeClickable(tabElement)).click();

      WebElement moduleElement=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(moduleXpath)));
      wait.until(ExpectedConditions.elementToBeClickable(moduleElement)).click();
    }

    public void clickSaveAndClose(){
        BrowserUtils.clickOnElement(saveAndCloseBtn);
    }

}
