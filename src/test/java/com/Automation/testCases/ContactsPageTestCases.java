package com.Automation.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Automation.pages.ContactsPage;
import com.Automation.pages.HomePage;
import com.Automation.pages.LoginPage;
import com.Automation.utilities.BaseClass;
import com.Automation.utilities.Helper;

public class ContactsPageTestCases extends BaseClass {

	LoginPage loginpageobj;
	HomePage homepageobj;
	Helper helperObj;
	ContactsPage contactpageObj;
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException
	{
		initialize();
		loginpageobj= new LoginPage(driver);
		helperObj=new Helper(driver);
		homepageobj=loginpageobj.loginToApplication(conf.getUsername(),conf.getPassword());
		
		helperObj.switchToFrame("mainpanel");
		contactpageObj= homepageobj.clickOnContacts();
	}
	@AfterMethod
	public void teardown()
	{
		driverQuit();
	}
	
	@Test(priority=1)
	public void verifyContactsLable() 
	{
		Assert.assertTrue(contactpageObj.verifyContactsLabel(),"Contacts label is not present");
	}
	@Test(priority=2)
	public void selectContactsCheckboxs() 
	{
		contactpageObj.selectContactsByName("Alex Berth");
		contactpageObj.selectContactsByName("Ann Pansa");
	}
}
