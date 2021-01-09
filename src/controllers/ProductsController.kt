package controllers

class ProductsController(IOProvider: IOProvider, val isAdmin: Boolean, val catagoryID: String) :
    BaseController(IOProvider) {

    override val name: String
        get() = "Products"

    override val description: String =
        if (isAdmin) "Add,Remove or View All Products " else "Add Products to Cart"

    override val options: MutableList<BaseController> = mutableListOf()

    init {
        if (isAdmin) {
            options.add(SimpleController("Add Product", ::addProduct))
        }

    }


    private fun addProduct() {
        val productName = io.readItem("Product Name")
        val price = io.readDoubleItem("Price")
        val id = System.currentTimeMillis().toString()

    }
}