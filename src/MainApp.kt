import controllers.HomeController
import controllers.IOProvider
import java.lang.System.out
import java.util.*

object MainApp : IOProvider {

    @JvmStatic
    fun main(args: Array<String>) {
        val homeController = HomeController(this)
        homeController.display()
    }

    private val scanner = Scanner(System.`in`)

    override fun readLine(): String {
        return scanner.nextLine()
    }

    override fun println(line: String) {
        kotlin.io.println(line)
    }

    override fun println(obj: Any) {
        println(obj.toString())
    }

}