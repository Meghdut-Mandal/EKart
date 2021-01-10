package controllers

import domain.Category
import getID
import storage.CategoryDao
import storage.CategoryDaoImpl

class CategoriesController(io: IOProvider, private val isAdmin: Boolean) : BaseController(io) {

    private val categoriesDao: CategoryDao = CategoryDaoImpl /// TODO use DI

    override val name: String = "Categories"

    override val description: String =
        if (isAdmin) "Add categories and Products" else "Shop in a particular category "

    override val options: MutableList<BaseController> = mutableListOf()

    init {
        if (isAdmin) {
            options.add(SimpleController("Add Category", ::addCategory))
            options.add(SimpleController(("Add/View Products of a Category"), ::gotoProductsController))

        } else {
            options.add(SimpleController("Shop Products of a Category", ::gotoProductsController))
        }
        options.add(SimpleController("View All categories ", ::viewAll))
    }


    private fun gotoProductsController() {
        val categories = categoriesDao.getAll()
        if (categories.isEmpty()){
            io.println("No Categories Found!")
            return
        }
        io.println("Select a category from the list of Categories")
        viewAll()
        val option = io.readIntItem("Category Index") { it in categories.indices }
        val productsController = ProductsController(io, isAdmin, categories[option])
        productsController.enter()
        productsController.display()
        productsController.exit()
    }

    private fun viewAll() {
        val categories = categoriesDao.getAll()
        io.println("The categories Are :-  ")
        categories.forEachIndexed { index, category ->
            io.println("\t$index.) ${category.name} ")
        }
    }

    private fun addCategory() {
        val categoryName = io.readItem("Category Name")
        val description = io.readItem("Description")
        val id = getID()
        val category = Category(id, categoryName, description)
        categoriesDao.addCategory(category)
    }

}