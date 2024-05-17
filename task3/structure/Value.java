package org.example.task3.structure;

public class Value {
    private int id;
    private String value;

    public Value(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}
