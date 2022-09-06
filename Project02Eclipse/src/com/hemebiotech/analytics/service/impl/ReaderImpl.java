package com.hemebiotech.analytics.service.impl;

import com.hemebiotech.analytics.service.ISymptomsReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 *
 */
public class ReaderImpl implements ISymptomsReader {

	private String filepath;

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReaderImpl(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<>();

		if (filepath != null) {
			try {
				// fileReader creation in order to read file
				FileReader fileReader = new FileReader(filepath);
				// bufferedReader creation using fileReader
				BufferedReader reader = new BufferedReader(fileReader);

				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					// read next line
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
