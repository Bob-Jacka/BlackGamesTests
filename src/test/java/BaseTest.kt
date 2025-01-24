import com.codeborne.selenide.Selenide
import org.example.core.functional.IGame
import org.example.core.settings.Config
import org.jetbrains.annotations.NotNull
import org.junit.jupiter.api.*
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext

/**
 * Базовый класс для тестов, аннотирован SpringBootTest.
 * Абстракция для (пре- и пост-) хуков для тестов
 */
@DirtiesContext
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(useMainMethod = SpringBootTest.UseMainMethod.ALWAYS, classes = [Config::class])
open class BaseTest {

    constructor() {
        println("Default base test constructor invoked")
    }

    @BeforeEach
    fun local_initGame(@NotNull testInfo: TestInfo) {
        println()
        print("Test tags: ")
        testInfo.tags.forEach { print(it) }
        println()
        println("Test name: " + testInfo.displayName)
    }

    @AfterEach
    fun local_tearDown() {
        Thread.sleep(100_000)
    }

    companion object Statics {

        /**
         * Статический экземпляр игры
         */
        @JvmStatic
        protected lateinit var game: IGame

        @JvmStatic
        @BeforeAll
        fun global_init() {
            println("\t Global initialization invoked")
            game = Config.SingletonPage.getGame() //Init of the game
            println("Static C++ library loaded")
//            System.loadLibrary("org.example.core.functional.Native.open_term")
        }

        @JvmStatic
        @AfterAll
        fun global_tearDown() {
            println("Exiting..........")
            Selenide.closeWindow()
            Selenide.closeWebDriver()
            println("\t Global tear down invoked")
        }
    }
}
