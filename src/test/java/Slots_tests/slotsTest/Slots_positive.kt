package Slots_tests.slotsTest

import BaseTest
import io.qameta.allure.SeverityLevel
import org.example.core.annotation.Test
import org.example.core.functional.ActionController.enter_result
import org.example.core.pages.Slots.BaseSlot
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Tag
import org.springframework.beans.factory.annotation.Autowired

@Tag("Positive")
class Slots_positive : BaseTest() {

    @Autowired
    private lateinit var slot: BaseSlot

    @Test(severity = SeverityLevel.CRITICAL)
    fun `Should increase bet`() {
        slot.change_bet_plus(2)
        assertTrue(enter_result())
    }

    @Test(severity = SeverityLevel.CRITICAL)
    fun `Should decrease bet`() {
        slot.change_bet_minus(2)
        assertTrue(enter_result())
    }

    @Test
    fun `Should turn on music`() {
        slot.set_sound_on(true)
        assertTrue(enter_result())
    }

    @Test
    fun `Should turn off music`() {
        slot.set_sound_on(false)
        assertTrue(enter_result())
    }

    @Test
    fun `Should change speed`() {
        slot.change_speed(2)
        assertTrue(enter_result())
    }

    @Test
    fun `Should enter the rules page`() {
        slot.get_in_rules()
        assertTrue(enter_result())
    }

    @Test
    fun `Should close the rules page`() {
        slot.close_rules()
        assertTrue(enter_result())
    }

    @Test
    fun `Should change bet in rules page - plus`() {
        slot.get_in_rules()
        slot.change_pages_in_rules(7)
        assertTrue(enter_result())
    }

    @Test
    fun `Should change bet in rules page - minus`() {
        slot.get_in_rules()
        slot.change_bet_minus(2)
        assertTrue(enter_result())
    }
}