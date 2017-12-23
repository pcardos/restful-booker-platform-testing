package com.booker.framework.ui;

import org.openqa.selenium.WebDriver;


public class Page {
	private WebDriver driver;
	
	public Page(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public Page navigate() {
		return this;
	}
}
