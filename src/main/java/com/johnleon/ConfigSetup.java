package com.johnleon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigSetup {
	public Properties setUp() throws FileNotFoundException, IOException{
		Properties config = new Properties();
		config.load(new FileInputStream("config.properties"));
		return config;
	}
}
