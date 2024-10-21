package com.qa.appname.pages;

import com.microsoft.playwright.Page;
import com.qa.appname.listeners.ExtentReportListener;

public class LoginPage {

	private Page page;

	// 1. String Locators - OR
	private String emailId = "//input[@id='input-email']";
	private String password = "//input[@id='input-password']";
	private String loginBtn = "//input[@value='Login']";
	private String forgotPwdLink = "//div[@class='form-group']//a[normalize-space()='Forgotten Password']";
	private String logoutLink = "//a[@class='list-group-item'][normalize-space()='Logout']";

	// 2. page constructor:
	public LoginPage(Page page) {
		this.page = page;
	}
	
	// 3. page actions/methods:
	public String getLoginPageTitle() {
		ExtentReportListener.getTest().info("Fetching login page title");
		String title = page.title();
		ExtentReportListener.getTest().info("Login page title: " + title);
		return page.title();
	}
	
	public boolean isForgotPwdLinkExist() {
		ExtentReportListener.getTest().info("Checking if 'Forgot Password' link is visible");
		boolean isVisible = page.isVisible(forgotPwdLink);
		ExtentReportListener.getTest().info("'Forgot Password' link visibility: " + isVisible);
		return page.isVisible(forgotPwdLink);
	}
	
	public boolean doLogin(String appUserName, String appPassword) {
		ExtentReportListener.getTest().info("Attempting to login");
		System.out.println("App creds: " + appUserName + ":" + appPassword);
		page.fill(emailId, appUserName);
		page.fill(password, appPassword);
		page.click(loginBtn);
//		page.locator(logoutLink).waitFor();
//		if(page.locator(logoutLink).isVisible()) {
//			System.out.println("user is logged in successfully....");
//			return true;
//		}else {
//			System.out.println("user is not logged in successfully....");
//			return false;
//		}
		ExtentReportListener.getTest().info("User login failed (returning false for testing purposes)");
		return false; //nilagay ko lang to return na false to para mag fail. Delete nalang later at i-uncomment yung if else
	}
}
