package org.example.core.enums;

import lombok.Getter;

@Getter
public enum GameName {

    MOOSCAPE("Mooscape"),
    LUCKY_FISH("Lucky Fish"),
    COLOR_RACE("Color Race"),
    PIRATE("Pirate flipping coins");

    private final String name;

    GameName(String name) {
        this.name = name;
    }
}
