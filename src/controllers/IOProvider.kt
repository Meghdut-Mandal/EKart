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

/*
 Read a proper Double value properly from the provider.Prompt if wrong  Value entered
 */
fun IOProvider.readDoubleItem(name: String, isValid: (Double) -> Boolean = { true }): Double {
    val input = 0.0
    do {
        val str = readItem(name).toDoubleOrNull()

        if (str == null || isValid(str)) {
            println("Enter a valid $name")
            continue
        } else {
            return str
        }

    } while (!isValid(input))

    return 0.0
}

/*
 Read an integer properly. And Prompt if wrong value entered.
 */
fun IOProvider.readIntItem(name: String, isValid: (Int) -> Boolean = { true }): Int {
    val input = 0
    do {
        val str = readItem(name).toIntOrNull()

        if (str == null || !isValid(str)) {
            println("Invalid $name Entered ")
            continue
        } else {
            return str
        }

    } while (!isValid(input))

    return 0
}