package org.example.core.enums;

public enum GameId {

    COLOR_RACE_ENV2(3),
    COLOR_RACE_ENV3(COLOR_RACE_ENV2.id + 1),
    LUCKY_FISH_ENV2(1),
    LUCKY_FISH_ENV3(LUCKY_FISH_ENV2.id + 1),
    MOOSCAPE_ENV2(7),
    MOOSCAPE_ENV3(MOOSCAPE_ENV2.id + 1),
    PIRATE_ENV2(5),
    PIRATE_ENV3(PIRATE_ENV2.id + 1);

    private final int id;

    GameId(int i) {
        this.id = i;
    }

    public int getId() {
        return id;
    }
}
