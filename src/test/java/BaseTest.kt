import com.codeborne.selenide.Selenide
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.example.core.entities.PageDistributionService.Waiter.wait_until_load
import org.example.core.main_functionalities.ActionController.wait_For
import org.example.core.main_functionalities.IGame
import org.example.core.main_functionalities.TestResultsWindow
import org.example.core.main_functionalities.printAll
import org.example.core.settings.Config
import org.jetbrains.annotations.NotNull
import org.junit.jupiter.api.*
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext

/**
 * Базовый класс для тестов, аннотирован SpringBootTest.
 * Абстракция для (пре- и пост-) хуков для тестов.
 * @see SpringBootTest
 * @see DirtiesContext
 */
@DirtiesContext
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(useMainMethod = SpringBootTest.UseMainMethod.ALWAYS, classes = [Config::class])
open class BaseTest {

    constructor()

    @BeforeEach
    fun local_initGame(@NotNull testInfo: TestInfo) {
        print("Test tags: ")
        testInfo.tags.printAll()
        println("Test name: " + testInfo.displayName)
        wait_until_load()
    }

    @AfterEach
    fun local_tearDown() {
        wait_For(5)
    }

    companion object Statics {

        /**
         * Экземпляр окна для введения результатов тестирования.
         * @see TestResultsWindow
         */
        private lateinit var test_results_frame: TestResultsWindow

        /**
         * Статический экземпляр игры.
         * @see IGame
         * @see org.example.core.games.sc_games.Pirate
         * @see org.example.core.games.sc_games.LuckyFish
         * @suppress необходимо сделать приведение типа к текущей необходимой игре.
         */
        @JvmStatic
        protected lateinit var currentGame: IGame

        @JvmStatic
        @BeforeAll
        fun global_init() {
            runBlocking {
                launch {
                    test_results_frame = TestResultsWindow.Singleton.get_instance()!!
                }.start()
            }
            println("\t Global initialization invoked")
            currentGame = Config.SingletonPage.getGame() //Init of the game
        }

        @JvmStatic
        @AfterAll
        fun global_tearDown() {
            test_results_frame.destroy()
            Selenide.closeWindow()
            Selenide.closeWebDriver()
            println("\t Global tear down invoked")
        }
    }
}
