package controllers

import domain.Bill
import storage.*

class AdminController(IOProvider: IOProvider) : BaseController(IOProvider) {

    private val adminDao: AdminDao = AdminDaoImpl // TODO use DI
    private val billDao: BillDao = BillsDaoImpl // TODO use DI
    private val userDao: UsersDao = UserDaoImpl // TODO use DI

    override fun enter(): Boolean {
        io.println("Welcome to Admin Login")
        val email = io.readItem("Email")
        if (adminDao.isValidEmailId(email)) {
            val passwordHash = io.readItem("Password").hashCode()
            val admin = adminDao.getAdminById(email)
            return if (admin.passwordHash == passwordHash) {
                io.println("Login Successfully  for Admin ${admin.name}")
                true
            } else {
                io.println("Login Failed. Please Try again")
                false
            }
        }
        return false
    }

    override val name: String
        get() = "Admin Page"

    override val description: String
        get() = "You have Admin access to all user data and Products"

    override val options: List<BaseController> = listOf(
        CategoriesController(io, true),
        AdminCartController(io),
        SimpleController("View Bills Generated", ::viewBills)
    )

    private fun viewBills() {
        val allBills = billDao.getAllBills()
        io.println("The Bills Generated  by the users")
        allBills.forEachIndexed { index: Int, bill: Bill ->
            val user = userDao.getUserById(bill.userID)
            io.println("\t$index.) ID${bill.id}  User: ${user.name}  Bill Amount: Rs. ${bill.totalPrice}")
        }
    }

}