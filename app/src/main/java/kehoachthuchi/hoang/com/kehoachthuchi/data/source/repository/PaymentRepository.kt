package kehoachthuchi.hoang.com.kehoachthuchi.data.source.repository

import io.reactivex.Single
import kehoachthuchi.hoang.com.kehoachthuchi.data.model.Payment
import kehoachthuchi.hoang.com.kehoachthuchi.data.source.PaymentDataSource

class PaymentRepository( val local: PaymentDataSource.Local) :
    PaymentDataSource.Remote, PaymentDataSource.Local {
    override fun getPayments(): Single<List<Payment>> = local.getPayments()
    override fun getPayment(paymentId: Int): Single<Payment> = local.getPayment(paymentId)
    override fun insertPayment(payment: Payment): Long = local.insertPayment(payment)
    override fun deletePayment(payment: Payment): Int = local.deletePayment(payment)
    override fun updatePayment(payment: Payment) = local.updatePayment(payment)
}