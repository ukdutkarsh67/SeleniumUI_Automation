package com.ui.tests;

import static com.constants.Browser.CHROME;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;

public class LoginTest {
	HomePage homePage;

	@BeforeMethod
	public void setup() {
		homePage = new HomePage(CHROME);
		homePage.windowMaximize();
	}

	@Test(dataProviderClass=com.ui.dataprovider.LoginDataProvider.class,dataProvider="LoginDataProvider")
	public void verifyLoginWithValidCredentials(User user) {
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmail(), user.getPassword()).getUserName(),
				"Utkarsh Dwivedi");
	}


	@AfterMethod
	public void tearDown() {
		homePage.closeBrowser();
	}

}
