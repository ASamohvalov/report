package org.example.task3.structure;

import java.util.List;

public class Test {
    private int id;
    private String title;
    private String value;
    private List<Test> values;

    public Test(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setValues(List<Test> values) {
        this.values = values;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getValue() {
        return value;
    }

    public List<Test> getValues() {
        return values;
    }
}
