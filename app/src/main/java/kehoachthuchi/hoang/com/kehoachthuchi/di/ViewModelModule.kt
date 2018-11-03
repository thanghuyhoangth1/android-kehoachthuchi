package kehoachthuchi.hoang.com.kehoachthuchi.di

import kehoachthuchi.hoang.com.kehoachthuchi.screen.main.MainViewModel
import kehoachthuchi.hoang.com.kehoachthuchi.screen.newpayment.NewPaymentViewModel
import kehoachthuchi.hoang.com.kehoachthuchi.screen.paymentlog.PaymentLogViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module(override = true) {
    viewModel { PaymentLogViewModel() }
    viewModel { MainViewModel() }
    viewModel { NewPaymentViewModel() }
}