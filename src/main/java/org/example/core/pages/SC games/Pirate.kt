package org.example.core.pages.games;

import org.example.core.pages.ActionController;
import org.openqa.selenium.Point;

public class Pirate {

    private val play_btn =  Point(960, 870);

    private val all_red =  Point(780, 800);
    private val mixed =  Point(960, 800);
    private val all_black =  Point(1130, 800);

    private val minus_bet =  Point(890, 890);
    private val plus_bet =  Point(1030, 890);

    private val balance =  Point(960, 950);

    private val game_info =  Point(1710, 190);
    private val sound_on =  Point(1750, 190);
    private val history_btn =  Point(1800, 230);
    private val blockchaininfo_btn =  Point(1800, 280);

    public fun payOnRed() {
        ActionController.clickOn(all_red);
    }

    public fun payOnBlack() {
        ActionController.clickOn(all_black);
    }

    public fun payOnMixed() {
        ActionController.clickOn(mixed);
    }

    public fun turn_sound_on() {
        ActionController.clickOn(sound_on);
    }

    public fun get_in_history() {
        ActionController.clickOn(history_btn);
    }

    public fun get_in_blockchainInfo() {
        ActionController.clickOn(blockchaininfo_btn);
    }

    public fun change_bet(boolean up, int howMany) {
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

    public fun show_balance() {
        ActionController.clickOn(balance);
    }

    public fun startGame() {
        ActionController.clickOn(play_btn);
    }

    public fun show_game_info() {
        ActionController.clickOn(game_info);
    }
}
