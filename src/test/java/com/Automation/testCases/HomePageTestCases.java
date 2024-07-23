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

public class HomePageTestCases extends BaseClass{
	
	//Test cases should be independent should launch browser and close it for every TC
	//Launch browser
	//Execute TC
	//Quit browser
	
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
	}
	@AfterMethod
	public void teardown()
	{
		driverQuit();
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String expectedTitle= "CRMPRO";
		Assert.assertEquals(homepageobj.verifyHomePageTitle(), expectedTitle,"HomePage Title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest()
	{
		helperObj.switchToFrame("mainpanel");
		Assert.assertTrue(homepageobj.verifyUserNameDisplayed(), "User name is not found");
		
	}
	@Test(priority=3)
	public void verifyClickOnContactsTest()
	{
		helperObj.switchToFrame("mainpanel");
		contactpageObj=homepageobj.clickOnContacts();
	}
}
