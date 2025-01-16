import com.codeborne.selenide.Selenide;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

import static org.example.core.functional.ActionController.wait_For;

/**
 * Базовый класс для тестов
 */
@SpringBootTest
public class BaseTest {

    public BaseTest() {
    }

    @BeforeEach
    public void initGame(@NotNull TestInfo testInfo) {
        String displayName = testInfo.getDisplayName();
        System.out.println(displayName);
        wait_For(2);
    }

    @AfterEach
    public void teardownGame() {
        
    }

    @BeforeAll
    public static void global_init() {

    }

    @AfterAll
    public static void global_teardown() {
        Selenide.closeWebDriver();
    }
}