package org.example.core.functional

import org.example.core.functional.ActionController.click_On
import org.openqa.selenium.Point

//Псевдонимы для всех типов языка Kotlin
typealias string = String
typealias str = String
typealias bool = Boolean
typealias int = Int
typealias long = Long
typealias char = Char
typealias byte = Byte
typealias short = Short
typealias float = Float
typealias double = Double

/**
 * Позиция элемента на странице
 * Псевдоним для класса Point
 * @sample - pos1: ElemPos == pos2: Point
 */
typealias ElemPos = Point

/**
 * Extension function for Point class, which provides point for second block in bet section
 */
fun Point.forSecondBlock(): Point {
    val offset: int = 355 //standard offset for second block
    return this.moveBy(offset, 0)
}

/**
 * @param direction true - если необходимо добавлять, false - если уменьшение ставки
 * @param howMany   как много раз необходимо выполнить действие
 * @param elemPlus  элемент контроля добавления ставки
 * @param elemMinus элемент контроля уменьшения ставки
 * @sample increase_or_decrease(up,howMany,plus_coef_btn.getFor_secondBlock (), minus_coef_btn.getFor_secondBlock())
 */
@Deprecated(message = "since 20.01.2025")
fun increase_or_decrease(direction: bool, howMany: int, elemPlus: ElemPos, elemMinus: ElemPos) {
    if (direction) {
        repeat(howMany) {
            click_On(elemPlus)
        }
    } else {
        repeat(howMany) {
            click_On(elemMinus)
        }
    }
}