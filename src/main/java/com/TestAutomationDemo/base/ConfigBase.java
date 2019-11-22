package com.TestAutomationDemo.base;

import com.TestAutomationDemo.driver.DriverConfig;
import com.TestAutomationDemo.utils.DateUtils;
import com.TestAutomationDemo.utils.ExtentManager;
import com.TestAutomationDemo.utils.Generic;
import com.TestAutomationDemo.utils.ScreenshotGenarator;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.ResourceBundle;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

/**
 * @Author Bharath Kumar Reddy V
 * @Date 21-Nov-2019
 */

public class ConfigBase {


    public ConfigTestData configTestData=new ConfigTestData();
    public ExtentManager extentManager = new ExtentManager(configTestData);
    public ScreenshotGenarator screenshotGenarator;
    public ThreadLocal<RemoteWebDriver> remoteWebDriver = null;

    public static ResourceBundle rbTestdata;
    HashMap<String, String> enviornmentHashmap;

    @BeforeSuite (alwaysRun = true)
    public void beforeSuite(){
        try {
            Generic.readConfigProp();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @BeforeTest(alwaysRun = true)
    public void extentReportConfig(ITestContext context) {
        String groupName = null;
        String reportName = null;
        configTestData.suiteXmlName = context.getSuite().getName();
        //groupName=generic.getSuiteXmlGroupName(context.getIncludedGroups());
        reportName = configTestData.suiteXmlName + "_[" + DateUtils.getDate() +"]_"+ DateUtils.getTime()+".html";
        extentManager.createReportFile(reportName);
    }

    @Parameters({"platform","browser"})
    @BeforeMethod(alwaysRun = true)
    public void initSetup(Method testMethod,String platform,String browser){
        screenshotGenarator = new ScreenshotGenarator(configTestData);

        configTestData.testPlatform = platform;
        configTestData.testBrowser = browser;
        try {
            configTestData.testMethodName = testMethod.getName();
            remoteWebDriver = new ThreadLocal<>();
            DriverConfig driverConfig = new DriverConfig(configTestData);
            remoteWebDriver.set(driverConfig.getDriver());

            configTestData.driver = remoteWebDriver.get();
            extentManager.createTest(configTestData.testMethodName);
        } catch (Exception e){
            e.printStackTrace();
        }
        Test testClass = testMethod.getAnnotation(Test.class);
        configTestData.groupName = testClass.groups()[0];

    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        try{
            enviornmentHashmap = new HashMap<String, String>();

            enviornmentHashmap.put("OS",Generic.getCurretnPlatform().toString());
            enviornmentHashmap.put("UserName",System.getProperty("user.name"));
            enviornmentHashmap.put("Platform",configTestData.testPlatform.toUpperCase());
            enviornmentHashmap.put("Browser",configTestData.testBrowser.toUpperCase());
            extentManager.setSystemInfo(enviornmentHashmap);

            //extentManager.assignLog(generic.readFile(GlobalConstants.workDir+ Generic.readConfigProp("log.file")));
            extentManager.setHtmlConfig(configTestData.suiteXmlName);
            extentManager.endReport();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    @AfterMethod(alwaysRun = true)
    protected void afterMethod(ITestResult result) {
//        for(String group:result.getMethod().getGroups()){
//            System.out.println("group::"+group);
//            extentManager.assignGroup(group);
//        }
        try{
                 configTestData.driver.quit();
           // extentManager.addfinalStatus(configTestData.finalTestCaseStatus);
        } catch (Exception e){
            e.printStackTrace();
        }
    }



}
