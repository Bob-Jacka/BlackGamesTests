package org.example.core.entities.GameLists;

import com.codeborne.selenide.ElementsCollection;
import org.example.core.enums.Env;
import org.example.core.pages.SC_games.*;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;
import static org.example.core.Functional.ActionController.waitFor;
import static org.example.core.enums.GameId.COLOR_RACE_ENV2;
import static org.example.core.enums.GameName.COLOR_RACE;

@Component
public class GamesPageFairSpin implements IGameList {

    //TODO переделать класс
    private final ElementsCollection gameList = $$(By.xpath("//div[@id='gameList']/div"));

    @NotNull
    public Game getColorRace_game(Env env) {
        waitFor(1);
        gameList.get(COLOR_RACE_ENV2.getId()).find(By.linkText(COLOR_RACE.getName())).click();
        return new ColorRace();
    }

    @NotNull
    public Game getLuckyFish_game(Env env) {
        waitFor(1);
        gameList.get(COLOR_RACE_ENV2.getId()).find(By.linkText(COLOR_RACE.getName())).click();
        return new LuckyFish();
    }

    @NotNull
    public Game getMooscape_game(Env env) {
        waitFor(1);
        gameList.get(COLOR_RACE_ENV2.getId()).find(By.linkText(COLOR_RACE.getName())).click();
        return new Mooscape();
    }

    @NotNull
    public Game getPirate_game(Env env) {
        waitFor(1);
        gameList.get(COLOR_RACE_ENV2.getId()).find(By.linkText(COLOR_RACE.getName())).click();
        return new Pirate();
    }
}