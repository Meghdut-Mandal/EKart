package storage

import domain.Admin

interface AdminDao {
    /*
    Find a Admin by its id
     */
    fun getAdminById(email: String): Admin

    /*
    Checks if an Admin exits for the given id
     */
    fun isValidEmailId(emailId: String): Boolean

    /*
    Adds an new Admin to the database
     */
    fun addAdmin(admin: Admin)
}