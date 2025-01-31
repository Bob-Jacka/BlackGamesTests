package org.example.core.main_functionalities

import org.example.core.main_functionalities.ActionController.click_On
import org.openqa.selenium.Point

//Aliases for kotlin types
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
 * Position of the element on Page
 * Alias for class Point
 * @sample - pos1: ElemPos == pos2: Point
 * @see Point
 */
typealias ElemPos = Point

/**
 * Extension function for Point class, which provides point for second block in bet section.
 * @see Point
 */
fun Point.forSecondBlock(): Point {
    val offset: int = 355 //standard offset for second block
    return this.moveBy(offset, 0)
}

/**
 * Extension function for StackTraceElement class, which provides for each and prints all stackTrace elements one by one.
 * @see StackTraceElement
 * @since 30.01.2025
 */
fun Array<StackTraceElement>.printAll() {
    this.forEach { println("\t $it") }
}

/**
 * Extension function of collection framework, which provides for each and prints all string elements one by one.
 * @see Collection
 * @since 31.01.2025
 */
fun Collection<String>.printAll() {
    this.forEach { println("\t $it") }
}

/**
 * Extension function of String class.
 */
fun String?.print() {
    println(this)
}

/**
 * Method for change coordinates from one monitor to another.
 * *If you have two monitors.
 * @since 27.01.2025
 * @return position of {elemPos} on another monitor
 */
fun get_coords_for_another_monitor(elemPos: ElemPos): ElemPos {
    val standard_monitor_offset = 1920
    return if (elemPos.x < 0) {
        elemPos.moveBy(standard_monitor_offset, 0)
    } else {
        elemPos.moveBy(-standard_monitor_offset, 0)
    }
}

/**
 * @param direction true - если необходимо добавлять, false - если уменьшение ставки
 * @param howMany   Как много раз необходимо выполнить действие
 * @param elemPlus  Элемент контроля добавления ставки
 * @param elemMinus Элемент контроля уменьшения ставки
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