package com.TestAutomationDemo.keywords;

import org.openqa.selenium.WebElement;

public class Action {

    /**
     * Method Description :: To enter text into the Text Fields and Password Fields
     * @param webElement
     * @param str
     */
    public static void sendKeys(WebElement webElement, String str){
        try{
            webElement.sendKeys(str);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
