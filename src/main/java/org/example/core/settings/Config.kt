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

/**
 * Config file for main architecture
 */
@Profile("Stable")
@Configuration
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
    fun getPageDist(): PageDistributionService? {
        return PageDistributionService.getInstance(Stages.STABLE)
    }

    @Bean
    fun getOperator(): IStageOperator {
        when (pg.getStage()) {
            PROD -> {
                operator = FairSpin()
                gameList = operator.login_into_account()
            }

            SLOT_PROD -> {
                operator = Web3BlockChain()
                gameList = operator.login_into_account()
            }

            Stages.DEV -> {
                operator = SprutCloud()
                gameList = operator.login_into_account()
            }

            Stages.STABLE -> {
                operator = SprutCloud()
                gameList = operator.login_into_account()
            }

            Stages.PREPROD -> {
                operator = SprutCloud()
                gameList = operator.login_into_account()
            }
        }
        return operator
    }

    @Bean
    fun getGame(): IGame {
        return game
    }
}

@TestConfiguration(proxyBeanMethods = false)
class TestcontainerConfig