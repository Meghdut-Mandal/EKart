package storage

import domain.Category

object CategoryDaoImpl : CategoryDao {
    private val categories = mutableListOf<Category>()

    init {
        categories.add(Category("234234", "Milk", "Good for health"))
    }

    override fun isValidId(id: String): Boolean {
        return categories.any { it.id == id }
    }

    override fun addCategory(category: Category) {
        if (isValidId(category.id)) {
            throw IllegalArgumentException("A category Having the same ID Exists")
        }
        categories.add(category)
    }

    override fun getAll(): List<Category> {
        return categories
    }
}