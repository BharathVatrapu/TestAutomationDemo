package com.sugarCRM.suites.demo;

import com.sugarCRM.base.TestBase;
import org.testng.annotations.Test;
/**
 * @Author Bharath Kumar Reddy V
 * @Date 22-Nov-2019
 */
public class To_Create_a_Lead_in_SugarCRM extends TestBase {

    @Test(groups={"Smoke"})
    public void To_Create_a_Lead_in_SugarCRM() throws Exception {
       //Variable Declarion
        initPageClass();

        configTestData.stepNo=1;
        configTestData.stepDescription = "user navigates to homepage";
        configTestData.stepExpected = "Homepage is displayed";
        configTestData.stepFail = "Homepage does not displayed";

        loginPage.navigate_SugarCRMLoginPage();
        verify(loginPage.verify_SugarCRMLoginPage_isDisplayed());

        configTestData.stepNo=2;
        configTestData.stepDescription = "User enters credentials and clicks login";
        configTestData.stepExpected = "User successfully login to application";
        configTestData.stepFail = "User un able to login to aplication";

        loginPage.user_Login_To_SugarCRM("admin","Admin@123");
        verify(homePage.tab_Leads.isDisplayed());

        configTestData.stepNo=3;
        configTestData.stepDescription = "user clicks on Leads tab";
        configTestData.stepExpected = "Leads page is displayed";
        configTestData.stepFail = "Leads page is not displayed";

        homePage.tab_Leads.click();
        Thread.sleep(15);
        verify(leadsPage.header_Leads.isDisplayed());

        configTestData.stepNo=4;
        configTestData.stepDescription = "user Enters information and clicks on save button";
        configTestData.stepExpected = "User successsfully created lead";
        configTestData.stepFail = "User does not created lead";





    }

}
