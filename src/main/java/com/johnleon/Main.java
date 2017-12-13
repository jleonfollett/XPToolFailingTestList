package com.johnleon;

import java.util.ArrayList;

import org.jsoup.nodes.Document;

public class Main {
	static ArrayList<String> list = new ArrayList<String>();
	public static void main(String[] args) {
		try {
			Document doc = new WebsiteInfo().getDocument();
			FileHelper.WriteFile(new ParseDocument(doc).getList());
		} catch (Exception e) {
			System.out.println("Error occured " + e.getMessage());
		}
	}
}
