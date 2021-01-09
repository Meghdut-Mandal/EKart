package storage

import domain.Cart
import domain.Product

object CartDaoImpl : CartDao {

    private val userCarts: MutableList<Cart> = mutableListOf()

    override fun getCart(userId: String): Cart {
        return userCarts.find { it.userId == userId } ?: newCart(userId)
    }

    override fun getAllCarts(): List<Cart> {
        return userCarts
    }

    override fun addProductToCart(product: Product, userId: String) {
        val cart= getCart(userId)
        cart.items
    }

    private fun newCart(userId: String): Cart {
        val id = System.currentTimeMillis().toString()
        return Cart(id, 0.0, userId)
    }


}