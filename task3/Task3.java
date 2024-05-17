package org.example.task3;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.task3.structure.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        final String VALUES = args[0];
        final String TESTS = args[1];
        final String REPORT = args[2];

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode valuesNode = null;
            valuesNode = objectMapper.readTree(new File(VALUES)).get("values");
            HashMap<Integer, String> values = new HashMap<>();
            for (JsonNode node : valuesNode) {
                values.put(
                        node.get("id").asInt(),
                        node.get("value").asText()
                );
            }

            JsonNode testsNode = objectMapper.readTree(new File(TESTS)).get("tests");
            List<Test> tests = new ArrayList<>();
            for (JsonNode node : testsNode) {
                Test test = new Test(
                        node.get("id").asInt(),
                        node.get("title").asText()
                );
                if (node.has("values")) {
                    List<Test> testValues = new ArrayList<>();
                    for (JsonNode node1 : node.get("values")) {
                        Test test1 = new Test(
                                node1.get("id").asInt(),
                                node1.get("title").asText()
                        );
                        if (node1.has("values")) {
                            List<Test> testValues1 = new ArrayList<>();
                            for (JsonNode node2 : node1.get("values")) {
                                Test test2 = new Test(
                                        node2.get("id").asInt(),
                                        node2.get("title").asText()
                                );
                                if (node2.has("values")) {
                                    List<Test> testValues2 = new ArrayList<>();
                                    for (JsonNode node3 : node2.get("values")) {
                                        Test test3 = new Test(
                                                node3.get("id").asInt(),
                                                node3.get("title").asText()
                                        );
                                        testValues2.add(test3);
                                    }
                                    test2.setValues(testValues2);
                                }
                                testValues1.add(test2);
                            }
                            test1.setValues(testValues1);
                        }
                        testValues.add(test1);
                    }
                    test.setValues(testValues);
                }
                tests.add(test);
            }

            for (Test test : tests) {
                test.setValue(values.get(test.getId()));
                if (test.getValues() != null) {
                    for (Test test1 : test.getValues()) {
                        test1.setValue(values.get(test1.getId()));
                        if (test1.getValues() != null) {
                            for (Test test2 : test1.getValues()) {
                                test2.setValue(values.get(test2.getId()));
                                if (test2.getValues() != null) {
                                    for (Test test3 : test2.getValues()) {
                                        test3.setValue(values.get(test3.getId()));
                                    }
                                }
                            }
                        }
                    }
                }
            }

            File file = new File(REPORT);
            objectMapper.writeValue(file, tests);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
