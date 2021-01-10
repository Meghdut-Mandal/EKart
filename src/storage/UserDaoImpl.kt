package storage

import domain.User

object UserDaoImpl : UsersDao {

    private val users = mutableListOf<User>()

    init {
     users.add(User("234234","c","c","c".hashCode()))
    }


    override fun getUserByEmailId(id: String): User {
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
            throw IllegalArgumentException("An User with the given ID don't exists! ")
        }
        users.add(user)
    }

    private fun isValidID(id: String): Boolean {
        return users.any { it.id==id }
    }

    override fun getUserById(id: String): User {
        if (isValidID(id)){
            return  users.find { it.id==id }!!
        }
        throw IllegalArgumentException("An User with the given ID don't exists! ")
    }
}