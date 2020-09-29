package com.uteachon.demos.selenium.web;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * SearchWikipediaTest using FireFox: Pseudo code in english
 * 
 * @author hmash
 *
 */
public class SearchWikipediaTest {

	@Test
	public void searchEnglishTextResults() throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "E:\\Uteachon\\Selenium\\geckodriver.exe");
		
		//0. Get Firefox browser instance to WebDriver
		WebDriver browser = new FirefoxDriver();
		
		//1. Launch https://www.wikipedia.org/
		browser.get("https://www.wikipedia.org/");
		
		System.out.println("getWindowHandle:: " + browser.getWindowHandle());
		
		//2. Find and Click the link 'English'
		//WebElement link = browser.findElement(By.linkText("English")); //org.openqa.selenium.NoSuchElementException: Unable to locate element: English
		//WebElement link = browser.findElement(By.xpath("/html/body/div[1]/div[1]/a/strong"));
		
		WebElement link = browser.findElement(By.xpath("//*[@id=\"js-link-box-en\"]/strong"));
		System.out.println("English link by xpath displayed: " + link.isDisplayed());
		link.click();
		Thread.sleep(5000);
		
		//3. Find search input box 
		WebElement searchInput = browser.findElement(By.id("searchInput"));
		
		//int count = browser.findElements(By.id("searchInput")).size();
		
		//4. Key in ‘Software’
		searchInput.sendKeys("Software");
		
		//5. Submit the form
		searchInput.submit();
		Thread.sleep(5000);
		
		//6. Verify the title matches to the expected
		String browserTitle = browser.getTitle();
		assertEquals("Software - Wikipedia", browserTitle);
				
		//7. Close the browser
		browser.close(); //closes the browser
	}
}
