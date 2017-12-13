package com.johnleon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jsoup.nodes.Document;

public class Main {
	static ArrayList<String> list = new ArrayList<String>();
	public static void main(String[] args) {
		Document doc = null;
		try {
			doc = new WebsiteInfo("C:\\Tools\\Acceptance Tests.htm", true).getDocument();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			new WriteFile(new ParseDocument(doc).getList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
