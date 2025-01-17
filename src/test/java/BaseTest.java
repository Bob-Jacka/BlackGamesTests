import com.codeborne.selenide.Selenide;
import org.example.core.settings.Config;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.example.core.functional.ActionController.wait_For;

/**
 * Базовый класс для тестов, аннотирован SpringBootTest
 * Абстракция для (пре- и пост-) хуков для тестов
 * ? В будущем будет подключен логгер
 */
@SpringBootTest(classes = Config.class)
public class BaseTest {

    public BaseTest() {

    }

    @BeforeEach
    public void initGame(@NotNull TestInfo testInfo) {
        System.out.println("Test tags:");
        testInfo.getTags().forEach(x -> System.out.println("\t " + x));
        System.out.println(testInfo.getDisplayName());
        wait_For(10);
    }

    @AfterEach
    public void tearDownGame() {
        System.out.println("Refresh game");
//        Selenide.refresh();
    }

    @BeforeAll
    public static void global_init() {
        System.out.println("\t Global initialization invoked");
    }

    @AfterAll
    public static void global_teardown() {
        Selenide.closeWebDriver();
        System.out.println("\t Global tear down invoked");
    }
}
