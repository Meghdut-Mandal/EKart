package controllers

/*
A simplified controller which doesn't have any more nested Controllers
 */
open class SimpleController(
    IOProvider: IOProvider,
    override val name: String,
    val displayFunc: () -> Unit
) : BaseController(IOProvider) {

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
) = SimpleController(io, name, displayFunc)