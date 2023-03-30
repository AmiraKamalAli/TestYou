package TestYou.pages;

import com.microsoft.playwright.Page;

import TestYou.base.BaseClass;

public class LoginPage extends BaseClass {

	private final Page page;

	String usernameBox = "[id='ctl00_CPHContainer_txtUserLogin']";
	String passwordBox = "[id='ctl00_CPHContainer_txtPassword']";
	String loginButton = "//*[@id='ctl00_CPHContainer_btnLoginn']";
	String error = "//span[@id='ctl00_CPHContainer_lblOutput']";

	public LoginPage(Page page) {
		this.page = page;
	}

	public boolean login(String username, String password) {
		boolean isLoginSuccess = false;
		page.fill(usernameBox, username);
		page.fill(passwordBox, password);
		page.click(loginButton);
		page.waitForSelector(error).isVisible();
		boolean isEnabled = page.isEnabled("input");
		if (isEnabled) {
			isLoginSuccess = false;
		}
		return isLoginSuccess;
	}
}
