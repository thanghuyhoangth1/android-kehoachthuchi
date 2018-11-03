package kehoachthuchi.hoang.com.kehoachthuchi.data.source.local.database

import android.arch.persistence.room.*
import io.reactivex.Single
import kehoachthuchi.hoang.com.kehoachthuchi.data.model.Payment

@Dao
interface PaymentDao {
    @Query("SELECT * FROM payment")
    fun getPayments(): Single<List<Payment>>

    @Query("SELECT * FROM payment WHERE id=:paymentId")
    fun getPayment(paymentId: Int): Single<Payment>

    @Insert
    fun insertPayment(payment: Payment): Long

    @Delete
    fun deletePayment(payment: Payment): Int

    @Update
    fun updatePayment(payment: Payment)
}