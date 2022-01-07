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
	/*
	 * @param fileLink , a full or partial path to file with symptom strings in it, one per line
	 */
	public AnalyticsCounter (String fileLink) {
		this.fileLink = fileLink;
	}
	
	/*
	 * @return list , a TreeMap with symptoms as keys and their occurrence as value
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
	
	/*
	 * @return a display of the TreeMap
	 */
	
	public void writeResult () throws IOException {
		
		Set<String> keys = list.keySet();
		FileWriter writer = new FileWriter (new File ("result.out"));
		
		
        for(String key: keys){
            writer.write(key + " : " + list.get(key) + "\n");
        }
		writer.close();
	}

}
