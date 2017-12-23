package com.booker.framework.ui.controls;

import org.openqa.selenium.By;
import com.booker.framework.ui.Page;


public class Field extends Control {

	public Field(Page page, By locator) {
		super(page, locator);
	}

	public void waitForVisbility() {
    	this.isPresent();
    	this.isVisible();
	}
}
