package com.johnleon;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class WebsiteInfo {
	Document document;
	Map<String, String> cookies;

	// Takes a website file and turns it into a document.  ONLY used for 
	public WebsiteInfo() throws IOException {
		File input = new File(Main.config.getProperty("website"));
		document = Jsoup.parse(input, "UTF-8", "");
	}
	
	// Gets the login cookies from the login website and uses them to make a get request to get the website info 
	public WebsiteInfo(String url) throws IOException {
		cookies = getCookies(loginWebsite());
		document = Jsoup.connect(url)
				.cookies(cookies)
				.get();
	}
	
	// Attempts to  login to the xptool by making a POST request with data from config.properties
	public Connection.Response loginWebsite() throws IOException {
		String username = Main.config.getProperty("username"); 
		String password = Main.config.getProperty("password");
		Connection.Response res = Jsoup.connect("http://destinyxptool.fsc.follett.com/xptool/base.login.do")
				.data("loginName", username, "password", password)
				.method(Method.POST)
				.execute();
		return res;
	}
	
	public Map<String, String> getCookies(Connection.Response website) {
		Map<String, String> loginCookies = website.cookies();
		return loginCookies;
	}

	public Document getDocument() {
		return document;
	}
}


