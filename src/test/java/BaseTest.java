import com.codeborne.selenide.Selenide;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

import static org.example.core.functional.ActionController.wait_For;

/**
 * Базовый класс для тестов
 */
public class BaseTest {

    public BaseTest() {
    }

    @BeforeEach
    public void startGame(@NotNull TestInfo testInfo) {
        String displayName = testInfo.getDisplayName();
        System.out.println(displayName);
        wait_For(2);
    }

    @AfterAll
    public static void tearDown() {
        Selenide.closeWebDriver();
    }
}