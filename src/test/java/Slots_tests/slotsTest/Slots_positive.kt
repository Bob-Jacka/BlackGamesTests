package Slots_tests.slotsTest

import BaseTest
import io.qameta.allure.SeverityLevel
import org.example.core.annotations.TestCase
import org.example.core.games.Slots.BaseSlot
import org.example.core.main_functionalities.ActionController.enter_Result
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Tag
import org.springframework.beans.factory.annotation.Autowired

@Tag("Positive")
class Slots_positive : BaseTest() {

    @Autowired
    private lateinit var slot: BaseSlot

    @TestCase(severity = SeverityLevel.CRITICAL)
    fun `Should increase bet`() {
        slot = currentGame as BaseSlot
        slot.change_bet_plus(2)
        assertTrue(enter_Result())
    }

    @TestCase(severity = SeverityLevel.CRITICAL)
    fun `Should decrease bet`() {
        slot = currentGame as BaseSlot
        slot.change_bet_minus(2)
        assertTrue(enter_Result())
    }

    @TestCase
    fun `Should turn on music`() {
        slot = currentGame as BaseSlot
        slot.set_sound_on(true)
        assertTrue(enter_Result())
    }

    @TestCase
    fun `Should turn off music`() {
        slot = currentGame as BaseSlot
        slot.set_sound_on(false)
        assertTrue(enter_Result())
    }

    @TestCase
    fun `Should change speed`() {
        slot = currentGame as BaseSlot
        slot.change_speed(2)
        assertTrue(enter_Result())
    }

    @TestCase
    fun `Should enter the rules page`() {
        slot = currentGame as BaseSlot
        slot.get_in_rules()
        assertTrue(enter_Result())
    }

    @TestCase
    fun `Should close the rules page`() {
        slot = currentGame as BaseSlot
        slot.close_rules()
        assertTrue(enter_Result())
    }

    @TestCase
    fun `Should change bet in rules page - plus`() {
        slot = currentGame as BaseSlot
        slot.get_in_rules()
        slot.change_pages_in_rules(7)
        assertTrue(enter_Result())
    }

    @TestCase
    fun `Should change bet in rules page - minus`() {
        slot = currentGame as BaseSlot
        slot.get_in_rules()
        slot.change_bet_minus(2)
        assertTrue(enter_Result())
    }
}