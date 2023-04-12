package codegym.model;

import lombok.Data;

public @Data class Counter {
    private int count;

    public void increment() {
        count++;
    }
}
