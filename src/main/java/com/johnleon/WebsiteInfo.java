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

	//	// Takes a website file and turns it into a document. UNCOMMENT TO USE FOR LOCAL HTML/HTM FILE 
	//	public WebsiteInfo() throws IOException {
	//		File input = new File(Main.config.getProperty("website"));
	//		document = Jsoup.parse(input, "UTF-8", "");
	//	}

	// Gets the login cookies from the login website and uses them to make a get request to get the website info 
	public WebsiteInfo() throws IOException {
		cookies = getCookies(loginWebsite());
		document = getDocumentFromSite(cookies, Main.config.getProperty("website"));
	}

	// Attempts to  login to the XPtool by making a POST request with data from config.properties
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

	public Document getDocumentFromSite(Map<String, String> loginCookies, String url) throws IOException{
		return Jsoup.connect(url)
				.cookies(loginCookies)
				.get();
	}

	public Document getDocument() {
		return document;
	}
}


