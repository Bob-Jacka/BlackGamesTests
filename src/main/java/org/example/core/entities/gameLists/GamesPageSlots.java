package org.example.core.entities.gameLists;

import com.codeborne.selenide.ElementsCollection;
import org.example.core.annotations.BetGamesPage;
import org.example.core.main_functionalities.IGame;
import org.example.core.main_functionalities.IGameList;
import org.jetbrains.annotations.NotNull;

@BetGamesPage
public class GamesPageSlots implements IGameList {

    @Override
    public @NotNull ElementsCollection getGameList() {
        return null;
    }

    public GamesPageSlots() {

    }

    @Override
    public @NotNull IGame get_game(@NotNull String gameName) {
        return null;
    }
}
