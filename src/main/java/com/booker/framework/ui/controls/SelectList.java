package com.booker.framework.ui.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.booker.framework.ui.Page;

public class SelectList extends Control {

	public SelectList(Page page, By locator) {
		super(page, locator);
	}

	public Select getSelect() {
		return new Select(this.getElement());
	}
	public void selectByText(String value) {
		this.exists();
		this.getSelect().selectByVisibleText(value);
	}
}
