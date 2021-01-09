package storage

import domain.Product

interface ProductsDao {
    fun isValidId(id: String): Boolean

    fun findProductById(id: String): Product

    fun findProductsByCategory(categoryId: String): List<Product>

    fun addProduct(product: Product)
    fun getAll(): List<Product>
}