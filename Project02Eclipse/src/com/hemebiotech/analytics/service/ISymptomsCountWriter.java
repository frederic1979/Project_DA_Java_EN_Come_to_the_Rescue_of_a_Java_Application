package com.hemebiotech.analytics.service;
import java.util.Map;

public interface ISymptomsCountWriter {
    /**
     * If FILENAME_IN is empty, don't erase last file
     */
    void writeSymptoms(Map<String, Long> symptomsAndCount);

}
