package com.johnleon;

import java.util.ArrayList;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hi! :)");
		Document doc = new WebsiteInfo("http://destinyxptool.fsc.follett.com/xptool/xp.failingtestsbyrun.do?latestRunID=75342&firstRunID=75340&forceSubmit=yes&runType=at").getDocument();
		Elements list = doc.getElementsByAttributeValueStarting("name", "com.follett");
		System.out.println(list);
	}

}
