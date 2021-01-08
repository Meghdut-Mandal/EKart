package controllers

/*
A simplified controller which doesn't have any more nested Controllers
 */
open class SimpleController(
    inputProvider: InputProvider,
    override val name: String,
    val displayFunc: () -> Unit
) : BaseController(inputProvider) {

    override val description: String
        get() = ""
    override val options: List<BaseController>
        get() = listOf()

    override fun display() = displayFunc()
}

/*
Extension function to avoid passing inputProvider Everytime
 */
fun BaseController.SimpleController(
    name: String,
    displayFunc: () -> Unit
) = SimpleController(inputProvider, name, displayFunc)