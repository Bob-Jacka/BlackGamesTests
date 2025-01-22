package org.example.core.functional

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.example.core.functional.ActionController.wait_For
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Aspect
@Component
class WaitController {

    /**
     * Waits before every method in config
     * @see org.example.core.settings.Config
     */
    @Before(value = "execution(* org.example.core.Config.*(..)")
    fun before_wait1() {
        println("before method in config aspect invoked")
        wait_For(2)
    }

    /**
     * Waits for game to load. Maybe problems because of different browsers and different network speed
     */
    @Before(value = "execution(* org.example.core.games.*.(..)")
    fun wait_for_game_load(joinPoint: ProceedingJoinPoint) {
        wait_For(20)
    }

    /**
     * Waits before entities to load
     * @see org.example.core.entities
     */
    @Around(value = "execution(* org.example.core.entities.*.*(..)")
    fun before_wait2(joinPoint: ProceedingJoinPoint) {
        wait_For(1)
    }

    /**
     * Waits after every method in config
     * @see org.example.core.settings.Config
     */
    @After(value = "execution(* org.example.core.Config.*(..))")
    fun after_wait() {
        println("after method in config aspect invoked")
        wait_For(2)
    }
}

@Aspect
@Component
class LoggingController {

    companion object LoggerObj {

        private val logger: Logger = LoggerFactory.getLogger(this::javaClass.name)
    }

    @Before(value = "execution(* org.example.core.Config.*(..)")
    fun log_before_exec() {
        logger.info("Hello")
        wait_For(2)
    }

    @After(value = "execution(* org.example.core.Config.*(..))")
    fun log_after_exec() {
        logger.info("Hello")
        wait_For(2)
    }
}