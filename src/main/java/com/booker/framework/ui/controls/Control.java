package com.booker.framework.ui.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.booker.framework.Configuration;
import com.booker.framework.ui.Page;


public class Control {
	public static final long TIMEOUT = Configuration.getTimeout();
	Page page;
	WebDriverWait wait;
	By locator;
	
	public Control(Page page, By locator) {
		super();
		this.page = page;
		this.locator = locator;
	}

	public WebElement getElement() {
		return page.getDriver().findElement(locator);
	}

	public boolean isPresent(long timeout) {
		wait = new WebDriverWait(page.getDriver(), timeout);
		try {
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		} catch (TimeoutException e) {
			return false;
		}
		
		return true;
	}
	
	public boolean isPresent() {
		return isPresent(TIMEOUT);
	}
	
	public void click() {
		isPresent();
		this.getElement().click();
	}
	
	public boolean isVisible(long timeout) {
		wait = new WebDriverWait(page.getDriver(), timeout);
		try {
			wait.until(ExpectedConditions.visibilityOf(this.getElement()));
		} catch (TimeoutException e) {
			return false;
		}
		
		return true;
	}
	
	public boolean isVisible() {
    	return isVisible(TIMEOUT);
	}
	
	public boolean isNotPresent(long timeout) {
		wait = new WebDriverWait(page.getDriver(), timeout);
		try {
			wait.until(ExpectedConditions.stalenessOf(this.getElement()));
		} catch (TimeoutException e) {
			return false;
		}
		
		return true;
	}
	
	public boolean isNotPresent() {
    	return isNotPresent(TIMEOUT);
	}

	public void clickAndWaitUntilNotPresent(long timeout) {
		click();
		isNotPresent();	
	}
	
	public void clickAndWaitUntilNotPresent() {
		clickAndWaitUntilNotPresent(TIMEOUT);
	}
}
