package controllers

import kotlin.system.exitProcess

abstract class BaseController(val inputProvider: InputProvider) {

    /*
     Get a Human  readable name of the
     */
    abstract val name: String

    /*
    A short description of the functionality
     */
    abstract val description: String

    abstract val options: List<BaseController>

    /*
     Verify that the user can enters the controller
     */
    open fun enter(): Boolean {
        return true
    }

    /*
     Called when the user exits from the controller
     */
    open fun exit(): Boolean {
        return true
    }

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
            val ans = inputProvider.readLine().toInt()
            when (ans) {
                in options.indices -> {
                    selectedOption(ans)
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


    open fun selectedOption(index: Int) {
        val selectedController = options[index]
        if (selectedController.enter()) {
            selectedController.display()
            selectedController.exit()
        }
    }

}