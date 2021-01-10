import domain.Category
import org.junit.Test
import storage.CategoryDao
import storage.CategoryDaoImpl

class CategoryDaoTest {
    private val categoryDao: CategoryDao = CategoryDaoImpl

    @Test
    fun `Check Is Valid ID`() {
        val category = Category("cuiwdn29", "Sweet Soup ", "nice soup")
        categoryDao.addCategory(category)
        assert(categoryDao.isValidId(category.id))
    }

    @Test
    fun `Test Dub Insertion in Dao`() {
        val category = Category("wkc", "Sweet Soup ", "nice soup")
        categoryDao.addCategory(category)
        assert(categoryDao.getAll().isNotEmpty())
    }

}