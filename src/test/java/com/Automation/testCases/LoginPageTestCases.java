package com.Automation.testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Automation.pages.HomePage;
import com.Automation.pages.LoginPage;
import com.Automation.utilities.BaseClass;

public class LoginPageTestCases extends BaseClass
{
	LoginPage loginpageobj;
	HomePage homepageobj;
	@BeforeMethod
	public void setup() throws IOException, InterruptedException
	{
		initialize();
		loginpageobj= new LoginPage(driver);
	}
	@Test(priority=1)
	public void verifyTitleTest()
	{
		String title=loginpageobj.getPageTitle();
		//To add testng report logs
		Reporter.log("Asserting the Title", true);
		Assert.assertEquals(title, "Free CRM software for customer relationship management, sales, and support.");
		
		
	}
	
	@Test(priority=2)
	public void validateCrmLogoImage()
	{
		boolean flag= loginpageobj.verifyimage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest()
	{
		homepageobj= loginpageobj.loginToApplication(conf.getUsername(),conf.getPassword());
	}
	
	@AfterMethod
	public void teardown()
	{
		driverQuit();
	}
}
