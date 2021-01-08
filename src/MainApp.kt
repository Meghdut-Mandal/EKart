import controllers.HomeController
import controllers.InputProvider
import java.util.*

object MainApp : InputProvider {

    @JvmStatic
    fun main(args: Array<String>) {
        val homeController = HomeController(this)
        homeController.display()
    }

    val scanner = Scanner(System.`in`)

    override fun readLine(): String {
        return scanner.nextLine()
    }

}