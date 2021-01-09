package storage

import domain.Bill

object BillsDaoImpl : BillDao {

    private val userBills: MutableList<Bill> = mutableListOf()

    override fun getUserBills(userId: String): List<Bill> {
        return userBills.filter { it.userID == userId }
    }

    override fun hasBill(userId: String): Boolean {
        return userBills.any { it.userID == userId }
    }

    override fun getAllBills(): List<Bill> {
        return userBills
    }
}