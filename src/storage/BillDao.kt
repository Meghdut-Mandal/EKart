package storage

import domain.Bill

interface BillDao {

    fun hasBill(userId: String): Boolean

    fun getAllBills(): List<Bill>

    fun getUserBills(userId: String): List<Bill>

    fun addBill(bill: Bill)
}