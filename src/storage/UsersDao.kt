package storage

import domain.User

interface UsersDao {
    /*
     Find user by its id
     */
    fun getUserByEmailId(id: String): User

    /*
    Checks weather an user exists for the given Id
     */
    fun isValidEmailId(emailId: String): Boolean

    /*
    Adds a new user to the Database
     */
    fun addUser(user: User)

    fun getUserById(id: String):User
}