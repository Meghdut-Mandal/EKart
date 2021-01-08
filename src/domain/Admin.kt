package domain

data class Admin(
    val id: String,
    val name: String,
    val email: String,
    val passwordHash: String,
    val isOwner: String
)