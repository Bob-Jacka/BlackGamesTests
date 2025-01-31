package Slots_tests.slotsTest

import BaseTest
import io.qameta.allure.SeverityLevel
import org.example.core.annotations.TestCase
import org.example.core.games.Slots.BaseSlot
import org.example.core.main_functionalities.ActionController.enter_Result
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Tag
import org.springframework.beans.factory.annotation.Autowired

@Tag("Negative")
class Slots_negative : BaseTest() {

    @Autowired
    private lateinit var slot: BaseSlot

    @TestCase(severity = SeverityLevel.CRITICAL)
    fun `Should not increase bet over 1000`() {
        slot = currentGame as BaseSlot
        slot.change_bet_plus(50)
        assertTrue(enter_Result())
    }

    @TestCase(severity = SeverityLevel.CRITICAL)
    fun `Should not decrease bet lower 1`() {
        slot = currentGame as BaseSlot
        slot.change_bet_minus(50)
        assertTrue(enter_Result())
    }

    @TestCase
    fun `Should not change speed over than third speed`() {
        slot = currentGame as BaseSlot
        slot.change_speed(3)
        assertTrue(enter_Result())
    }
}