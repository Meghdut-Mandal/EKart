package storage

import domain.Admin

/*
An ArrayList backed Dao
 */
class AdminDaoImpl : AdminDao {

    private val admins = mutableListOf<Admin>()

    override fun getAdminById(id: String): Admin {
        if (isValidID(id)) {
            return admins.find { it.id == id }!!
        }
        throw IllegalArgumentException("The given id is Invalid")
    }

    override fun isValidID(id: String): Boolean {
        return admins.any { it.id == id }
    }

    override fun addAdmin(admin: Admin) {
        if (isValidID(admin.id)) {
            throw IllegalArgumentException("An Admin with the given ID exists! ")
        }
        admins.add(admin)
    }

}