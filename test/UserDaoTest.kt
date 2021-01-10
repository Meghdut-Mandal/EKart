import domain.User
import org.junit.Test
import storage.UserDaoImpl
import storage.UsersDao

class UserDaoTest {

    private val userDao: UsersDao = UserDaoImpl

    @Test
    fun `Add users to Dao`() {
        val user = User("2kjkb324", "cmkc", "cdccd", "ccd".hashCode())
        userDao.addUser(user)
        assert(user == userDao.getUserByEmailId(user.email))
    }

    @Test
    fun `Exception when inserting duplicate values`() {
        val user = User("dcb", "cwc", "49929", "9389".hashCode())
        userDao.addUser(user)
        val isExceptionThrown =
            try {
                userDao.addUser(user)
                false
            } catch (e: IllegalArgumentException) {
                true
            }
        assert(isExceptionThrown)
    }

    @Test
    fun `Check isValid Email`() {
        val user = User("dkdbcb", "22cwc", "2249929", "dks".hashCode())
        userDao.addUser(user)
        assert(userDao.isValidEmailId(user.email))
    }

}