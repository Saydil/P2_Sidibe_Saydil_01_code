package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.TreeMap;

/*
 * Analyze the occurrence of all the symptoms 
 */

public class AnalyzeSymptoms {
	
	private String fileLink;
	
	/**
	 * @param fileLink a full or partial path to file with symptom strings in it, one per line
	 */
	
	public AnalyzeSymptoms (String fileLink) {
		this.fileLink = fileLink;
	}
	
	/*
	 * @param Use the List from GetSymptomsData and count the occurrence of each symptoms
	 * @return Return a TreeMap with symptoms as a key and their occurrence as a value
	 */
	
	public TreeMap<String , Integer> symptomsList () {
		GetSymptomsData test = new GetSymptomsData(fileLink);
		TreeMap<String, Integer> list = new TreeMap<String, Integer>();
		Counter occurrence = new Counter (test.symptomsList());
		
		for (String key : test.symptomsList()) {
			try {
				list.put(key, occurrence.counter(key));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

}

