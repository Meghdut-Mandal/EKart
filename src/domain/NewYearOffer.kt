package domain

class NewYearOffer : Offer() {
    override val description: String
        get() = "Rs. 500 off for purchase of Rs. 10,000"

    override fun isApplicable(cart: Bill) = cart.grossBill > 10_000

    override fun applyOffer(grossPrice: Double): Double {
        return if (grossPrice > 10_000) grossPrice - 500 else grossPrice

    }
}