import domain.Admin
import org.junit.Test
import storage.AdminDao
import storage.AdminDaoImpl

class AdminDaoTest {
    private val adminDao: AdminDao = AdminDaoImpl

    @Test
    fun `add Admin Test`() {
        val admin3 = Admin("3483232449", "m1", "m1", "m".hashCode(), true)
        val admin2 = Admin("234324", "m3", "m2", "m".hashCode(), true)
        val admin1 = Admin("464", "m6", "m3", "m".hashCode(), true)
        adminDao.addAdmin(admin1)
        adminDao.addAdmin(admin2)
        adminDao.addAdmin(admin3)
        assert(adminDao.getAdminById(admin1.email) == admin1)
        assert(adminDao.getAdminById(admin2.email) == admin2)
    }

    @Test
    fun `Test isValid Id`() {
        val admin1 = Admin("4764", "m6", "mk", "m".hashCode(), true)
        adminDao.addAdmin(admin1)
        assert(adminDao.isValidEmailId(admin1.email))
    }

    @Test
    fun `Exception while inserting duplicate Values`() {
        val admin1 = Admin("24244", "m6", "dfdf", "m".hashCode(), true)
        adminDao.addAdmin(admin1)
        val isExceptionThrown =
            try {
                adminDao.addAdmin(admin1)
                false
            } catch (e: IllegalArgumentException) {
                true
            }
        assert(isExceptionThrown)
    }


}