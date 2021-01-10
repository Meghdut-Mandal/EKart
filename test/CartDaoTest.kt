import domain.Product
import org.junit.Test
import storage.CartDao
import storage.CartDaoImpl

class CartDaoTest {

    private val cartDao: CartDao = CartDaoImpl
    private val userID = "23423"
    private val categoryID = "12"

    @Test
    fun `Test empty Cart`() {
        assert(cartDao.getAllCarts().isEmpty())
        val cart = cartDao.getCart("24234")
        val cart2 = cartDao.getCart("dfaf")
        assert(cart != cart2)
    }


    @Test
    fun `Test Add product to cart`() {
        val cart = cartDao.getCart(userID)
        val product = Product("1212", "SoyaBeen", 2323.00, "Very Sweet", categoryID)
        cartDao.addProductToCart(product, userID)
        val cart2 = cartDao.getCart(userID)
        assert(cart == cart2)
    }


    @Test
    fun `Test getAllCart `() {
        val cart = cartDao.getCart(userID)
        val product = Product("1212", "SoyaBeen", 100000.00, "Very Sweet", categoryID)
        val product2 = Product("1212", "SoyaBeen", 2323.00, "Very Sweet", categoryID)
        cartDao.addProductToCart(product, userID)
        cartDao.addProductToCart(product2, userID)
        assert(cartDao.getAllCarts().contains(cart))
    }



}