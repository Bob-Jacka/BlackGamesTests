import com.codeborne.selenide.Selenide;
import org.example.core.functional.IGame;
import org.example.core.settings.Config;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.example.core.functional.ActionController.wait_For;

/**
 * Базовый класс для тестов, аннотирован SpringBootTest
 * Абстракция для (пре- и пост-) хуков для тестов
 */
@SpringBootTest(useMainMethod = SpringBootTest.UseMainMethod.ALWAYS, classes = {Config.class})
public class BaseTest {

    @Autowired
    protected static IGame game;

    public BaseTest() throws Exception {

    }

    @BeforeEach
    public void initGame(@NotNull TestInfo testInfo) {
        System.out.println("Test tags:");
        testInfo.getTags().forEach(x -> System.out.println("\t " + x));
        System.out.println(testInfo.getDisplayName());
        wait_For(10);
    }

    @AfterEach
    public void tearDownGame() throws InterruptedException {
        System.out.println("Refresh game");
        Thread.sleep(100_000);
    }

    @BeforeAll
    public static void global_init() {
        System.out.println("\t Global initialization invoked");
        SpringApplication.run(Config.class); //Spring boot app start, get spring boot app entry point
        game = Config.BeanFactory.getGame(); //Init of the game
    }

    @AfterAll
    public static void global_teardown() {
        System.out.println("Exiting.............");
        Selenide.closeWindow();
        Selenide.closeWebDriver();
        System.out.println("\t Global tear down invoked");
    }
}
