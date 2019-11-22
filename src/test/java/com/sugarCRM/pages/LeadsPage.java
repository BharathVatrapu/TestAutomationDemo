package com.sugarCRM.pages;

import com.TestAutomationDemo.base.ConfigTestData;
import com.TestAutomationDemo.keywords.Action;
import com.TestAutomationDemo.utils.Generic;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import java.util.HashMap;

public class LeadsPage {
    WebDriver driver;
    ConfigTestData configTestData;
    public LeadsPage(ConfigTestData configTestData) {
        this.configTestData=configTestData;
        this.driver = configTestData.driver;
        PageFactory.initElements(this.driver,this);
    }

    @CacheLookup
    @FindBy(xpath = "//li[@id='0_lv']//a[contains(text(),'Create Lead')]")
    public WebElement lnk_CreateLeads;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Leads:')]")
    public WebElement header_Leads;

    @CacheLookup
    @FindBy(id = "phone_work")
    public WebElement input_OfficePhone;

    @CacheLookup
    @FindBy(id = "phone_home")
    public WebElement input_HomePhone;

    @CacheLookup
    @FindBy(id = "phone_mobile")
    public WebElement input_MobilePhone;

    @CacheLookup
    @FindBy(id = "last_name")
    public WebElement input_LastName;

    @CacheLookup
    @FindBy(xpath="//select[@name='salutation']")
    public WebElement list_Salutation;

    @CacheLookup
    @FindBy(name = "first_name")
    public WebElement input_FirstName;

    @CacheLookup
    @FindBy(id="lead_source")
    public WebElement list_Leadsource;

    @CacheLookup
    @FindBy(xpath="//input[@name='btn_campaign_name']")
    public WebElement btn_Campaign_Select;

    @FindBy(xpath="//input[@id='name_advanced']")
    public WebElement campaign_SearchName;

    @FindBy(xpath="//input[@title='Search [Alt+Q]']")
    public WebElement campaign_SearchButton;

    @FindBy(xpath="//td[@class='oddListRowS1']//a[1]")
    public WebElement campaign_SearchResult;

    @FindBy(xpath="//input[@name='account_name']")
    public WebElement account_name;

    @FindBy(xpath="//input[@name='title']")
    public WebElement title;

    @FindBy(id="department")
    public WebElement department;

    @FindBy(xpath="//input[@name='btn_assigned_user_name']")
    public WebElement assigned_select;

    @FindBy(xpath="//input[@name='first_name']")
    public WebElement assignedto_fname;

    @FindBy(xpath="//input[@name='last_name']")
    public WebElement assignedto_lname;

    @FindBy(xpath="//input[@name='user_name']")
    public WebElement assignedto_uname;

    @FindBy(xpath="//input[@title='Cancel [Alt+X]']")
    public WebElement assignedto_cancel;

    @FindBy(id="primary_address_street")
    public WebElement primary_address;

    @FindBy(id="primary_address_city")
    public WebElement city;

    @FindBy(id="primary_address_state")
    public WebElement state;


    @FindBy(id="primary_address_postalcode")
    public WebElement postalcode;

    @FindBy(id="primary_address_country")
    public WebElement country;

    @FindBy(id="alt_checkbox")
    public WebElement copy_checkbox;

    @FindBy(xpath="//div[@id='LBL_DESCRIPTION_INFORMATION']/following-sibling::div[1]//input[1]")
    public WebElement Save;

    @FindBy(xpath="//a[contains(text(),'Logout')]")
    public WebElement logout;

    @FindBy(xpath="//td[@valign='top']//h2")
    public WebElement lead_verification;

    @FindBy(xpath="//a[contains(text(),'Add Address')]")
    public WebElement add_address;

    @FindBy(xpath="//img[@id='removeButton1']")
    public WebElement email_delete;

    @FindBy(xpath="//input[@name='emailAddress0']")
    public WebElement email_field1;

    @FindBy(xpath="//input[@name='emailAddress1']")
    public WebElement email_field2;

    //Edit Lead

    @FindBy(xpath="//input[@id='first_name_basic']")
    public WebElement edit_fname;

    @FindBy(xpath="//input[@id='last_name_basic']")
    public WebElement edit_lname;

    @FindBy(xpath="//input[@id='search_form_submit']")
    public WebElement edit_Search;

    @FindBy(xpath="//td[@id='main']//tr[3]//td[7]//a[1]")
    public WebElement edit_click;

    @FindBy(xpath="//textarea[@name='description']")
    public WebElement description;

    @FindBy(xpath="//body/table/tbody/tr/td/form/table/tbody/tr[3]/td[1]/input[1]")
    public WebElement delete_checkbox;

    @FindBy(xpath="//table[@class='listview']//tr[1]//td[1]//table[1]//tbody[1]//tr[1]//td[1]//a[@id='select_link']/following-sibling::input[@value='Delete']")
    public WebElement delete;



    public void user_fills_Lead_information(){
        HashMap<String,String> testData=new HashMap<String,String>();
        testData = Generic.getTestData(configTestData.testData_path, "Lead_Information",configTestData.testMethodName);


    }


}
