package controllers

class SimpleController(
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