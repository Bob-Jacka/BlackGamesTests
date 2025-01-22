package org.example.core.enums;

import lombok.Getter;

@Getter
@Deprecated(since = "20.01.2025")
public enum Env {

    ENV02("env02"),
    ENV03("env03");

    private final String val;

    Env(String env) {
        this.val = env;
    }
}
