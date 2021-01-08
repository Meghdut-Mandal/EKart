package controllers

import kotlin.system.exitProcess

abstract class BaseController {

    /*
     Get a Human  readable name of the
     */
    abstract val name: String

    /*
    A short description of the functionality
     */
    abstract val description: String

    abstract val options: List<BaseController>

    abstract fun readOption(): String

    open fun display() {
        do {
            var canContinue: Boolean
            val title = "$name ::: $description"
            println("-".repeat(title.length))
            println(title)
            println("-".repeat(title.length))
            println("Enter a key corresponding to the option")
            options.forEachIndexed { index: Int, baseController: BaseController ->
                println("\t$index.) ${baseController.name} ")
            }
            println("\t${options.size}.) Exit ")
            val ans = readOption().toInt()
            when (ans) {
                in options.indices -> {
                    val selectedController = options[ans]
                    selectedController.display()
                    canContinue = true
                }

                options.size -> {
                    println("Thanks for shopping! Visit us again.")
                    exitProcess(0)
                }
                else -> {
                    print("Please Enter a valid choice!")
                    canContinue = true
                }
            }
        } while (canContinue)
    }

}