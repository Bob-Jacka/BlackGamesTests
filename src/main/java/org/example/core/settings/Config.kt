package org.example.core.settings

import org.example.core.entities.PageDistributionService
import org.example.core.functional.IGame
import org.example.core.functional.IGameList
import org.example.core.functional.IStageOperator
import org.example.core.functional.string
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.ApplicationEvent
import org.springframework.context.ApplicationListener
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.DependsOn
import org.springframework.context.annotation.EnableAspectJAutoProxy

/**
 * Config file for main architecture.
 * Creating bins and their util methods.
 * Methods and companion values are structured in way of invoking
 */
@EnableAspectJAutoProxy
@ComponentScan(basePackages = ["org.example.core.entities", "org.example.core.games"])
@SpringBootConfiguration
open class Config {

    companion object SingletonPage {

        /**
         * Экземпляр класса 'PageDistributionService'
         * @see PageDistributionService
         */
        @Autowired
        private lateinit var pageDistributionService: PageDistributionService

        /**
         * Экземпляр класса, который наследует интерфейс 'IStageOperator'
         * @see IStageOperator
         * @see org.example.core.entities.operator.FairSpin
         * @see org.example.core.entities.operator.SprutCloud
         * @see org.example.core.entities.operator.Web3BlockChain
         */
        @Autowired
        private lateinit var operator: IStageOperator

        /**
         * Экземпляр класса, который наследует интерфейс 'IGameList'
         * @see IGameList
         * @see org.example.core.entities.gameLists.GamesPageSprut
         * @see org.example.core.entities.gameLists.GamesPageSlots
         * @see org.example.core.entities.gameLists.GamesPageFairSpin
         */
        @Autowired
        private lateinit var gameList: IGameList

        /**
         * Экземпляр класса, который наследует интерфейс 'IGame'
         * @see IGame
         * @see org.example.core.games.sc_games.ColorRace
         * @see org.example.core.games.sc_games.LuckyFish
         * @see org.example.core.games.sc_games.Mooscape
         * @see org.example.core.games.sc_games.Pirate
         */
        @Autowired
        private lateinit var game: IGame

        /**
         * Создание бина 'pageDistributionService'.
         * Зависит от создания бина 'config'.
         * @see PageDistributionService
         * @return PageDistributionService.
         * ВАЖНО: Все названия бинов являются статическими и не подлежат изменению
         */
        @Bean
        @DependsOn("config")
        fun pageDistributionService(
            @Value("\${app.stage.name}") stages_string: string,
            @Value("\${app.stage.browser}") stages_browser: string,
                                   ): PageDistributionService {
            pageDistributionService = PageDistributionService.getInstance(stages_string, stages_browser)
            return pageDistributionService
        }

        /**
         * Создание бина 'operator'.
         * Зависит от создания бина 'pageDistributionService'.
         * @see IStageOperator
         * @return IStageOperator.
         * ВАЖНО: Все названия бинов являются статическими и не подлежат изменению
         */
        @Bean
        @DependsOn("pageDistributionService")
        fun operator(): IStageOperator {
            operator = pageDistributionService.getOperator()
            return operator
        }

        /**
         * Создание бина 'gameList'.
         * Зависит от создания бина 'operator'.
         * @see IGameList
         * @return IGameList.
         * ВАЖНО: Все названия бинов являются статическими и не подлежат изменению
         */
        @Bean
        @DependsOn("operator")
        fun gameList(): IGameList {
            gameList = operator.login_into_account()
            return gameList
        }

        /**
         * Создание бина 'game'.
         * Зависит от создания бина 'gameList'.
         * @see IGame
         * @return IGame.
         * ВАЖНО: Все названия бинов являются статическими и не подлежат изменению
         */
        @Bean
        @DependsOn("gameList")
        fun game(@Value("\${app.stage.game}") game_name: string): IGame {
            game = gameList.get_game(game_name)
            return game
        }

        /**
         * Метод для получения экземпляра игры из контекста
         * @return объект, имплементирующий интерфейс IGame (затем следует привести к нужному типу)
         */
        fun getGame(): IGame {
            if (game != null) {
                println("Game returned")
                return game
            }
            println("Game is null!!")
            return throw Exception("Game is not initialized")
        }

        /**
         * Метод для получения экземпляра оператора
         */
        fun getOperator(): IStageOperator {
            if (operator != null) {
                println("Operator returned")
                return operator
            }
            return throw Exception("Operator is not initialized")
        }

        /**
         * Метод для получения экземпляра страницы игр
         */
        fun getGameList(): IGameList {
            if (gameList != null) {
                println("Game list returned")
                return gameList
            }
            return throw Exception("Game list is not initialized")
        }
    }
}

/**
 * Spring boot app entry point
 */
@SpringBootApplication(scanBasePackages = ["org.example.core.settings.Config"])
open class Application

fun main(args: Array<String>) {

    val context: ConfigurableApplicationContext = runApplication<Application>(*args)
    context.addApplicationListener {
        ApplicationListener<ApplicationEvent> {
            @Override
            fun onApplicationEvent() {
                println("Application event invoked")
            }
        }
    }
}

@TestConfiguration(proxyBeanMethods = false)
class TestcontainerConfig