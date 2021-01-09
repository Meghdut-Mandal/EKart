package domain

data class Bill(
    val id: String,
    val userID: String,
    val items: List<Product>,
    val offers: List<Offer>
) {
    val totalPrice: Double
        get() {
            var gross = grossBill
            offers.filter { it.isApplicable(this) }
                .forEach {
                    gross = it.applyOffer(gross)
                }
            return gross

        }

    val grossBill: Double
        get() = items.sumByDouble { it.price }
}