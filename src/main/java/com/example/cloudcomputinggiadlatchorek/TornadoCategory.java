package com.example.cloudcomputinggiadlatchorek;

public enum TornadoCategory {
    F0(0.0),
    F1(1.0),
    F2(2.0),
    F3(3.0),
    F4(4.0),
    F5(5.0),
    UNKNOWN(-1.0);

    double value;

    TornadoCategory(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
