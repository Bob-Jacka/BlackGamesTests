package org.example.core.enums;

public enum Env {

    ENV02("env02"),
    ENV03("env03");

    private final String val;

    Env(String env) {
        this.val = env;
    }

    public String getValue() {
        return val;
    }
}
