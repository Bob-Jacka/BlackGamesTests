package org.example.core.settings

import org.example.core.entities.PageDistributionService
import org.example.core.entities.operator.FairSpin
import org.example.core.entities.operator.SprutCloud
import org.example.core.entities.operator.Web3BlockChain
import org.example.core.enums.Stages
import org.example.core.enums.Stages.PROD
import org.example.core.enums.Stages.SLOT_PROD
import org.example.core.functional.ActionController.wait_For
import org.example.core.functional.IGame
import org.example.core.functional.IGameList
import org.example.core.functional.IStageOperator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan

/**
 * Config file for main architecture
 */
//@Profile("Stable")
@SpringBootConfiguration
@ComponentScan(basePackages = ["org.example.core.entities"])
open class Config {

    @Autowired
    private lateinit var pageDistribution: PageDistributionService

    @Autowired
    private lateinit var operator: IStageOperator

    @Autowired
    private lateinit var gameList: IGameList

    @Autowired
    private lateinit var game: IGame

    @Bean
    open fun pageDistribution(): PageDistributionService? {
        return PageDistributionService.getInstance(Stages.STABLE)
    }

    @Bean
    open fun gameList(): IGameList {
        gameList = operator.login_into_account()
        return gameList
    }

    @Bean
    open fun operator(): IStageOperator {
        when (pageDistribution.getStage()) {
            PROD -> {
                wait_For(2)
                operator = FairSpin()
            }

            SLOT_PROD -> {
                wait_For(2)
                operator = Web3BlockChain()
            }

            Stages.DEV -> {
                wait_For(2)
                operator = SprutCloud()
            }

            Stages.STABLE -> {
                wait_For(2)
                operator = SprutCloud()
            }

            Stages.PREPROD -> {
                wait_For(2)
                operator = SprutCloud()
            }
        }
        return operator
    }

    @Bean
    open fun game(): IGame {
        return game
    }

    fun getGame(): IGame? {
        if (game != null) {
            return game
        }
        return null
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

@TestConfiguration(proxyBeanMethods = false)
class TestcontainerConfig