package com.hemebiotech.analytics;
import com.hemebiotech.analytics.service.ISymptomsReader;
import com.hemebiotech.analytics.service.ISymptomsCountWriter;
import com.hemebiotech.analytics.service.impl.ReaderImpl;
import com.hemebiotech.analytics.service.impl.WriterImpl;
import com.hemebiotech.analytics.service.ISymptomsOperations;
import com.hemebiotech.analytics.service.impl.SymptomsOperationsImpl;

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
	 * fetch all symptoms by reading in FILENAME_IN
	 * count symptoms and create map
	 * write in FILENAME_OUT
	 */
	public static void countAndSortSymptoms() {
		ISymptomsReader readSymptomDataFromFile = new ReaderImpl(PATH+FILENAME_IN);
		List<String> symptoms = readSymptomDataFromFile.getSymptoms();

		ISymptomsOperations symptomsOperations = new SymptomsOperationsImpl();
		Map<String, Long> symptomsAndCount = symptomsOperations.symptomsAndCount(symptoms);

		ISymptomsCountWriter writer = new WriterImpl(PATH+FILENAME_OUT);
		writer.writeSymptoms(symptomsAndCount);
	}

}
