package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.constants.Browser;

public abstract class BrowserUtility {
	private WebDriver driver;

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public BrowserUtility(Browser browserName) {
		if(browserName==Browser.CHROME) {
			driver=new ChromeDriver();
		}else if(browserName==Browser.EDGE) {
			driver=new EdgeDriver();	
		}else if(browserName==Browser.FIREFOX) {
			driver=new FirefoxDriver();
		}
		else {
			System.err.println("Invalid Browser Name......Please select chrome or edge");
		}
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public void goToWebsite(String url) {
		driver.get(url);
	}
	
	public void windowMaximize() {
		driver.manage().window().maximize();
	}
	
	public void closeBrowser() {
		driver.quit();
	}
	
	public void clickOn(By locator) {
		WebElement element=driver.findElement(locator);
		element.click();
	}
	
	public void enterDetail(By locator,String detail) {
		WebElement element=driver.findElement(locator);
		element.sendKeys(detail);
	}
	
	public String getVisibleText(By locator) {
		WebElement element=driver.findElement(locator);
		return element.getText();
	}
	
	

}
