package com.johnleon;

import java.util.ArrayList;
import java.util.Properties;

import org.jsoup.nodes.Document;

public class Main {
	static ArrayList<String> list = new ArrayList<String>();
	public static Properties config;

	public static void main(String[] args) {
		try {
			config = new ConfigSetup().setUp();
			Document doc = new WebsiteInfo().getDocument();
			FileHelper.WriteFile(new ParseDocument(doc).getList());
		} catch (Exception e) {
			System.out.println("Error occured " + e.getMessage());
		}
	}
}
