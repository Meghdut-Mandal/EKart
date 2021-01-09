package storage

import domain.Product

object ProductsDaoImpl : ProductsDao {

    private val products = mutableListOf<Product>()
    override fun isValidId(id: String): Boolean {
        return products.any { it.id == id }
    }

    override fun findProductById(id: String): Product {
        if (isValidId(id)) {
            return products.find { it.id == id }!!
        }
        throw IllegalArgumentException("No product exists for the given ID")
    }

    override fun findProductsByCategory(categoryId: String): List<Product> {
        return products.filter { it.categoryId == categoryId }
    }


    override fun addProduct(product: Product) {
        if (isValidId(product.id)) {
            throw IllegalArgumentException("Product having a same Id Exist")
        }
        products.add(product)
    }

    override fun getAll(): List<Product> {
        return products
    }

}