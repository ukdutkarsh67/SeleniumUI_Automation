package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility {

	private static final By EMAIL_LOCATOR = By.id("email");
	private static final By PASSWORD_LOCATOR = By.id("passwd");
	private static final By SIGN_IN_SUBMIT_BUTTON_LOCATOR = By.id("SubmitLogin");
	private static final By LOGIN_FAILED_LOCATOR = By.xpath("//div[@class='alert alert-danger']//ol//li");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public MyAccountPage doLoginWith(String email, String password) {
		enterDetail(EMAIL_LOCATOR, email);
		enterDetail(PASSWORD_LOCATOR, password);
		clickOn(SIGN_IN_SUBMIT_BUTTON_LOCATOR);
		return new MyAccountPage(getDriver());
	}

	public String getAuthenticationFailed() {
		return getVisibleText(LOGIN_FAILED_LOCATOR);
	}

//	public void fillEmail(String emailID) {
//		WebElement email=driver.findElement(emailLocator);
//		email.sendKeys(emailID);
//	}
//	
//	public void fillPassword(String passcode) {
//		WebElement password=driver.findElement(passwordLocator);
//		password.sendKeys(passcode);
//	}
//	
//	public void clickSignInButton() {
//		WebElement signInButton=driver.findElement(signInButtonLocator);
//		signInButton.click();
//	}
//	
//	public String verifyAfterLogin() {
//		WebElement sigInValidation=driver.findElement(sigInValidationLocator);
//		String validationText=sigInValidation.getText();
//		return validationText;
//	}
//	

}
