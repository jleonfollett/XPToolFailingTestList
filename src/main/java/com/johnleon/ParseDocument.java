package com.johnleon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jsoup.nodes.Document;

public class ParseDocument {
	ArrayList<String> list = new ArrayList<String>();

	ParseDocument(Document doc){
		List<String> listOfLines = DocumentToList(doc);
		ParseList(listOfLines);
	}

	// Turns the document into a list of lines
	public List<String> DocumentToList(Document doc){
		return Arrays.asList(doc.toString().split("\n"));
	}

	// Parses the list for "com.follett" to find the class path needed
	public void ParseList(List<String> listOfLines) {
		for(String line: listOfLines) {
			if(line.contains("com.follett")) {
				String classPath = line.substring(line.indexOf("com."), line.indexOf("["));
				if(!list.contains(classPath)) {
					list.add(classPath);
				}
			}
		}
	}

	public ArrayList<String> getList() {
		return list;
	}
}
