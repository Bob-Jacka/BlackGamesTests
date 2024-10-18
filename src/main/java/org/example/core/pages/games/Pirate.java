package org.example.core.pages.games;

import org.example.core.pages.ActionController;
import org.openqa.selenium.Point;

public class Pirate {

    private final Point play_btn = new Point(960, 870);

    private final Point all_red = new Point(780, 800);
    private final Point mixed = new Point(960, 800);
    private final Point all_black = new Point(1130, 800);

    private final Point minus_bet = new Point(890, 890);
    private final Point plus_bet = new Point(1030, 890);

    private final Point balance = new Point(960, 950);

    private final Point game_info = new Point(1710, 190);
    private final Point sound_on = new Point(1750, 190);
    private final Point history_btn = new Point(1800, 230);
    private final Point blockchaininfo_btn = new Point(1800, 280);

    public void payOnRed() {
        ActionController.clickOn(all_red);
    }

    public void payOnBlack() {
        ActionController.clickOn(all_black);
    }

    public void payOnMixed() {
        ActionController.clickOn(mixed);
    }

    public void turn_sound_on() {
        ActionController.clickOn(sound_on);
    }

    public void get_in_history() {
        ActionController.clickOn(history_btn);
    }

    public void get_in_blockchainInfo() {
        ActionController.clickOn(blockchaininfo_btn);
    }

    public void change_bet(boolean up, int howMany) {
        if (up) {
            for (int i = 0; i < howMany; i++) {
                ActionController.clickOn(plus_bet);
            }

        } else {
            for (int i = 0; i < howMany; i++) {
                ActionController.clickOn(minus_bet);
            }
        }
    }

    public void show_balance() {
        ActionController.clickOn(balance);
    }

    public void startGame() {
        ActionController.clickOn(play_btn);
    }

    public void show_game_info() {
        ActionController.clickOn(game_info);
    }
}
