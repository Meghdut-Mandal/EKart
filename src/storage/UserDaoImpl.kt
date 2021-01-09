package storage

import domain.User

class UserDaoImpl : UsersDao {

    private val users = mutableListOf<User>()

    override fun getUserById(id: String): User {
        if (isValidID(id)) {
            return users.find { it.id == id }!!
        }
        throw IllegalArgumentException("The given id is Invalid")
    }

    override fun isValidID(id: String): Boolean {
        return users.any { it.id == id }
    }

    override fun addUser(user: User) {
        if (isValidID(user.id)) {
            throw IllegalArgumentException("An User with the given ID exists! ")
        }
        users.add(user)
    }
}