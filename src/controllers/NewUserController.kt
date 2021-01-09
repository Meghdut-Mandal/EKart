package controllers

import domain.Admin
import domain.User
import getID
import storage.AdminDao
import storage.AdminDaoImpl
import storage.UserDaoImpl
import storage.UsersDao

class NewUserController(io: IOProvider) : BaseController(io) {

    private val adminDao: AdminDao = AdminDaoImpl// TODO use DI
    private val userDao: UsersDao = UserDaoImpl  // TODO use DI

    override val name: String
        get() = "Create New User or Admin"
    override val description: String
        get() = " You can Signup as an User or Admin "

    override val options: List<BaseController> = listOf(
        SimpleController("Create User", ::userCreate),
        SimpleController("Create Admin", ::adminCreate)
    )

    private fun adminCreate() {
        val name = io.readItem("Admin Name")
        val password = io.readItem("Password")
        val email = io.readItem("Email")
        io.println("Are you the Owner? (y/n)")
        val isOwner = io.readLine().contains("y")
        val id = getID()
        val admin = Admin(id, name, email, password.hashCode(), isOwner)
        adminDao.addAdmin(admin)
        io.println("Admin created successfully, Go back to Login as Admin")
    }

    private fun userCreate() {
        val name = io.readItem("User Name")
        val password = io.readItem("Password")
        val email = io.readItem("Email")
        val id = getID()
        val user = User(id, name, email, password.hashCode())
        userDao.addUser(user)
        io.println("User created Successfully,  Go back to Login as User")
    }

}