package com.booker.framework.ui.controls;

import org.openqa.selenium.By;

import com.booker.framework.ui.Page;


public class Edit extends Control {
	
	public Edit(Page page, By locator) {
		super(page, locator);
	}
	
	public void setText(String value) {
		this.exists();
		this.click();
		this.getElement().click();
		this.getElement().clear();
		this.getElement().sendKeys(value);
	}
}