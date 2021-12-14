package com.hemebiotech.analytics;

import java.util.TreeMap;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

/*
 * Return a text file named "result.out" with a list of symptoms and their occurrence
 */

public class AnalysisResult {
	
	public static void main(String args[]) throws IOException  {
		
		TreeMap<String, Integer> a = new TreeMap<String, Integer>(); 
		AnalyzeSymptoms test = new AnalyzeSymptoms("symptoms.txt");
		
		a.putAll(test.symptomsList());
		
		Set<String> keys = a.keySet();
		FileWriter writer = new FileWriter (new File ("result.out"));
		
		
        for(String key: keys){
            writer.write(key + " : " + a.get(key) + "\n");
        }
		writer.close();
	}

}
