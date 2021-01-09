package controllers

import domain.Cart
import domain.isEmpty
import storage.CartDao
import storage.CartDaoImpl

/*
Helps the user to view and Remoce
 */
class CartController(io: IOProvider, private val userId: String) : BaseController(io) {

    private val cartDao: CartDao = CartDaoImpl

    override val name: String
        get() = "Cart "

    override val description: String
        get() = "View and Remove Items from the cart"

    override val options: List<BaseController> = listOf(
        SimpleController("View Cart Details", ::viewProducts),
        SimpleController("Remove Products", ::removeProducts)
    )

    override fun enter(): Boolean {
        io.println("To add products go to their respective categories,")
        return true
    }

    private val cart: Cart
        get() = cartDao.getCart(userId)

    private fun removeProducts() {
        if (cart.isEmpty()) {
            io.println("The cart is Empty!")
            return
        }
        io.println("Choose a product Index to Remove")
        viewProducts()
        val choice = io.readIntItem("Product Index") { it in cart.items.indices }
        val removedProduct = cart.items.removeAt(choice)
        io.println("Item ${removedProduct.name} removed from Cart")
    }

    private fun viewProducts() {
        if (cart.isEmpty()) {
            io.println("The cart is Empty!")
            return
        }
        cart.items.forEachIndexed { index, product ->
            io.println("$index.) ${product.categoryId}  : ${product.desc}")
        }
    }
}