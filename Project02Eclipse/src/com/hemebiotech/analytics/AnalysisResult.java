package com.hemebiotech.analytics;

import java.io.IOException;

/*
 * Return a text file named "result.txt" with a list of symptoms and their occurrence
 */

public class AnalysisResult {
	
	public static void main(String args[]) throws IOException {
		
		
		AnalyticsCounter test = new AnalyticsCounter("symptoms.txt");
		test.symptomsList();
		test.writeResult();
		
		
	}

}
