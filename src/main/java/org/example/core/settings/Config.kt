package org.example.core.settings

import org.example.core.entities.PageDistributionService
import org.example.core.entities.operator.FairSpin
import org.example.core.entities.operator.SprutCloud
import org.example.core.entities.operator.Web3BlockChain
import org.example.core.enums.Stages_web_addresses
import org.example.core.enums.Stages_web_addresses.PROD
import org.example.core.enums.Stages_web_addresses.SLOT_PROD
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
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan

/**
 * Config file for main architecture.
 * Methods and companion values are structured in way of invoking
 */
@ComponentScan(basePackages = ["org.example.core.entities", "org.example.core.games"])
@SpringBootConfiguration
open class Config {

    companion object BeanFactory {

        @Autowired
        private lateinit var pageDistribution: PageDistributionService

        @Autowired
        private lateinit var operator: IStageOperator

        @Autowired
        private lateinit var gameList: IGameList

        @Autowired
        private lateinit var game: IGame

        @Bean
        fun pageDistribution(
            @Value("\${app.stage.name}") stages_string: string, @Value("\${app.stage.browser}") stages_browser: string,
                            ): PageDistributionService {
            try {
                val distService: PageDistributionService =
                    PageDistributionService.getInstance(stages_string, stages_browser)
                pageDistribution = distService
                return pageDistribution
            } catch (e: Exception) {
                println(e.stackTrace)
                throw Exception("Return value is null")
            }
        }

        @Bean
        fun operator(): IStageOperator {
            when (pageDistribution.getStage()) {
                PROD -> {
                    operator = FairSpin()
                }

                SLOT_PROD -> {
                    operator = Web3BlockChain()
                }

                Stages_web_addresses.DEV -> {
                    operator = SprutCloud()
                }

                Stages_web_addresses.STABLE -> {
                    operator = SprutCloud()
                }

                Stages_web_addresses.PREPROD -> {
                    operator = SprutCloud()
                }
            }
            return operator
        }

        @Bean
        fun gameList(): IGameList {
            gameList = operator.login_into_account()
            return gameList
        }

        @Bean
        fun game(@Value("\${app.stage.game}") game_name: string): IGame {
            game = gameList.get_game(game_name)
            return game
        }

        fun getGame(): IGame? {
            if (game != null) {
                return game
            }
            return null
        }
    }

    fun getOperator(): IStageOperator? {
        if (operator != null) {
            return operator
        }
        return null
    }

    fun getGameList(): IGameList? {
        if (gameList != null) {
            return gameList
        }
        return null
    }
}

/**
 * Spring boot app entry point
 */
@SpringBootApplication
open class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}

@TestConfiguration(proxyBeanMethods = false)
class TestcontainerConfig