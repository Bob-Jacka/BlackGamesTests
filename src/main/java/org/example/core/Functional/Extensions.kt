package org.example.core.pages

import org.openqa.selenium.Point

fun Point.getFor_secondBlock(): Point {
    val offset: Int = 355;
    return this.moveBy(offset, 0);
}