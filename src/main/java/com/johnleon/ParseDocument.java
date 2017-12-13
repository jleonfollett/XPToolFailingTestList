package com.johnleon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jsoup.nodes.Document;

public class ParseDocument {
	ArrayList<String> list = new ArrayList<String>();
	public ArrayList<String> getList() {
		return list;
	}
	ParseDocument(Document doc){
		List<String> test = Arrays.asList(doc.toString().split("\n"));
		for(String line: test) {
			if(line.contains("com.follett")) {
				String classPath = line.substring(line.indexOf("com."), line.indexOf("["));
				if(!list.contains(classPath)) {
				list.add(classPath);
				}
			}
		}
		System.out.println(list);
	}
}
