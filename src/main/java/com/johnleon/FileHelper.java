package com.johnleon;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileHelper {

	public static void WriteFile(ArrayList<String> listOfLines) throws IOException {
		BufferedWriter bw = null;
		FileWriter fw = null;

		fw = new FileWriter("output.txt");
		bw = new BufferedWriter(fw);
		for(String line: listOfLines){
			bw.write(line);
			bw.newLine();
		}
		bw.flush();
		bw.close();

	}
}
