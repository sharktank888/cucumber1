package com.projectName.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileOutputStream;
import java.util.Date;

public class BrowserUtils {

    private static WebDriverWait wait=new WebDriverWait(Driver.getDriver(),20);
    public static void wait(int seconds){
        try {
            Thread.sleep(seconds*100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public static void clickOnElement(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public static void clickWithJS(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        ((JavascriptExecutor) (Driver.getDriver())).executeScript("arguments[0].click()",element);
    }
    public static void enterText(WebElement element,String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
        wait.until(ExpectedConditions.attributeToBe(element,"value",text));
        System.out.println("Entering text: "+text );
    }

//    public static void takeScreenshot(String name){
//        Date date =new Date();
//        String path=System.getProperty("user.dir")+"/screenshots";
//        TakesScreenshot takesScreenshot =(TakesScreenshot) Driver.getDriver();
//        byte[] data=takesScreenshot.getScreenshotAs(OutputType.BYTES);
//        try (FileOutputStream outputStream=new FileOutputStream(path)){
//
//        }
//    }
}
