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

public class EntityFactory {

    private static EntityFactory factory;

    private static Stages stage;
    private static StageOperator operator;
    private static GameList gameList;

    private EntityFactory() {}

    public static EntityFactory getInstance() {
        if (factory == null) {
            factory = new EntityFactory();
        }
        return factory;
    }

    public getEntity(final Stages stage, final String browser) {
        EntityFactory.stage = PageDistribution.getInstance(stage, browser).getStage();
        switch (EntityFactory.stage) {
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
        factory = null;
        operator = null;
    }

    public Stages getStage() {
        return stage;
    }

    public StageOperator getOperator() {
        return operator;
    }

    public GameList getGameList() {
        return gameList;
    }
}