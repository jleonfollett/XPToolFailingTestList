package com.johnleon;

import java.io.IOException;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class WebsiteInfo {
	private Document document;
	private Map<String, String> cookies;
	private final String LOGIN_SITE = "http://destinyxptool.fsc.follett.com/xptool/base.login.do";
	private final String LOGIN_FIELD = "username";
	private final String PASSWORD_FIELD = "password";

	//	// Takes a website file and turns it into a document. UNCOMMENT TO USE FOR LOCAL HTML/HTM FILE 
	//	public WebsiteInfo() throws IOException {
	//		File input = new File(Main.config.getProperty("website"));
	//		document = Jsoup.parse(input, "UTF-8", "");
	//	}

	// Gets the login cookies from the login website and uses them to make a get request to get the website info 
	public WebsiteInfo() throws IOException {
		cookies = getCookies(loginWebsite());
		document = getDocumentFromSite(cookies, Configuration.getProperty("website"));
	}

	// Attempts to  login to the XPtool by making a POST request with data from config.properties
	private Connection.Response loginWebsite() throws IOException {
		String username = Configuration.getProperty("username"); 
		String password = Configuration.getProperty("password");
		Connection.Response res = Jsoup.connect(LOGIN_SITE)
				.data(LOGIN_FIELD, username, PASSWORD_FIELD, password)
				.method(Method.POST)
				.execute();
		return res;
	}

	private Map<String, String> getCookies(Connection.Response website) {
		Map<String, String> loginCookies = website.cookies();
		return loginCookies;
	}

	private Document getDocumentFromSite(Map<String, String> loginCookies, String url) throws IOException{
		return Jsoup.connect(url)
				.cookies(loginCookies)
				.get();
	}

	public Document getDocument() {
		return document;
	}
}


