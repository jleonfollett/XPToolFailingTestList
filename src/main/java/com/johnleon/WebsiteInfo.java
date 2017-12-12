package com.johnleon;

import java.io.IOException;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.nodes.Document;

public class WebsiteInfo {
Document document;
	

	public WebsiteInfo(String url) {
		  try {
				//With this you login and a session is created
			    Connection.Response res = Jsoup.connect("http://destinyxptool.fsc.follett.com/xptool/base.login.do")
			        .data("loginName", "jleon", "password", "test")
			        .method(Method.POST)
			        .execute();

			//This will get you cookies
			Map<String, String> loginCookies = res.cookies();

			//Here you parse the page that you want. Put the url that you see when you have logged in
			document = Jsoup.connect(url)
			      .cookies(loginCookies)
			      .get();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	  
	}
 
	public Document getDocument() {
		return document;
	}
  public void setDocument(Document document) {
		this.document = document;
	}
	}


