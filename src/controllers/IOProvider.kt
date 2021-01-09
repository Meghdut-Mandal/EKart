package controllers


interface IOProvider {
    fun readLine(): String
    fun println(line: String)
    fun println(obj: Any)
}