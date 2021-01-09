package controllers

import domain.Cart
import storage.CartDao
import storage.CartDaoImpl
import storage.UserDaoImpl
import storage.UsersDao

class AdminCartController(io: IOProvider) : BaseController(io) {

    val cartDao: CartDao = CartDaoImpl // TODO use DI
    val usersDao: UsersDao = UserDaoImpl // TODO use DI
    override val name: String
        get() = "User Carts"

    override val description: String
        get() = "View Items in the Cart of users"

    override val options: MutableList<BaseController> = mutableListOf()

    init {
        val allCarts = cartDao.getAllCarts()
        allCarts.forEach { cart ->
            val user = usersDao.getUserById(cart.userId)
            options.add(SimpleController("${user.name} Cart") {
                viewProducts(cart)
            })
        }
    }


    private fun viewProducts(cart: Cart) {
        io.println("The Products in the Cart are")
        cart.items.forEachIndexed { index, product ->
            io.println("\t$index). ${product.name}   Cost: Rs. ${product.price}")
        }
        io.println("Total Gross Price is Rs. ${cart.items.sumByDouble { it.price }}")
    }

}