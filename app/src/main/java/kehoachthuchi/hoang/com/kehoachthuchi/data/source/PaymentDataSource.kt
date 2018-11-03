package kehoachthuchi.hoang.com.kehoachthuchi.data.source

import io.reactivex.Single
import kehoachthuchi.hoang.com.kehoachthuchi.data.model.Payment

interface PaymentDataSource {
    interface Local {
        fun getPayments(): Single<List<Payment>>
        fun getPayment(paymentId: Int): Single<Payment>
        fun insertPayment(payment: Payment): Long
        fun deletePayment(payment: Payment): Int
        fun updatePayment(payment: Payment)
    }

    interface Remote {

    }
}