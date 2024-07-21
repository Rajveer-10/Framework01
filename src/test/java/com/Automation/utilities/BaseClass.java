package com.Automation.utilities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;

public class BaseClass 
{
	
	public WebDriver driver;
	public ConfigDataProvider conf;
	public ExtentReporter report;
	public ExtentTest logger;
	
	//Method to initialize driver instance as per local or remote in singleton manner
	public void initialize() throws IOException, InterruptedException 
	{
		System.out.println("inside initialize method");
		
		conf= new ConfigDataProvider();
		
		if(conf.getDriverLocalOrRemote().equalsIgnoreCase("Local"))
		{
				if(conf.getbrowsername().equalsIgnoreCase("Chrome"))
				{
				//System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
				System.setProperty("webdriver.chrome.driver","C:\\Users\\Rajveer\\eclipse-workspace\\Framework\\Drivers\\chromedriver.exe");
				driver= new ChromeDriver();
				}
				else if (conf.getbrowsername().equalsIgnoreCase("Firefox"))
				{
					System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
					driver= new FirefoxDriver();
				}
			
		}
		
		else if(conf.getDriverLocalOrRemote().equalsIgnoreCase("Remote"))
		{
			
				if(conf.getbrowsername().equalsIgnoreCase("Chrome"))
				{
				System.setProperty("webdriver.chrome.driver","C:\\Users\\Rajveer\\eclipse-workspace\\Framework\\Drivers\\chromedriver.exe");
				driver= new ChromeDriver();
				}
				else if (conf.getbrowsername().equalsIgnoreCase("Firefox"))
				{
					System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
					driver= new FirefoxDriver();
				}
			
		}
		System.out.println("Launching URL");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Long.parseLong(conf.getimplicitWait()), TimeUnit.SECONDS);
		driver.get(conf.gettestingURL());
		
	  }
	
	public void driverQuit()
	{
		System.out.println("Quitting Browser");
		driver.quit();
	}
	
}
	
