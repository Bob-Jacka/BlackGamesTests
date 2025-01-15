package org.example.core.entities.gameLists;

import com.codeborne.selenide.ElementsCollection;
import org.example.core.enums.GameName;
import org.example.core.functional.IGame;
import org.example.core.functional.IGameList;
import org.jetbrains.annotations.NotNull;

public class GamesPageSlots implements IGameList {

    @Override
    public @NotNull ElementsCollection getGameList() {
        return null;
    }

    @Override
    public @NotNull IGame get_game(@NotNull GameName gameName) {
        return null;
    }
}
