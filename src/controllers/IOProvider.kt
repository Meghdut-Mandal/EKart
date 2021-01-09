package controllers


interface IOProvider {
    fun readLine(): String
    fun println(line: String)
    fun println(obj: Any)
}

/*
 Reads an item from the IOProvider preventing Empty Values from the User
 */
fun IOProvider.readItem(name: String, empty: Boolean = false): String {
    var input: String
    do {
        this.println("Enter the $name")
        input = this.readLine()

        if (!empty && input.isBlank()) {
            this.println("$name can't be empty Please try again!")
            continue
        } else {
            return input
        }

    } while (input.isBlank() && !empty)

    return input
}