package com.hemebiotech.analytics;

import java.util.ArrayList;

import java.io.IOException;

/*
 * Count the occurrence of the introduced symptom
 */

public class Counter {
	
	ArrayList <String> symptomsList = new ArrayList<String>(); 
	
	public Counter (ArrayList<String> list) { 
		symptomsList = new ArrayList<String> (list);
	}
	
	/*
	 * @param The counter method take a symptom in entry
	 * @return Return the occurrence of this symptom from the ArrayList
	 */
	
    
	public int counter (String symptom) throws IOException {
		int counter = 0;
	    
		for (String elem : symptomsList) {
			if (elem.equals(symptom)) {
				counter++;
			}
		}
	    
	    
	    return counter;

	}
}
