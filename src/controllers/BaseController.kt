package controllers

import kotlin.system.exitProcess

abstract class BaseController(val io: IOProvider) {

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
            io.println("-".repeat(title.length))
            io.println(title)
            io.println("-".repeat(title.length))
            io.println("Enter a key corresponding to the option")
            options.forEachIndexed { index: Int, baseController: BaseController ->
                io.println("\t$index.) ${baseController.name} ")
            }
            io.println("\t${options.size}.) Go Back ")
            io.println("\t${options.size + 1}.) Exit Program")
            val ans = io.readLine().toInt()
            when (ans) {
                in options.indices -> {
                    selectedOption(ans)
                    canContinue = true
                }

                options.size -> {
                    canContinue = false
                }

                options.size + 1 -> {
                    io.println("Thanks for shopping! Visit us again.")
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