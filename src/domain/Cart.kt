package domain

import getID

data class Cart(
    val id: String,
    val totalAmount: Double,
    val userId: String,
    val items: MutableList<Product> = mutableListOf(),
    val offers: MutableList<Offer> = mutableListOf()
)

fun Cart.generateBill(): Bill {
    val id = getID()
    return Bill(id, userId, items, offers)
}

fun Cart.isEmpty() = items.isEmpty()
