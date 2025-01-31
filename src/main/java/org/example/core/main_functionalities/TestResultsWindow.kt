package org.example.core.main_functionalities

import java.awt.BorderLayout
import java.awt.Color
import java.awt.event.ActionListener
import java.util.*
import javax.swing.*

/**
 * Mini window for entering test result.
 * @since 31.01.2025
 */
class TestResultsWindow {

    private val main_window: JFrame

    private val approve_btn: JButton
    private val fail_btn: JButton
    private val skip_btn: JButton

    private constructor() {
        main_window = JFrame("Test runner")
        approve_btn = JButton("Test success")
        fail_btn = JButton("Test failed")
        skip_btn = JButton("Test skip")
    }

    companion object Singleton {

        @Volatile
        private var instance: TestResultsWindow? = null

        fun get_instance(): TestResultsWindow? {
            instance ?: synchronized(this) {
                instance ?: TestResultsWindow().init_test_results_window().also {
                    instance = it
                }
            }
            return instance
        }
    }

    /**
     * Constructs the window object with three buttons and actions on it.
     */
    fun init_test_results_window(): TestResultsWindow? {
        approve_btn.addActionListener(
                ActionListener(
                        function = { println("Нажата кнопка test success") })
                                     )
        approve_btn.background = Color.GREEN
//        approve_btn.addKeyListener()

        fail_btn.addActionListener(
                ActionListener(
                        function = { println("Нажата кнопка test failed") })
                                  )
        fail_btn.background = Color.RED
//        fail_btn.addKeyListener()

        skip_btn.addActionListener(
                ActionListener(
                        function = { println("Нажата кнопка test skip") })
                                  )
//        skip_btn.addKeyListener()
        skip_btn.background = Color.GRAY

        main_window.contentPane.add(BorderLayout.NORTH, approve_btn)
        main_window.contentPane.add(BorderLayout.CENTER, skip_btn)
        main_window.contentPane.add(BorderLayout.SOUTH, fail_btn)
        main_window.jMenuBar = Menu().getBar()
        main_window.setSize(600, 600)
        main_window.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        main_window.isAlwaysOnTop = true
        main_window.isVisible = true
        return instance
    }

    /**
     * Destroys the window object.
     */
    fun destroy() {
        main_window.dispose()
        main_window.invalidate()
    }
}

/**
 * Menu item in test result window.
 */
class Menu {

    /**
     * Main menu item.
     * @see JMenu
     */
    private var menu: JMenu

    /**
     * Array of menu items with actions.
     * @see JMenuItem
     */
    private lateinit var items: Array<JMenuItem>

    /**
     * Menu bar which will be integrated in TestResultWindow object.
     * @see TestResultsWindow
     * @see JMenuBar
     */
    private var bar: JMenuBar

    constructor() {
        this.menu = JMenu()
        this.bar = JMenuBar()
        initMenu()
    }

    /**
     * Method that creates menu items with actions.
     * BAR <- menu <- items.
     * And then TestResultWindow <- bar.
     *
     * <left elem> '<-' <right elem> - means include right elem in left elem.
     */
    private fun initMenu() {
        menu.setText("Test options")
        val stop_exec = JMenuItem("Stop execution")
        val reset_exec = JMenuItem("Reset test run")
        val resume_exec = JMenuItem("Resume test run")

        stop_exec.addActionListener { println("Clicked on stop exec") }
        reset_exec.addActionListener { println("Clicked on reset exec") }
        resume_exec.addActionListener { println("Clicked on resume test exec") }
        items = arrayOf(
                stop_exec,
                resume_exec,
                reset_exec
                       )
        Arrays.stream(items).forEach(menu::add)
        bar = JMenuBar()
        bar.add(menu)
    }

    internal fun getBar(): JMenuBar {
        if (bar != null) {
            return bar
        }
        println("Bar element is null, return empty jMenuBar")
        return JMenuBar()
    }
}