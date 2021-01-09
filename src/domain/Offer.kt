package domain

abstract class Offer {
    /*
    A short description of the offer
     */
    abstract val description: String

    /*
    Determine if the Offer is applicable on the items currently in the cart
     */
    abstract fun isApplicable(cart: Bill): Boolean

    /*
    Apply the offer on the Gross price
     */
    abstract fun applyOffer(grossPrice: Double): Double
}