package com.sugarCRM.base;

import com.TestAutomationDemo.base.ConfigBase;
import com.aventstack.extentreports.Status;
import com.sugarCRM.pages.HomePage;
import com.sugarCRM.pages.LeadsPage;
import com.sugarCRM.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.ResourceBundle;
/**
 * @Author Bharath Kumar Reddy V
 * @Date 21-Nov-2019
 */
public class TestBase extends ConfigBase {
    // Variable declarions
    public LoginPage loginPage;
    public HomePage homePage;
    public LeadsPage leadsPage;



    public void initPageClass(){
        homePage = new HomePage(configTestData);
        loginPage=new LoginPage(configTestData);
        leadsPage = new LeadsPage(configTestData);
    }


    public void verify(boolean condition, String trueMsg,String falseMsg){
        configTestData.stepNo = configTestData.stepNo+1;
        if(condition){
            extentManager.addExecutionStep(Status.PASS,trueMsg);
        } else{
            extentManager.addExecutionStep(Status.FAIL,falseMsg);
            configTestData.finalTestCaseStatus = Status.FAIL;
        }
    }
    public void verify(boolean condition){

        if(condition){
            extentManager.addExecutionStep(Status.PASS);
        } else{
            extentManager.addExecutionStep(Status.FAIL);
            configTestData.finalTestCaseStatus = Status.FAIL;
        }
       // configTestData.stepNo = configTestData.stepNo+1;
    }


    public void Assert(String condition,String trueMsg,String falseMsg){
        configTestData.stepNo = configTestData.stepNo+1;
        boolean con;
        if(condition.toLowerCase() == "true"){
            extentManager.addExecutionStep(Status.PASS,trueMsg);
            con=true;
        } else{
            con=false;
            extentManager.addExecutionStep(Status.FAIL,falseMsg);
            configTestData.finalTestCaseStatus = Status.FAIL;
        }

        Assert.assertTrue(con,falseMsg);
    }



}
