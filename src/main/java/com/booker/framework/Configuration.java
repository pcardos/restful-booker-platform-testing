package com.booker.framework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map.Entry;
import java.util.Properties;


public final class Configuration {
	private static Properties properties;

	public static void setSystemProperties() {
		System.setProperty("webdriver.gecko.driver",  new File("drivers/geckodriver").getAbsolutePath());
		System.setProperty("webdriver.chrome.driver", new File("drivers/chromedriver").getAbsolutePath());
	}
	
	public static void loadTestProperties() throws IOException {
		properties = new Properties();
		InputStream input = new FileInputStream(new File("src/test/resources/config.properties"));
		
		BufferedReader reader =  new BufferedReader(
				new InputStreamReader(input, StandardCharsets.UTF_8));
			
		try {
			properties.load(reader);
		} finally {
			input.close();
			reader.close();
		}
	}
	
	public static String get(String option) {
		String value = properties.getProperty(option);
		
		return value == null ? "" : value;
	}
	
	public static long getTimeout() {
		String value = get("timeout");
		return Long.parseLong(value);
	}

	public  static void printProperties() {
		for (Entry<Object, Object> entry : properties.entrySet()) {
			System.out.println(String.format("%s=%s", entry.getKey(), entry.getValue()));
		}
	}
}
