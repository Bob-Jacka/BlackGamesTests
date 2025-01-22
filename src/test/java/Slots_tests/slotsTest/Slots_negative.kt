package Slots_tests.slotsTest

import BaseTest
import io.qameta.allure.SeverityLevel
import org.example.core.annotation.Test
import org.example.core.functional.ActionController.enter_Result
import org.example.core.games.Slots.BaseSlot
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Tag
import org.springframework.beans.factory.annotation.Autowired

@Tag("Negative")
class Slots_negative : BaseTest() {

    @Autowired
    private lateinit var slot: BaseSlot

    @Test(severity = SeverityLevel.CRITICAL)
    fun `Should not increase bet over 1000`() {
        slot.change_bet_plus(50)
        assertTrue(enter_Result())
    }

    @Test(severity = SeverityLevel.CRITICAL)
    fun `Should not decrease bet lower 1`() {
        slot.change_bet_minus(50)
        assertTrue(enter_Result())
    }

    @Test
    fun `Should not change speed over than third speed`() {
        slot.change_speed(3)
        assertTrue(enter_Result())
    }
}