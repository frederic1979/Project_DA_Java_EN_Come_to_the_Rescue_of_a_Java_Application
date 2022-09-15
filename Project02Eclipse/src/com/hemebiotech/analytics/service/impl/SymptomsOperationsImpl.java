package com.hemebiotech.analytics.service.impl;

import com.hemebiotech.analytics.service.ISymptomsOperations;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SymptomsOperationsImpl implements ISymptomsOperations {

    @Override
    public Map<String, Long> symptomsAndCount(List<String> symptoms){
        return symptoms.stream()
                // List<String> become a stream and we could use .collect
                .collect(Collectors.groupingByConcurrent(s -> s, Collectors.counting()))
                // .entrySet() give us a set view of mapping fever = 3 etc...
                .entrySet().stream()
                // .stream in order to use method .sorted by the key, here symptom
                .sorted(Map.Entry.comparingByValue())
                // then collect
                .collect(Collectors.toMap(
                        // implements Function IF to mapp
                        stringLongEntry -> stringLongEntry.getKey(),
                        // implements Function IF to mapp
                        o -> o.getValue(),
                        // implements Function IF BinaryOperator to merge
                        (oldValue, newValue) -> oldValue,
                        // implements Function IF Supplier , it return the new LinkedHashMap
                        () -> new LinkedHashMap<>())
                );


    }

}
