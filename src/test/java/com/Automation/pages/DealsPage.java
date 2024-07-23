package com.Automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DealsPage {

	WebDriver driver;
	public DealsPage(WebDriver ddriver)
	{
		this.driver=ddriver;
		PageFactory.initElements(driver, this);
	}
}
