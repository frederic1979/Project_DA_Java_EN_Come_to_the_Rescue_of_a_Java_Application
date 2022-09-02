package com.hemebiotech.analytics;
import com.hemebiotech.analytics.service.ISymptomReader;
import com.hemebiotech.analytics.service.ISymptomsCountWriter;
import com.hemebiotech.analytics.service.impl.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.service.impl.Writer;
import com.hemebiotech.analytics.service.ISymptomsOperations;
import com.hemebiotech.analytics.service.impl.SymptomOperations;

import java.util.*;

import static com.hemebiotech.analytics.constant.Constant.*;

public class AnalyticsCounterApplication {

	/**
	 *
	 * Main class : use to launch the program
	 */
	public static void main(String[] args){
		countAndSortSymptoms();
	}

	/**
	 *
	 * fetch all symptoms by reading in file
	 * count symptoms and create map
	 * write in out file
	 */
	private static void countAndSortSymptoms() {
		ISymptomReader readSymptomDataFromFile = new ReadSymptomDataFromFile(PATH+FILENAME_IN);
		List<String> symptoms = readSymptomDataFromFile.getSymptoms();

		ISymptomsOperations symptomsOperations = new SymptomOperations();
		Map<String, Long> symptomsAndCount = symptomsOperations.symptomsAndCount(symptoms);

		ISymptomsCountWriter writer = new Writer(PATH+FILENAME_OUT);
		writer.writeSymptoms(symptomsAndCount);
	}

}
