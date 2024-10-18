package org.example.core.enums;

public enum GameName {

    MOOSCAPE("Mooscape"),
    LUCKY_FISH("Lucky Fish"),
    COLOR_RACE("Color Race"),
    PIRATE("Pirate flipping coins");

    private String name;

    GameName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
