import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    private static SprutCloud spC;
    private static GamesPage gamesPage;
    private statuc PageDistribution pg;

    @BeforeEach
    public void startGame(TestInfo testInfo) {
        String displayName = testInfo.getDisplayName();
        pg = PageDistribution();
        spC = pg.getStage();
        spC.enterUserName();
        gamesPage = spC.loginInto();
        System.out.println(displayName);
        waitFor(1);
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
        spc = null;
        gamesPage = null;
    }

    public SprutCloud getSC() {
        return spC;
    }

    public GamesPage getGamesPage() {
        return gamesPage;
    }
}

@Retention(RetentionPolicy.RUNTIME) // Аннотация будет доступна в рантайме
@Target(ElementType.TYPE) // Аннотация может применяться только к классам
public @interface TestData {
    SprutCloud spc() default spc;
    GamesPage games_page() default gamesPage;

    String env();
    String stage();
    String tag(); //positive or negative
}