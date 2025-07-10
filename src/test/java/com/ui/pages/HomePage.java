package com.ui.pages;

import org.openqa.selenium.By;

import com.constants.Browser;
import com.utility.BrowserUtility;
import com.utility.propertiesUtility;
public final class HomePage extends BrowserUtility {

	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[@class='login']");

	public HomePage(Browser browserName) {
		super(browserName);
		goToWebsite(propertiesUtility.getURL("url"));
	}

	public LoginPage goToLoginPage() {
		clickOn(SIGN_IN_LINK_LOCATOR);
		return new LoginPage(getDriver());
	}

}
