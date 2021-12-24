package com.hemebiotech.analytics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.TreeMap;

/*
 * Analyze the occurrence of all the symptoms 
 */

public class AnalyticsCounter {
	
	private String fileLink;
	private TreeMap<String , Integer> list = new TreeMap<String , Integer>();
	public AnalyticsCounter (String fileLink) {
		this.fileLink = fileLink;
	}
	
	/*
	 * @param Use the TreeMap from GetSymptomsData in replacing all null value by the occurrence of each symptoms
	 */
	
	public void symptomsList () {
		ReadSymptomDataFromFile test = new ReadSymptomDataFromFile(fileLink);
		TreeMap<String, Integer> list = new TreeMap<String, Integer>();
		Counter occurrence = new Counter (test.symptomsList());
		
		for (String key : test.symptomsList()) {
			try {
				list.put(key, occurrence.counter(key));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		this.list.putAll(list);

	}
	
	
	
	public void writeResult () throws IOException {
		
		Set<String> keys = list.keySet();
		FileWriter writer = new FileWriter (new File ("result.out"));
		
		
        for(String key: keys){
            writer.write(key + " : " + list.get(key) + "\n");
        }
		writer.close();
	}

}
