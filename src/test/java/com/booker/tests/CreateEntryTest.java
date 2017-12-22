package com.booker.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.booker.framework.Configuration;
import com.booker.framework.Driver;
import com.booker.tests.pages.BookerPage;


public class CreateEntryTest {
	private WebDriver driver;
    private BookerPage booker;

	@Before
    public void setUp() throws Exception {
		Configuration.setSystemProperties();
    	Configuration.loadTestProperties();
	    Driver.add(Configuration.get("browser"), new DesiredCapabilities());

	    driver = Driver.current();
	    driver.get(Configuration.get("url"));
	    booker = new BookerPage(driver);
	    booker.navigate();
	    booker.login(Configuration.get("user"), Configuration.get("password"));
    }
    
    @Test
    public void testCreateEntry() throws InterruptedException {
    	booker.createHotelEntry(Configuration.get("hotelName"), 
    			Configuration.get("hotelAddress"), 
    			Configuration.get("hotelOwner"), 
    			Configuration.get("hotelPhone"), 
    			Configuration.get("hotelEmail"));
    	
		assertEquals(Configuration.get("hotelName"),    booker.hotelNameField.getElement().getText());
		assertEquals(Configuration.get("hotelAddress"), booker.hotelAddressField.getElement().getText());
		assertEquals(Configuration.get("hotelOwner"),   booker.hotelOwnerField.getElement().getText());
		assertEquals(Configuration.get("hotelPhone"),   booker.hotelPhoneField.getElement().getText());
		assertEquals(Configuration.get("hotelEmail"),   booker.hotelEmailField.getElement().getText());
    }
    
    @After
    public void quitDriver() {
    	booker.deleteEntry();
        driver.quit();
    }
}

