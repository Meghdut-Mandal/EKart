package storage

import domain.Category

interface CategoryDao {

    fun isValidId(id: String): Boolean

    fun addCategory(category: Category)

    fun getAll(): List<Category>
}