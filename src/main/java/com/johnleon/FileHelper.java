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
	
	public static void setupFileWriters() throws IOException{
		fw = new FileWriter(Main.config.getProperty("output"));
		bw = new BufferedWriter(fw);
	}

	public static void closeFileWriters() throws IOException{
		bw.flush();
		bw.close();
	}

	public static void writeLines(ArrayList<String> listOfLines) throws IOException{
		for(String line: listOfLines){
			bw.write(line);
			bw.newLine();
		}
	}
}
