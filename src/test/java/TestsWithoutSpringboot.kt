import io.qameta.allure.SeverityLevel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.example.core.annotation.Test
import org.example.core.entities.PageDistributionService
import org.example.core.functional.*
import org.example.core.games.sc_games.Pirate
import org.junit.jupiter.api.Assertions.assertTrue

class TestsWithoutSpringboot {

    val pageDistributionService: PageDistributionService = PageDistributionService.getInstance("stable", "firefox")
    val operator: IStageOperator = pageDistributionService.getOperator()
    val gameList: IGameList = operator.login_into_account()
    val game: IGame = gameList.get_game("Pirate flipping coins") as Pirate

    @Test(SeverityLevel.MINOR)
    fun contextLoads() {
        var res: bool = false
        runBlocking {
            launch {
                game.start_game()
                delay(40_000)
            }
            res = ActionController.enter_Result()
            assertTrue(res.equals(null))
        }
    }
}