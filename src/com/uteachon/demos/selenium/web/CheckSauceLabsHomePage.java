package com.uteachon.demos.selenium.web;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

class CheckSauceLabsHomePage {

	@Test
	public void site_header_is_on_home_page() {   
		
		System.setProperty("webdriver.gecko.driver", "E:\\Uteachon\\Selenium\\geckodriver.exe");
		   
		WebDriver browser = new FirefoxDriver();   
		browser.get("http://saucelabs.com");   
		browser.manage().window().maximize();
		
		WebElement testsCompletedElem = null;
		try {
			testsCompletedElem = browser.findElement(By.xpath("//*[@id=\"entry-71gcGPwOObYB8QP68tiMDS\"]/div/div/div[2]/div/p[1]"));
		} catch (NoSuchElementException nse) {
			nse.printStackTrace();
		}
		
		assertTrue(testsCompletedElem.isDisplayed()); 
		assertTrue("Test failed: Text does not match: ", testsCompletedElem.getText().equals("TESTS COMPLETED"));
		
	
		browser.close();

	}
}
