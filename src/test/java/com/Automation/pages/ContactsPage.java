package com.Automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	WebDriver driver;
	public ContactsPage(WebDriver cdriver)
	{
		this.driver=cdriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.XPATH,using="//td[contains(text(),'Contacts')]")
	private WebElement contactslbl;
	
	//ToWrite Dynamic Xpath for different table contents with same hirerchy we cannot use FindBy
	//Use normal driver.findBy in a method to return specific element from the table like below
	
	public void selectContactsByName(String contactname)
	{
		driver.findElement(By.xpath("//a[text()='"+contactname+"']"
				+ "//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']"
				+ "//input[@name='contact_id']")).click();
	}
	
	public boolean verifyContactsLabel()
	{
		return contactslbl.isDisplayed();
	}
	
}
