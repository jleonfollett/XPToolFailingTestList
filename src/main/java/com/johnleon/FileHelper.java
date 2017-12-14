package com.johnleon;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileHelper {
	private static BufferedWriter bw = null;
	private static FileWriter fw = null;

	public static void WriteFile(ArrayList<String> listOfLines) throws IOException {
		setupFileWriters();
		writeLines(listOfLines);
		closeFileWriters();
	}
	
	private static void setupFileWriters() throws IOException{
		fw = new FileWriter(Configuration.getProperty("output"));
		bw = new BufferedWriter(fw);
	}

	private static void closeFileWriters() throws IOException{
		bw.flush();
		bw.close();
	}

	private static void writeLines(ArrayList<String> listOfLines) throws IOException{
		for(String line: listOfLines){
			bw.write(line);
			bw.newLine();
		}
	}
}
