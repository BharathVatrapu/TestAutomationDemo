package com.sugarCRM.pages;

import com.TestAutomationDemo.base.ConfigTestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * @Author Bharath Kumar Reddy V
 * @Date 22-Nov-2019
 */
public class LoginPage {

    WebDriver driver;
    ConfigTestData configTestData;
    public LoginPage(ConfigTestData configTestData) {
        this.configTestData=configTestData;
        this.driver = configTestData.driver;
        PageFactory.initElements(this.driver,this);
    }

    //variable Declaration
    String login_URL = "http://10.62.65.229:81/sugarcrm/index.php?action=Login&module=Users";
    //********* Sign In Page Web Elements by using Page Factory*********

    @CacheLookup
    @FindBy(id = "user_name")
    public WebElement input_UserName;

    @CacheLookup
    @FindBy(id = "user_password")
    public WebElement input_Password;

    @CacheLookup
    @FindBy(id = "login_button")
    public WebElement btn_Login;

    public void navigate_SugarCRMLoginPage(){
        System.out.println("driver::"+driver);
        driver.navigate().to(login_URL);
    }

    public boolean verify_SugarCRMLoginPage_isDisplayed(){
        boolean status=true;
        if(!driver.getCurrentUrl().contains(login_URL)){
            status =  false;
        }
        return status;
    }

    public void user_Login_To_SugarCRM(String username,String password){
        try {
            input_UserName.sendKeys(username);
            input_Password.sendKeys(password);
            Thread.sleep(15);
            btn_Login.click();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
