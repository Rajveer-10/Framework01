package com.Automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.Automation.utilities.BaseClass;

public class HomePage extends BaseClass{
	
	WebDriver driver;
	
	//initializing webelements
	public HomePage(WebDriver hdriver)
	{
		this.driver=hdriver;
		PageFactory.initElements(driver, this);
	}
	
	//Web Elements
	@FindBy(how=How.XPATH,using="//td[contains(text(),'User: Gagan Khanna')]")
	private WebElement usernameLabel;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Contacts')]")
	private WebElement contactsMenu;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Deals')]")
	private WebElement dealsMenu;

	@FindBy(how=How.XPATH,using="//a[contains(text(),'Tasks')]")
	private WebElement tasksMenu;
	
	//Getter methods to access private web elements
	public WebElement getUsernameLabel() 
	{
		return usernameLabel;
	}

	public WebElement getContactsMenu() 
	{
		return contactsMenu;
	}
	public WebElement getDealsMenu() 
	{
		return dealsMenu;
	}

	public WebElement getTasksMenu() {
		return tasksMenu;
	}

	//Methods for HomePage
	public boolean verifyUserNameDisplayed()
	{
		return usernameLabel.isDisplayed();
	}
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContacts()
	{
		contactsMenu.click();
		return new ContactsPage(driver);
	}
	public DealsPage clickOnDeals()
	{
		dealsMenu.click();
		return new DealsPage(driver);
	}
	
	
}
