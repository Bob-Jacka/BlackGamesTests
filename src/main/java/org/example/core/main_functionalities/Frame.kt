package org.example.core.main_functionalities

import javax.swing.JFrame
import kotlin.properties.Delegates

/**
 * Функционал для выделения искомого элемента рамкой.
 * Наследует JFrame.
 * @see javax.swing.JFrame
 */
class Frame() : JFrame() {

    private val height: int = 200
    private val width: int = 200
    private val frameName: string = "Test bound"
    private var x_pos = 0
    private var y_pos = 0

    private constructor(singleton: Singleton) : this() {
        this.x_pos = singleton.getX()
        this.y_pos = singleton.getY()
    }

    companion object SingletonStatic {
        class Singleton() : JFrame() {

            private val height: int = 200
            private val width: int = 200
            private val frameName: string = "Test bound"
            private var x_pos by Delegates.notNull<int>()
            private var y_pos by Delegates.notNull<int>()

            constructor(x_pos: int, y_pos: int) : this() {
                this.x_pos = x_pos
                this.y_pos = y_pos
            }

            fun xCord(x: int) {
                x_pos = x
            }

            fun yCord(y: int) {
                y_pos = y
            }

            fun build(): Frame {
                return Frame(this)
            }

            override fun getX(): int {
                return x_pos
            }

            override fun getY(): int {
                return y_pos
            }
        }
    }

    fun Frame_construct(x_pos: int, y_pos: int): Frame {
        this.x_pos = x_pos
        this.y_pos = y_pos
        initFrame()
        return Frame(singleton = Singleton())
    }

    private fun initFrame() {
        setTitle(frameName)
        setSize(width, height)
        setDefaultCloseOperation(EXIT_ON_CLOSE)
        setLocation(x_pos, y_pos)
        layout = null
        isVisible = true
    }
}
