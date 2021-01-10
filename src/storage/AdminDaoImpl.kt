package storage

import domain.Admin

/*
An ArrayList backed Dao
 */
object AdminDaoImpl : AdminDao {

    private val admins = mutableListOf<Admin>()

    init {
        admins.add(Admin("3483249","m","m","m".hashCode(),true))
    }

    override fun getAdminById(email: String): Admin {
        if (isValidEmailId(email)) {
            return admins.find { it.email == email }!!
        }
        throw IllegalArgumentException("The given id is Invalid")
    }

    override fun isValidEmailId(emailId: String): Boolean {
        return admins.any { it.email == emailId }
    }

    override fun addAdmin(admin: Admin) {
        if (isValidEmailId(admin.email)) {
            throw IllegalArgumentException("An Admin with the given ID exists! ")
        }
        admins.add(admin)
    }

}