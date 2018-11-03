package kehoachthuchi.hoang.com.kehoachthuchi.di

import android.arch.persistence.room.Room
import android.content.Context
import kehoachthuchi.hoang.com.kehoachthuchi.data.source.PaymentDataSource
import kehoachthuchi.hoang.com.kehoachthuchi.data.source.local.PaymentLocalDataSource
import kehoachthuchi.hoang.com.kehoachthuchi.data.source.local.database.AppDataBase
import kehoachthuchi.hoang.com.kehoachthuchi.data.source.local.database.PaymentDao
import kehoachthuchi.hoang.com.kehoachthuchi.data.source.remote.PaymentRemoteDataSource
import kehoachthuchi.hoang.com.kehoachthuchi.data.source.repository.PaymentRepository
import org.koin.dsl.module.module

val repositoryModule = module(override = true) {
    single { provideAppDatabase(get(), get()) }
    single { providePaymentDao(get()) }
    single { providePaymentRemoteDataSource() }
    single { providePaymentLocalDataSource(get()) }
    single { providePaymentRepository(get()) }
}

fun providePaymentRepository(local: PaymentLocalDataSource) =
    PaymentRepository(local)

fun providePaymentLocalDataSource(paymentDao: PaymentDao) = PaymentLocalDataSource(paymentDao)
fun providePaymentRemoteDataSource(): PaymentDataSource.Remote = PaymentRemoteDataSource()
fun providePaymentDao(appDatabase: AppDataBase): PaymentDao = appDatabase.paymentDao()
fun provideAppDatabase(context: Context, databaseName: String): AppDataBase =
    Room.databaseBuilder(context, AppDataBase::class.java, databaseName).build()