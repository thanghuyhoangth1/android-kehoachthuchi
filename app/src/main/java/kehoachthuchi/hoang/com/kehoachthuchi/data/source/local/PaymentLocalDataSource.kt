package kehoachthuchi.hoang.com.kehoachthuchi.data.source.local

import io.reactivex.Single
import kehoachthuchi.hoang.com.kehoachthuchi.data.model.Payment
import kehoachthuchi.hoang.com.kehoachthuchi.data.source.PaymentDataSource
import kehoachthuchi.hoang.com.kehoachthuchi.data.source.local.database.PaymentDao

class PaymentLocalDataSource(val paymentDao: PaymentDao) : PaymentDataSource.Local {
    override fun getPayments(): Single<List<Payment>> = paymentDao.getPayments()

    override fun getPayment(paymentId: Int): Single<Payment> = paymentDao.getPayment(paymentId)

    override fun insertPayment(payment: Payment): Long = paymentDao.insertPayment(payment)

    override fun deletePayment(payment: Payment): Int = paymentDao.deletePayment(payment)

    override fun updatePayment(payment: Payment) = paymentDao.updatePayment(payment)
}