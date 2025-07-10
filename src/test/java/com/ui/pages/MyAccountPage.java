package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class MyAccountPage extends BrowserUtility{

	private static final By SIGN_IN_VALIDATION_LOCATOR=By.className("page-heading");
	private static final By USER_NAME_LOCATOR=By.xpath("//a[@title='View my customer account']//span");
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	public String getSignInValidationText() {
		return getVisibleText(SIGN_IN_VALIDATION_LOCATOR);
	}
	
	public String getUserName() {
		return getVisibleText(USER_NAME_LOCATOR);
	}

}
