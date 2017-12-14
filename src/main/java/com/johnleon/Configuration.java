package com.johnleon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
	
	private static Properties config = new Properties();
	
	private static final String CONFIG_FILE = "config.properties";
	
	public static Properties setUp() throws FileNotFoundException, IOException{
		config.load(new FileInputStream(CONFIG_FILE));
		return config;
	}
	
	public static String getProperty(String propertyName) {
		return config.getProperty(propertyName);
	}
}
