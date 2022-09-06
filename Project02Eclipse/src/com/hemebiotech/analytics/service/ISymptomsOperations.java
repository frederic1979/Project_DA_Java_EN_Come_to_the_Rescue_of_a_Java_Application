package com.hemebiotech.analytics.service;
import java.util.List;
import java.util.Map;

public interface ISymptomsOperations {
    /**
     *
     * @return a map with key as symptoms name and value the count of it
     */
    Map<String, Long> symptomsAndCount(List<String> symptoms);

}
