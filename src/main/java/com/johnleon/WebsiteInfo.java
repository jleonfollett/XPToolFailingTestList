package com.johnleon;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class WebsiteInfo {
	Document document;
	Map<String, String> cookies;
	public Properties config = new Properties();

	public WebsiteInfo() throws IOException {
		config.load(new FileInputStream("config.properties"));
		File input = new File(config.getProperty("website"));
		document = Jsoup.parse(input, "UTF-8", "");
	}

	public WebsiteInfo(String url) throws IOException {
		cookies = getCookies(loginWebsite());
		document = Jsoup.connect(url)
				.cookies(cookies)
				.get();
	}
	
	public Connection.Response loginWebsite() throws IOException {
		Properties config = new Properties();
		config.load(new FileInputStream("config.properties"));
		String username = config.getProperty("username"); 
		String password = config.getProperty("password");
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
	
	public void setDocument(Document document) {
		this.document = document;
	}
}


