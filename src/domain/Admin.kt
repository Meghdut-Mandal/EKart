package domain

data class Admin(
    val id: String,
    val name: String,
    val email: String,
    val passwordHash: Int,
    val isOwner: Boolean
)