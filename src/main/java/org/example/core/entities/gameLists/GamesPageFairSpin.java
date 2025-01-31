package org.example.core.entities.gameLists;

import com.codeborne.selenide.ElementsCollection;
import org.example.core.annotations.BetGamesPage;
import org.example.core.enums.GameName;
import org.example.core.games.sc_games.ColorRace;
import org.example.core.games.sc_games.LuckyFish;
import org.example.core.games.sc_games.Mooscape;
import org.example.core.games.sc_games.Pirate;
import org.example.core.main_functionalities.IGame;
import org.example.core.main_functionalities.IGameList;
import org.example.core.main_functionalities.IGameSC;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;

import static org.example.core.enums.GameId.COLOR_RACE_ENV2;
import static org.example.core.enums.GameName.COLOR_RACE;
import static org.example.core.main_functionalities.ActionController.get_elements;

@BetGamesPage
public class GamesPageFairSpin implements IGameList {

    //TODO доделать класс
    private final ElementsCollection gameList = get_elements("//div[@id='gameList']/div");

    public GamesPageFairSpin() {

    }

    @NotNull
    private IGameSC get_colorRace_game() {
        gameList.get(COLOR_RACE_ENV2.getId()).find(By.linkText(COLOR_RACE.getName())).click();
        return new ColorRace();
    }

    @NotNull
    private IGameSC get_luckyFish_game() {
        gameList.get(COLOR_RACE_ENV2.getId()).find(By.linkText(COLOR_RACE.getName())).click();
        return new LuckyFish();
    }

    @NotNull
    private IGameSC get_mooscape_game() {
        gameList.get(COLOR_RACE_ENV2.getId()).find(By.linkText(COLOR_RACE.getName())).click();
        return new Mooscape();
    }

    @NotNull
    private IGameSC get_pirate_game() {
        gameList.get(COLOR_RACE_ENV2.getId()).find(By.linkText(COLOR_RACE.getName())).click();
        return new Pirate();
    }

    @Override
    public @NotNull IGame get_game(@NotNull String game) {
        IGame game_to_return = null;
        GameName gameName = GameName.valueOf(game);
        switch (gameName) {
            case COLOR_RACE -> game_to_return = get_colorRace_game();
            case PIRATE -> game_to_return = get_pirate_game();
            case MOOSCAPE -> game_to_return = get_mooscape_game();
            case LUCKY_FISH -> game_to_return = get_luckyFish_game();
        }
        return game_to_return;
    }

    @Override
    public @NotNull ElementsCollection getGameList() {
        return gameList;
    }
}