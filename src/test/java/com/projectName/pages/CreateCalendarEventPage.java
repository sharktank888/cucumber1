package com.projectName.pages;

import com.projectName.utils.BrowserUtils;
import com.projectName.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


public class CreateCalendarEventPage extends BasePage{

     @FindBy(css ="[title='Create Calendar event']")
    private WebElement CreateCalendarEventBtn;

     @FindBy(xpath ="//input[@name='oro_calendar_event_form[title]']")
     private WebElement titleInputBox;

     @FindBy(xpath ="//body[@id='tinymce']")
     private WebElement descriptionInputBox;

     public void clickOnCreateCalendarEvent(){
         BrowserUtils.clickOnElement(CreateCalendarEventBtn);
     }

     public void enterTitle(String text){
         BrowserUtils.enterText(titleInputBox,text);
     }

     public void enterDescription(String text){
         WebDriverWait wait=new WebDriverWait(Driver.getDriver(),20);
         //exit from all frames
         Driver.getDriver().switchTo().defaultContent();
         //wait for frame and switch to it
         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
         // enter text
         //                                                 BrowserUtils.enterText(descriptionInputBox,text);

         descriptionInputBox.sendKeys(text);
         //exit from the frame
         Driver.getDriver().switchTo().defaultContent();
     }

     public String getDataFromGeneralInfo(String titleXpath){
         WebDriverWait wait =new WebDriverWait(Driver.getDriver(),10);
          titleXpath="(//div[@class='control-label'])[1]";
         String  descriptionXpath="//p[text()='All friends are invited for this party']";
         WebElement TitleElement =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(titleXpath)));
         WebElement DescriptionElement =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(descriptionXpath)));
         WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(titleXpath)));


        return element.getText().trim();



     }


}
