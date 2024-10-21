package com.qa.appname.pages;

import com.microsoft.playwright.Page;
import com.qa.appname.listeners.ExtentReportListener;

public class HomePage {

	private Page page;
	
	// 1. String Locators - OR
	private String search = "input[name='search']";
	private String searchIcon = "div#search button";
	private String searchPageHeader = "div#content h1";
	private String loginLink = "a:text('Login')";
	private String myAccountLink = "a[title='My Account']";
	

	// 2. page constructor:
	public HomePage(Page page) {
		this.page = page;
	}

	// 3. page actions/methods:
	public String getHomePageTitle() {
		ExtentReportListener.getTest().info("Fetching home page title");
		String title =  page.title();
		System.out.println("page title: " + title);
		ExtentReportListener.getTest().info("Home page title is: " + title);
		return title;
	}

	public String getHomePageURL() {
		ExtentReportListener.getTest().info("Fetching home page URL");
		String url =  page.url();
		System.out.println("page url : " + url);
		ExtentReportListener.getTest().info("Home page URL is: " + url);
		return url;
	}

	public String doSearch(String productName) {
		ExtentReportListener.getTest().info("Searching for product: " + productName);
		page.fill(search, productName);
		ExtentReportListener.getTest().info("Product name entered: " + productName);
		page.click(searchIcon);
		ExtentReportListener.getTest().info("Clicked on search icon");
		String header =  page.textContent(searchPageHeader);
		System.out.println("search header: " + header);
		ExtentReportListener.getTest().info("Search header retrieved: " + header);
		return header;
	}
	
	public LoginPage navigateToLoginPage() {
		ExtentReportListener.getTest().info("Navigating to login page");
		page.click(myAccountLink);
		ExtentReportListener.getTest().info("Clicked on My Account link");
		page.click(loginLink);
		ExtentReportListener.getTest().info("Clicked on Login link");
		return new LoginPage(page);
	}

}
