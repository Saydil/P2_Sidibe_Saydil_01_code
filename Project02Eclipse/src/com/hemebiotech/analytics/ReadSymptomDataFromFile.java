package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Collect all the symptoms in a TreeMap without setup the value
 */

public class ReadSymptomDataFromFile implements ISymptomReader{
	
	private String file;
	/**
	 * 
	 * @param full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String file) {
		this.file = file;
	}
	
	/*
	 * @return the symptoms list in a ArrayList
	 */
	
	@Override
	public ArrayList<String> symptomsList() {
		ArrayList<String> result = new ArrayList<String>();
		if (file != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(file));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
