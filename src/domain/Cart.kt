package domain

data class Cart(
    val id: String,
    val totalAmount: Double,
    val list: List<Product> = listOf(),
    val offers: List<Offer> = listOf()
)
