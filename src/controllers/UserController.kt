package controllers

import domain.User
import domain.emptyCart
import domain.generateBill
import storage.*

class UserController(IOProvider: IOProvider) : BaseController(IOProvider) {

    private val userDao: UsersDao =
        UserDaoImpl // TODO use Dependency Injection to resolve Implementations
    private lateinit var user: User
    private val cartDao: CartDao = CartDaoImpl
    private val billDao: BillDao = BillsDaoImpl

    /*
     Perform a login of the User. By comparing password Hashes
     */
    override fun enter(): Boolean {
        io.println("Welcome to User Login")
        val email = io.readItem("Email")
        if (userDao.isValidEmailId(email)) {
            val passwordHash = io.readItem("Password").hashCode()
            val user = userDao.getUserById(email)
            return if (user.passwordHash == passwordHash) {
                io.println("Login Successfully  for User ${user.name}")
                this.user = user
                true
            } else {
                io.println("Login Failed. Please Try again")
                false
            }
        }
        return false
    }

    override val name: String
        get() = "User Page"


    override val description: String
        get() = " You can shop for Products and add them to cart"


    override val options: List<BaseController> = listOf(
        CategoriesController(io, false),
        SimpleController("Checkout from Cart", ::checkOut),
        CartController(io, user.id)
    )

    private fun checkOut() {
        val cart = cartDao.getCart(user.id)
        val bill = cart.generateBill()
        billDao.addBill(bill)
        // clear the cart
        cart.emptyCart()
        io.println("Gross Bill Amount = Rs. ${bill.grossBill}")
        io.println("Final Bill Amount = Rs. ${bill.totalPrice}")
    }

}