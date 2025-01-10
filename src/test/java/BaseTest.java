import com.codeborne.selenide.Selenide;
import org.example.core.Functional.Operator.FairSpin;
import org.example.core.Functional.Operator.SprutCloud;
import org.example.core.Functional.Operator.Web3BlockChain;
import org.example.core.Functional.PageDistribution;
import org.example.core.enums.Stages;
import org.example.core.pages.SC_games.GameList;
import org.example.core.pages.SC_games.StageOperator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

import static org.example.core.Functional.ActionController.waitFor;

public class BaseTest {

    //TODO убрать зависимость от PageDistribution
    private static Stages stage;
    private static PageDistribution pg;
    private static StageOperator operator;
    private static GameList gameList;

    public BaseTest(final Stages stage, final String browser) {
        pg = new PageDistribution(stage, browser);
        BaseTest.stage = pg.getStage();
        switch (BaseTest.stage) {
            case PROD -> {
                operator = new FairSpin();
                gameList = ((FairSpin) operator).loginInto();
            }
            case SLOT_PROD -> {
                operator = new Web3BlockChain();
//                gameList =
                //TODO gameList слотов
            }
            default -> {
                operator = new SprutCloud();
                gameList = ((SprutCloud) operator).loginInto();
            }
        }
    }

    @BeforeEach
    public void startGame(TestInfo testInfo) {
        String displayName = testInfo.getDisplayName();
        System.out.println(displayName);
        waitFor(1);
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
        stage = null;
        pg = null;
        operator = null;
    }

    public Stages getStage() {
        return stage;
    }

    public PageDistribution getPageDist() {
        return pg;
    }

    public StageOperator getOperator() {
        return operator;
    }

    public GameList getGameList() {
        return gameList;
    }
}