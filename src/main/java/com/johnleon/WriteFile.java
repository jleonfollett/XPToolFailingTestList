package com.johnleon;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteFile {

	public WriteFile(ArrayList<String> listOfLines) throws IOException {
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			fw = new FileWriter("C:\\File\\output.txt");
			bw = new BufferedWriter(fw);
			for(String line: listOfLines){
				bw.write(line);
				bw.newLine();
			}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Error" + e.getMessage());
			}
			bw.flush();
			bw.close();
		
	}

}
