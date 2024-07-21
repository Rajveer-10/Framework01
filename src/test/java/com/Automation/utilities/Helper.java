package com.Automation.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	public static long implicitwaittime=15;
	

	//Method to capture screenshot
	public static void captureScreenshotLocal(WebDriver driver) throws IOException
	{
		File srcfile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcfile, new File("./Screenshots/screenshot.jpg"));
		
	}

	//Method to return date in specific format
	public static String getCurrentDate()
	{
		DateFormat customformat = new SimpleDateFormat("DD_MM_YYYY_HH_mm_ss");
		Date currentdate= new Date();
		return customformat.format(currentdate);
	}
}
