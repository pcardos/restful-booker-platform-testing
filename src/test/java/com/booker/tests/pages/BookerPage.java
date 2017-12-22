package com.booker.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.booker.framework.Configuration;
import com.booker.framework.ui.Page;
import com.booker.framework.ui.controls.Button;
import com.booker.framework.ui.controls.Control;
import com.booker.framework.ui.controls.Edit;
import com.booker.framework.ui.controls.PopUp;

public class BookerPage extends Page {
	Edit hotelNameBox;
	Edit hotelAddressBox;
	Edit hotelOwnerBox;
	Edit hotelPhoneBox;
	Edit hotelEmailBox;
	Button createHotelButton;
	Button deleteHotelButton;
	Button loginButton;
	Edit loginusernameBox;
	Edit loginPasswordBox;
	PopUp loginPopUp;
	Button doLoginButton;

	public Control hotelNameField;
	public Control hotelAddressField;
	public Control hotelOwnerField;
	public Control hotelPhoneField;
	public Control hotelEmailField;
	
	public BookerPage(WebDriver driver) {
		super(driver);
		
		this.hotelNameBox      = new Edit(this,   By.id("hotelName"));
		this.hotelAddressBox   = new Edit(this,   By.id("address"));
		this.hotelOwnerBox     = new Edit(this,   By.id("owner"));
		this.hotelPhoneBox     = new Edit(this,   By.id("phone"));
		this.hotelEmailBox     = new Edit(this,   By.id("email"));
		this.createHotelButton = new Button(this, By.id("createHotel"));
		this.deleteHotelButton = new Button(this, By.xpath("//*[@class=\"glyphicon glyphicon-remove hotelDelete\"]"));
		
		this.loginButton       = new Button(this, By.linkText("Login"));
		this.loginusernameBox  = new Edit(this,   By.xpath("//*[@id=\"username\"]"));
		this.loginPasswordBox  = new Edit(this,   By.xpath("//*[@id=\"password\"]"));
		this.loginPopUp        = new PopUp(this,  By.xpath("/html/body/div[1]/nav/div[2]/div"));
		this.doLoginButton     = new Button(this, By.xpath("//*[@id=\"doLogin\"]"));
		
		this.hotelNameField    = new Control(this, By.xpath("//div[2]/div/div/p"));
		this.hotelAddressField = new Control(this, By.xpath("//div[2]/div/div[2]/p"));;
		this.hotelOwnerField   = new Control(this, By.xpath("//div[2]/div/div[3]/p"));;
		this.hotelPhoneField   = new Control(this, By.xpath("//div[2]/div/div[4]/p"));;
		this.hotelEmailField   = new Control(this, By.xpath("//div[2]/div/div[5]/p"));;
	}
	
	public Page navigate() {
	    String url = Configuration.get("url");
	    this.getDriver().get(url);
	    return this;
	}
	
    public void login(String user, String password) {    	
    	loginButton.click();
    	loginPopUp.waitForVisbility();
    	loginusernameBox.setText(user);
    	loginPasswordBox.setText(password);
    	doLoginButton.click();
    }
	
	public void createHotelEntry(String name, String address, String owner, String phone, String email) {
    	hotelNameBox.setText(name);
		hotelAddressBox.setText(address);
		hotelOwnerBox.setText(owner);
		hotelPhoneBox.setText(phone);
		hotelEmailBox.setText(email);
    	createHotelButton.click();
	}

    public void deleteEntry() {
    	deleteHotelButton.click();
	}
    
    public void deleteEntryAndWaitUntilNotPresent() {
    	deleteHotelButton.clickAndWaitUntilNotPresent();
	}
}
