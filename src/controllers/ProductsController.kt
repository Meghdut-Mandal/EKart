package controllers

import domain.Category
import domain.Product
import storage.CartDao
import storage.CartDaoImpl
import storage.ProductsDao
import storage.ProductsDaoImpl

class ProductsController(
    IOProvider: IOProvider,
    isAdmin: Boolean,
    private val category: Category,
    private val userID: String = ""
) :
    BaseController(IOProvider) {

    private val cartDao: CartDao = CartDaoImpl

    private val productsDao: ProductsDao = ProductsDaoImpl

    override val name: String = "Products in Category ${category.name}"

    override val description: String =
        if (isAdmin) "Add or View All Products " else "Add Products to Cart"

    override val options: MutableList<BaseController> = mutableListOf()

    init {
        if (isAdmin) {
            options.add(SimpleController("Add Product", ::addProduct))
        } else {
            options.add(SimpleController("Buy/View Products", ::purchaseProduct))
        }
        options.add(SimpleController("View All Products", ::viewAllProducts))
    }

    private fun purchaseProduct() {
        io.println("Choose a product index ")
        viewAllProducts()
        val productsByCategory = productsDao.findProductsByCategory(category.id)
        val option = io.readIntItem("Product Index") { it in productsByCategory.indices }
        val selectedProduct = productsByCategory[option]
        io.println("${selectedProduct.name} added to Cart")
        cartDao.addProductToCart(selectedProduct, userID)
    }

    private fun viewAllProducts() {
        val productsByCategory = productsDao.findProductsByCategory(category.id)
        productsByCategory.forEachIndexed { index: Int, product: Product ->
            io.println("\t$index). ${product.name}")
        }
    }


    private fun addProduct() {
        val productName = io.readItem("Product Name")
        val price =
            io.readDoubleItem("Price") { price -> price > 0.0 }  // Lambda function to validate the Price entered
        val id = System.currentTimeMillis().toString()
        val description = io.readItem("Description")
        val product = Product(id, productName, price, description, category.id)
        productsDao.addProduct(product)
    }
}