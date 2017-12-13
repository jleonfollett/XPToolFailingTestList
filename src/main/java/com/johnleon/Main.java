package com.johnleon;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

import org.jsoup.nodes.Document;

public class Main {
	static ArrayList<String> list = new ArrayList<String>();
	public static Properties config;
	public static void main(String[] args) {
		try {
			config = new Properties();
			config.load(new FileInputStream("config.properties"));
			Document doc = new WebsiteInfo(config.getProperty("website")).getDocument();
			FileHelper.WriteFile(new ParseDocument(doc).getList());
		} catch (Exception e) {
			System.out.println("Error occured " + e.getMessage());
		}
	}
}
