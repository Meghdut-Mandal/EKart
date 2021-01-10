package domain

import getID

data class Cart(
    val id: String,
    val totalAmount: Double,
    val userId: String,
    val items: MutableList<Product> = mutableListOf(),
    val offers: MutableList<Offer> = mutableListOf()
)

fun Cart.emptyCart() {
    items.removeAll { true }
}

fun Cart.generateBill(): Bill {
    val id = getID()
    val billItems = mutableListOf<Product>()
    billItems.addAll(items)
    val billOffers = mutableListOf<Offer>()
    billOffers.addAll(offers)
    return Bill(id, userId, billItems, billOffers)
}

fun Cart.isEmpty() = items.isEmpty()
