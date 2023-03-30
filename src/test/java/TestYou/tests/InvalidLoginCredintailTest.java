package TestYou.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import TestYou.base.BaseClass;
import TestYou.pages.LoginPage;

public class InvalidLoginCredintailTest extends BaseClass {

	LoginPage loginPage;
	private boolean isLoginSuccess;

	@BeforeClass
	@Parameters({ "url", "browserName", "headless" })
	public void playwrightStartup(@Optional("https://www.testyou.in/Login.aspx") String url,
			@Optional("chrome") String browserName, @Optional("false") String headless) {
		launchPlaywright(browserName, headless);
		launchApplication(url);
	}

	@Test(priority = 1)
	@Parameters({ "username", "password" })
	public void loginTest(@Optional("Admin") String username, @Optional("admin123") String password) {
		loginPage = new LoginPage(page);
		isLoginSuccess = loginPage.login(username, password);
	}

	@Test(priority = 2)
	@Parameters({ "username", "password" })
	public void AssertErrorTest() {
		Assert.assertEquals(isLoginSuccess, false);
	}

	@AfterClass
	public void playwrightClose() {
		closePlaywright();
	}
}
