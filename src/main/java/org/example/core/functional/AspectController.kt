package org.example.core.functional

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.*
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
    @Before("execution(org.example.core.settings.Config.*(..)")
    fun before_wait1() {
        println("Before method in config aspect invoked")
        wait_For(2)
    }

    /**
     * Waits for game to load. Maybe problems because of different browsers and different network speed
     */
    @Before("execution(org.example.core.games.*.*(..)")
    fun wait_for_game_load(joinPoint: ProceedingJoinPoint) {
        println("Before method in config aspect invoked")
        wait_For(20)
    }

    /**
     * Waits for action to act. Maybe problems because of different browsers and different network speed
     * @see ActionController
     */
    @Before("within(org.example.core.functional.ActionController.*(..)")
    fun wait_for_action(joinPoint: ProceedingJoinPoint) {
        println("Before action aspect")
        wait_For(5)
    }

    /**
     * Waits before entities to load
     * @see org.example.core.entities
     */
    @Around("execution(org.example.core.entities.*.*(..)")
    fun before_wait2(joinPoint: ProceedingJoinPoint) {
        println("Around action aspect")
        wait_For(1)
    }

    /**
     * Waits after every method in config
     * @see org.example.core.settings.Config
     */
    @After("within(org.example.core.settings.Config.*(..)")
    fun after_wait() {
        println("After method in config aspect invoked")
        wait_For(2)
    }
}

@Aspect
@Component
class LoggingController {

    private val logger: Logger = LoggerFactory.getLogger(this::javaClass.name)

    /**
     * Log before every method in Config class
     * @see org.example.core.settings.Config
     */
    @Before("within(org.example.core.settings.Config.*(..)")
    fun log_before_exec() {
        logger.info("Log before execution in config")
        wait_For(2)
    }

    /**
     * Log after every method in Config class
     * @see org.example.core.settings.Config
     */
    @After("execution(org.example.core.settings.Config.*(..)")
    fun log_after_exec() {
        logger.info("Log after execution in config")
        wait_For(2)
    }

    /**
     * Log after throwing exception in every component method in entities directory class
     * @see org.example.core.entities
     */
    @AfterThrowing(pointcut = "execution(org.example.core.entities.*.*(..)")
    fun log_after_throwing(ex: Exception) {
        logger.error("There was an exception")
        logger.error(ex.message)
    }

    /**
     * Log after returning value in every component method in entities directory class
     * @see org.example.core.entities
     */
    @AfterReturning(pointcut = "within(org.example.core.entities.*.*(..)", returning = "retVal")
    fun log_after_return(retVal: Any?) {
        logger.info("Return ${retVal.toString()}")
    }
}