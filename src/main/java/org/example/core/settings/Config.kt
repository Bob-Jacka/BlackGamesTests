package org.example.core.settings

import org.example.core.entities.PageDistributionService
import org.example.core.entities.operator.FairSpin
import org.example.core.entities.operator.SprutCloud
import org.example.core.entities.operator.Web3BlockChain
import org.example.core.enums.Stages
import org.example.core.enums.Stages.PROD
import org.example.core.enums.Stages.SLOT_PROD
import org.example.core.functional.IGame
import org.example.core.functional.IGameList
import org.example.core.functional.IStageOperator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.context.annotation.

/**
 * Config file for main architecture
 */
@Profile("Stable")
@Configuration
@ComponentScan(selectPackages = {"org.example.core.entities"})
class Config {

    @Autowired
    private lateinit var pg: PageDistributionService

    @Autowired
    private lateinit var operator: IStageOperator

    @Autowired
    private lateinit var gameList: IGameList

    @Autowired
    private lateinit var game: IGame

    @Bean
    fun pageDistribution(): PageDistributionService? {
        return PageDistributionService.getInstance(Stages.STABLE)
    }

    @Bean
    fun gameList(): IGameList {
        gameList = operator.login_into_account()
        return gameList
    }

    @Bean
    fun operator(): IStageOperator {
        when (pg.getStage()) {
            PROD -> {
                operator = FairSpin()
            }

            SLOT_PROD -> {
                operator = Web3BlockChain()
            }

            Stages.DEV -> {
                operator = SprutCloud()
            }

            Stages.STABLE -> {
                operator = SprutCloud()
            }

            Stages.PREPROD -> {
                operator = SprutCloud()
            }
        }
        return operator
    }

    @Bean
    fun game(): IGame {
        return game
    }

    fun getGame(): IGame {
        if (this.game != null) {
            return game
        }
    }

    fun getOperator() {
        if (this.operator != null) {
            return operator
        }
    }

    fun getGameList() {
        if (this.gameList != null) {
            return gameList
        }
    }
}

@TestConfiguration(proxyBeanMethods = false)
class TestcontainerConfig