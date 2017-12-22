package com.booker.tests;

import java.util.Arrays;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.booker.framework.Configuration;
import com.booker.framework.Driver;
import com.booker.tests.pages.BookerPage;


@RunWith(Parameterized.class)
public class CreateAndDeleteEntriesTest {
    private static WebDriver driver;
    private static BookerPage booker; 
	String hotelName, hotelAddress, hotelOwner, hotelPhone, hotelEmail;
    
    public CreateAndDeleteEntriesTest(String hotelName, String hotelAddress, String hotelOwner, String hotelPhone, String hotelEmail) {
		super();
		this.hotelName    = hotelName;
		this.hotelAddress = hotelAddress;
		this.hotelOwner   = hotelOwner;
		this.hotelPhone   = hotelPhone;
		this.hotelEmail   = hotelEmail;
	}
    
    @Parameters
    public static Collection<Object[]> getParameters() {
    	return Arrays.asList(
    			new Object[][] {
    				{"Ritz",        "1 Backer St, London, N1 1WT",       "John",   "07577777771", "john@ritz.com" },
    				{"Holiday Inn", "45 Buchan Close, Norwich, NR1 1DT", "Lilian", "07577777772", "lili@holliday-inn.com" },
    				{"Pedro's B&B", "1 High St, London, W1 1ST",         "Pedro",  "07577777773", "pedro@protonmail.com" },
    				{"Travel Lodge","1 Basset St, Southampton, SO1 1FF", "Mike",   "07577777773", "mike@travel-lodge.com" },
    				{"Premier Inn", "3 Kings Road, Cambridge, CA1 1ER",  "Neil",   "07577777777", "neil@premier-inn.com" }
    			});
    }

	@BeforeClass
    public static void setUp() throws Exception {
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
    public void testCreateAndDeleteEntry() throws InterruptedException {
    	booker.createHotelEntry(hotelName, hotelAddress, hotelOwner, hotelPhone, hotelEmail);
    	booker.deleteEntry();
	}

    @AfterClass
    public static void quitDriver() {
    	driver.quit();
    }
}

