package domain

data class Product(
    val id: String,
    val name: String,
    val price: Double,
    val desc: String,
    val catagoryId: String
)
