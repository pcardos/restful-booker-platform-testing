package com.booker.framework.ui.controls;

import org.openqa.selenium.By;

import com.booker.framework.ui.Page;


public class PopUp extends Control {
	
	public PopUp(Page page, By locator) {
		super(page, locator);
	}
	
	public void waitForVisbility() {
    	this.exists();
    	this.isVisible();
	}
}
