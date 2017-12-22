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


public class DeleteEntryTest {
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
	    booker.createHotelEntry(Configuration.get("hotelName"), 
	    		Configuration.get("hotelAddress"), 
	    		Configuration.get("hotelOwner"), 
	    		Configuration.get("hotelPhone"), 
	    		Configuration.get("hotelEmail"));
    }
    
    @Test
    public void testDeleteEntry() throws InterruptedException {
    	booker.deleteEntryAndWaitUntilNotPresent();
    	
		assertFalse(booker.hotelNameField.exists(0));
		assertFalse(booker.hotelAddressField.exists(0));
		assertFalse(booker.hotelOwnerField.exists(0));
		assertFalse(booker.hotelPhoneField.exists(0));
		assertFalse(booker.hotelEmailField.exists(0));
    }
    
    @After
    public void quitDriver() {
        driver.quit();
    }
}

