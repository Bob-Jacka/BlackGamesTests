package org.example.core.settings
//
//import org.example.core.functional.Extensions.string
//import org.example.core.functional.Extensions.int
//
///**
// * Функционал для выделения искомого элемента рамкой
// */
//class Frame : JFrame() {
//
//    private val height: int = 200
//    private val width: int = 200
//    private val frameName: string = "Test bound"
//    private var closeMode: int by Delegates.notNull<int>()
//    private var x_pos = 0
//    private var y_pos = 0
//
//    private constructor()
//    private constructor(singleton: singleton) : super() {
//        this.x_pos = singleton.getX()
//        this.y_pos = singleton.getY()
//    }
//
//    class singleton {
//
//        private var x_pos by Delegates.notNull<int>()
//        private var y_pos by Delegates.notNull<int>()
//
//        fun xCord(x: int) {
//            x_pos = x
//        }
//
//        fun yCord(y: int) {
//            y_pos = y
//        }
//
//        fun build(): Frame {
//            return Frame(this)
//        }
//
//        fun getX(): int {
//            return x_pos
//        }
//
//        fun getY(): int {
//            return y_pos
//        }
//
//        fun Frame_construct(x_pos: int, y_pos: int) {
//            this.x_pos = x_pos
//            this.y_pos = y_pos
//            initFrame()
//        }
//
//        private fun initFrame() {
//            setTitle(frameName)
//            setSize(width, height)
//            setDefaultCloseOperation()
//            setLocation(x_pos, y_pos)
//            layout = null
//            isVisible = true
//        }
//    }
//}