package storage

import domain.User

class UserDaoImpl : UsersDao {

    private val users = mutableListOf<User>()

    override fun getUserById(id: String): User {
        if (isValidEmailId(id)) {
            return users.find { it.email == id }!!
        }
        throw IllegalArgumentException("The given id is Invalid")
    }

    override fun isValidEmailId(emailId: String): Boolean {
        return users.any { it.email == emailId }
    }

    override fun addUser(user: User) {
        if (isValidEmailId(user.email)) {
            throw IllegalArgumentException("An User with the given ID exists! ")
        }
        users.add(user)
    }
}