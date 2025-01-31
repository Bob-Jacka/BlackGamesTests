package org.example.core.enums;

import lombok.Getter;

@Getter
@Deprecated(since = "31.01.2025")
public enum GameName {

    MOOSCAPE("Mooscape"),
    LUCKY_FISH("Lucky fish"),
    COLOR_RACE("Color race"),
    PIRATE("Pirate flipping coins");

    private final String name;

    GameName(String name) {
        this.name = name;
    }

    /**
     * @param stage_name string that represents stage name
     * @return Stage new object
     */
    public static GameName reverse_getting(String stage_name) {
        GameName gameName = null;
        switch (stage_name) {
            case "Mooscape": {
                gameName = MOOSCAPE;
                break;
            }
            case "Lucky fish": {
                gameName = LUCKY_FISH;
                break;
            }
            case "Color race": {
                gameName = COLOR_RACE;
                break;
            }
            case "Pirate flipping coins": {
                gameName = PIRATE;
                break;
            }
        }
        return gameName;
    }
}
