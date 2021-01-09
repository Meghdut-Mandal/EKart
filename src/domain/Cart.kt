package domain

data class Cart(
    val id: String,
    val totalAmount: Double,
    val userId: String,
    val items: MutableList<Product> = mutableListOf(),
    val offers: MutableList<Offer> = mutableListOf()
)
