package org.example.core.main_functionalities

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.*
import org.example.core.annotations.ControllerAspect
import org.example.core.main_functionalities.ActionController.wait_For
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@ControllerAspect
class WaitController {

    /**
     * Waits for action to act. Maybe problems because of different browsers and different network speed
     * @see ActionController
     */
    @Before("within(org.example.core.functional.ActionController.*(..)")
    fun wait_for_action(joinPoint: ProceedingJoinPoint) {
        println("Before action aspect")
        wait_For(1)
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
}

@ControllerAspect
class LoggingController {

    private val logger: Logger = LoggerFactory.getLogger(this::javaClass.name)

    /**
     * Log before every method in Config class
     * @see org.example.core.settings.Config
     */
    @Before("within(org.example.core.settings.Config.*(..)")
    fun log_before_exec() {
        logger.info("Log before execution in config")
        wait_For(0.5)
    }

    /**
     * Log after every method in Config class
     * @see org.example.core.settings.Config
     */
    @After("execution(org.example.core.settings.Config.*(..)")
    fun log_after_exec() {
        logger.info("Log after execution in config")
        wait_For(0.5)
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