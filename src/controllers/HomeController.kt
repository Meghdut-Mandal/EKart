package controllers

class HomeController(IOProvider: IOProvider) : BaseController(IOProvider) {

    override val name: String
        get() = "Home Page"

    override val description: String
        get() = "You need to continue as an User or an Admin"

    override val options: List<BaseController> = listOf(
        NewUserController(IOProvider),
        AdminController(IOProvider),
        UserController(IOProvider)
    )

}