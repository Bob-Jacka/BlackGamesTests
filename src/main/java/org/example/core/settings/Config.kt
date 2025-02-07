package org.example.core.settings

import org.example.core.entities.PageDistributionService
import org.example.core.entities.PageDistributionService.SingletonPage.Monitor
import org.example.core.main_functionalities.*
import org.jetbrains.annotations.NotNull
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
 * Config file for main architecture configuration.
 * Creating bins and their util methods in DI container.
 * Methods and companion values are structured in way of invoking.
 * @see SpringBootConfiguration
 */
@EnableAspectJAutoProxy
@ComponentScan(basePackages = ["org.example.core.entities", "org.example.core.games"])
@SpringBootConfiguration
open class Config {

    companion object SingletonPage {

        /**
         * Экземпляр класса 'PageDistributionService'.
         * @see PageDistributionService
         */
        @Autowired
        private lateinit var pageDistributionService: PageDistributionService

        /**
         * Экземпляр класса, который наследует интерфейс 'IStageOperator'.
         * @see IStageOperator
         * @see org.example.core.entities.operator.FairSpin
         * @see org.example.core.entities.operator.SprutCloud
         * @see org.example.core.entities.operator.Web3BlockChain
         */
        @Autowired
        private lateinit var operator: IStageOperator

        /**
         * Экземпляр класса, который наследует интерфейс 'IGameList'.
         * @see IGameList
         * @see org.example.core.entities.gameLists.GamesPageSprut
         * @see org.example.core.entities.gameLists.GamesPageSlots
         * @see org.example.core.entities.gameLists.GamesPageFairSpin
         */
        @Autowired
        private lateinit var gameList: IGameList

        /**
         * Экземпляр класса, который наследует интерфейс 'IGame'.
         * @see IGame
         * @see org.example.core.games.sc_games.ColorRace
         * @see org.example.core.games.sc_games.LuckyFish
         * @see org.example.core.games.sc_games.Mooscape
         * @see org.example.core.games.sc_games.Pirate
         */
        @Autowired
        private lateinit var game: IGame

        @Autowired
        private lateinit var waitController: WaitController

        @Autowired
        private lateinit var loggingController: LoggingController

        /**
         * DO NOT USE THIS VARIABLE.
         * @since 30.01.2025
         */
        val __res__: string =
            System.setProperty("java.awt.headless", "false") //Делаем свойство в false, чтобы не падало с исключением

        /**
         * Aspect that responsible for wait before execution of some methods.
         * @see WaitController
         */
        @Bean
        @NotNull
        @DependsOn("config")
        @SuppressWarnings("Not used")
        fun waitController(): WaitController {
            waitController = WaitController()
            return waitController
        }

        /**
         * Aspect that responsible for logging before and after execution of some methods.
         * @see LoggingController
         */
        @Bean
        @NotNull
        @DependsOn("config")
        @SuppressWarnings("Not used")
        fun loggingController(): LoggingController {
            loggingController = LoggingController()
            return loggingController
        }

        /**
         * Создание бина 'pageDistributionService'.
         * Зависит от создания бина 'config'.
         * @see PageDistributionService
         * @return PageDistributionService.
         * ВАЖНО: Все названия бинов являются статическими и не подлежат изменению.
         */
        @Bean
        @NotNull
        @DependsOn("config")
        @SuppressWarnings("Not used")
        fun pageDistributionService(
            @Value("\${app.stage.name:'stable'}") stages_string: string,
            @Value("\${app.stage.browser:'chrome'}") stages_browser: string,
            @Value("\${app.stage.monitor:Right}") monitor: Monitor,
                                   ): PageDistributionService {
            try {
                pageDistributionService = PageDistributionService.getInstance(
                        stages_string, stages_browser, monitor)
                return pageDistributionService
            } catch (e: Exception) {
                e.message.print()
                e.stackTrace.printAll()
                println(
                        """
                    Проверь в случае ошибки инициализации pageDistributionService:
                    1. Включен ли vpn.
                    2. Работает ли vpn.
                    3. Есть ли интернет.
                    4. На unix системах может быть проблема с Selenide.
                    5. Правильно ли указаны имена инжектируемых параметров.
                """
                       )
                throw Exception("Error in page distribution initialization, see details above.")
            }
        }

        /**
         * Создание бина 'operator'.
         * Зависит от создания бина 'pageDistributionService'.
         * @see IStageOperator
         * @return IStageOperator.
         * ВАЖНО: Все названия бинов являются статическими и не подлежат изменению.
         */
        @Bean
        @NotNull
        @DependsOn("pageDistributionService")
        @SuppressWarnings("Not used")
        fun operator(): IStageOperator {
            operator = pageDistributionService.get_Operator()
            return operator
        }

        /**
         * Создание бина 'gameList'.
         * Зависит от создания бина 'operator'.
         * @see IGameList
         * @return IGameList.
         * ВАЖНО: Все названия бинов являются статическими и не подлежат изменению.
         */
        @Bean
        @NotNull
        @DependsOn("operator")
        @SuppressWarnings("Not used")
        fun gameList(): IGameList {
            gameList = operator.login_into_account()
            return gameList
        }

        /**
         * Создание бина 'game'.
         * Зависит от создания бина 'gameList'.
         * @see IGame
         * @return IGame.
         * ВАЖНО: Все названия бинов являются статическими и не подлежат изменению.
         */
        @Bean
        @NotNull
        @DependsOn("gameList")
        @SuppressWarnings("Not used")
        fun game(@Value("\${app.stage.game}") game_name: string): IGame {
            game = gameList.get_game(game_name)
            return game
        }

        /**
         * Метод для получения экземпляра игры из контекста.
         * @see IGame
         * @return объект, имплементирующий интерфейс IGame (затем следует привести к нужному типу)
         */
        @NotNull
        fun getGame(): IGame {
            if (game != null) {
                println("Game returned")
                return game
            }
            return throw Exception("Game is not initialized")
        }

        /**
         * Метод для получения экземпляра оператора.
         * @see IStageOperator
         */
        @NotNull
        fun getOperator(): IStageOperator {
            if (operator != null) {
                println("Operator returned")
                return operator
            }
            return throw Exception("Operator is not initialized")
        }

        /**
         * Метод для получения экземпляра страницы игр.
         * @see IGameList
         */
        @NotNull
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
 * Spring boot app entry point for load application context.
 * @see SpringBootApplication
 */
@SpringBootApplication(scanBasePackages = ["org.example.core.settings.Config"])
open class Application

fun main(args: Array<String>) {

    @NotNull
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

/**
 * Configuration for test container.
 * @see TestConfiguration
 */
@TestConfiguration(proxyBeanMethods = false)
class TestcontainerConfig
