package storage

import domain.Cart
import domain.Product

interface CartDao {

    fun getCart(userId: String): Cart

    fun getAllCarts(): List<Cart>

    fun addProductToCart(product: Product, userId: String)
}