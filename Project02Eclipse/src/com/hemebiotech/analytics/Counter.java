package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.io.IOException;

/*
 * Count the occurrence of the introduced symptom
 */

public class Counter {
	
	ArrayList <String> symptomsList = new ArrayList<String>(); 
	
	/*
	 * @param list , a ArrayList of string 
	 */
	
	public Counter (ArrayList<String> list) { 
		symptomsList = new ArrayList<String> (list);
	}
	
	/*
	 * @param symptom
	 * @return counter , the occurrence of this symptom from the ArrayList
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
