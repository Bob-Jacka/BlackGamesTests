package org.example.core.pages;

import org.example.core.functional.IAuto;
import org.example.core.functional.IBetBlock;
import org.example.core.functional.IPreselects;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.Point;

import static org.example.core.functional.ActionController.click_On;
import static org.example.core.functional.ActionController.enter_By_Keyboard;
import static org.example.core.functional.ExtensionsKt.increase_or_decrease;

/**
 * first bet block of mooscape game
 * if you want second block, get first block elem and transform it with
 */
public class BetBlock implements IAuto, IPreselects, IBetBlock {

    private Point bet_btn = new Point(861, 855);
    private Point autobet_btn = new Point(625, 795);
    private Point autocashout_btn = new Point(720, 795);
    private Point minus_bet_btn = new Point(631, 840);
    private Point plus_bet_btn = new Point(750, 840);
    private Point bet_input_field = new Point(700, 840);

    private Point minus_coef_btn = new Point(840, 795);
    private Point plus_coef_btn = new Point(930, 795);
    private Point coef_input_field = new Point(885, 795);

    //preselects
    private Point one = new Point(630, 875);
    private Point two = new Point(670, 875);
    private Point three = new Point(710, 875);
    private Point four = new Point(750, 875);

    /**
     * Standard constructor for bet block, always returns first bet block
     */
    public BetBlock() {
    }

    private BetBlock(BetBlockBuilder builder) {
        this.bet_btn = builder.bet_btn;
        this.autobet_btn = builder.autobet_btn;
        this.autocashout_btn = builder.autocashout_btn;
        this.minus_bet_btn = builder.minus_bet_btn;
        this.plus_bet_btn = builder.plus_bet_btn;
        this.bet_input_field = builder.bet_input_field;
        this.minus_coef_btn = builder.minus_coef_btn;
        this.plus_coef_btn = builder.plus_coef_btn;
        this.coef_input_field = builder.coef_input_field;
        this.one = builder.one;
        this.two = builder.two;
        this.three = builder.three;
        this.four = builder.four;
    }

    public void change_bet(int which_block, boolean up, int howMany) {
        switch (which_block) {
            case 1, 2 -> increase_or_decrease(
                    up,
                    howMany,
                    plus_bet_btn,
                    minus_bet_btn
            );
        }
    }

    /**
     * @param which_block - обозначает на каком блоке будет нажатие на кнопку 'bet', может быть 1 или 2
     */
    @Override
    public void bet_on_block(int which_block) {
        switch (which_block) {
            case 1, 2 -> click_On(bet_btn);
        }
    }

    @Override
    public void change_coef(int which_block, boolean up, int howMany) {
        switch (which_block) {
            case 1, 2 -> increase_or_decrease(
                    up,
                    howMany,
                    plus_coef_btn,
                    minus_coef_btn
            );
        }
    }

    @Override
    public void enable_autobet(int which_block, Point elemPos) {
        switch (which_block) {
            case 1, 2 -> click_On(autobet_btn);
        }
    }

    @Override
    public void enable_autocashout(int which_block, Point elemPos) {
        switch (which_block) {
            case 1, 2 -> click_On(autocashout_btn);
        }
    }

    @Override
    public void get_first_ps() {
        click_On(one);
    }

    @Override
    public void get_second_ps() {
        click_On(two);
    }

    @Override
    public void get_third_ps() {
        click_On(three);
    }

    @Override
    public void get_fourth_ps() {
        click_On(four);
    }

    @Override
    public @NotNull Point get_bet_btn() {
        return bet_btn;
    }

    public @NotNull Point get_minus_coef_btn() {
        return minus_coef_btn;
    }

    public @NotNull Point get_plus_coef_btn() {
        return plus_coef_btn;
    }

    public @NotNull Point get_coef_input_field() {
        return coef_input_field;
    }

    @Override
    public @NotNull Point getPlus_bet() {
        return plus_bet_btn;
    }

    @Override
    public @NotNull Point getMinus_bet() {
        return minus_bet_btn;
    }

    @Override
    public @NotNull Point getAutocashout_btn() {
        return autocashout_btn;
    }

    @Override
    public @NotNull Point getAutobet_btn() {
        return autobet_btn;
    }

    public @NotNull Point getMinus_bet_btn() {
        return minus_bet_btn;
    }

    public @NotNull Point getPlus_bet_btn() {
        return plus_bet_btn;
    }

    public @NotNull Point getBet_input_field() {
        return bet_input_field;
    }

    public @NotNull Point getOne() {
        return one;
    }

    public @NotNull Point getTwo() {
        return two;
    }

    public @NotNull Point getThree() {
        return three;
    }

    public @NotNull Point getFour() {
        return four;
    }

    public void enter_coef(String value) {
        enter_By_Keyboard(coef_input_field, value);
    }

    public void enter_bet(String value) {
        enter_By_Keyboard(bet_input_field, value);
    }

    public static class BetBlockBuilder {

        private Point bet_btn = new Point(861, 855);
        private Point autobet_btn = new Point(625, 795);
        private Point autocashout_btn = new Point(720, 795);
        private Point minus_bet_btn = new Point(631, 840);
        private Point plus_bet_btn = new Point(750, 840);
        private Point bet_input_field = new Point(700, 840);

        private Point minus_coef_btn = new Point(840, 795);
        private Point plus_coef_btn = new Point(930, 795);
        private Point coef_input_field = new Point(885, 795);

        //preselects
        private Point one = new Point(630, 875);
        private Point two = new Point(670, 875);
        private Point three = new Point(710, 875);
        private Point four = new Point(750, 875);

        public BetBlockBuilder bet_btn(Point point) {
            this.bet_btn = point;
            return this;
        }

        public BetBlockBuilder autobet_btn(Point point) {
            this.autobet_btn = point;
            return this;
        }

        public BetBlockBuilder autocashout_btn(Point point) {
            this.autocashout_btn = point;
            return this;
        }

        public BetBlockBuilder minus_bet_btn(Point point) {
            this.minus_bet_btn = point;
            return this;
        }

        public BetBlockBuilder plus_bet_btn(Point point) {
            this.plus_bet_btn = point;
            return this;
        }

        public BetBlockBuilder bet_input_field(Point point) {
            this.bet_input_field = point;
            return this;
        }

        public BetBlockBuilder minus_coef_btn(Point point) {
            this.minus_coef_btn = point;
            return this;
        }

        public BetBlockBuilder plus_coef_btn(Point point) {
            this.plus_coef_btn = point;
            return this;
        }

        public BetBlockBuilder coef_input_field(Point point) {
            this.coef_input_field = point;
            return this;
        }

        public BetBlockBuilder one(Point point) {
            this.one = point;
            return this;
        }

        public BetBlockBuilder two(Point point) {
            this.two = point;
            return this;
        }

        public BetBlockBuilder three(Point point) {
            this.three = point;
            return this;
        }

        public BetBlockBuilder four(Point point) {
            this.four = point;
            return this;
        }

        public BetBlock build() {
            return new BetBlock(this);
        }
    }
}
