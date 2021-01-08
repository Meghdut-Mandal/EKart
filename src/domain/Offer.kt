package domain

abstract class Offer {
    /*
    A short description of the offer
     */
    abstract val description: String

    /*
    Determine if the Offer is applicable on the items currently in the cart
     */
    abstract fun isApplicable(cart: Cart): Boolean
}