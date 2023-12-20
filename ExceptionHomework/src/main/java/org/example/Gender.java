package org.example;

public enum Gender {
    M("M"),F("F");
    private final String name;

    Gender(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "name='" + name + '\'' +
                '}';
    }
}
