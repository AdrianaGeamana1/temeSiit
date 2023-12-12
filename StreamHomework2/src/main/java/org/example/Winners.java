package org.example;

public enum Winners {
    WINNER("Winner"),RUNNER_UP("Runner-up"),THIRD_PLACE("Third Place");
    private String name;

    Winners(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
