package kehoachthuchi.hoang.com.kehoachthuchi.screen.paymentlog

import android.arch.lifecycle.MutableLiveData
import kehoachthuchi.hoang.com.kehoachthuchi.base.BaseViewModel
import kehoachthuchi.hoang.com.kehoachthuchi.data.model.Payment

class PaymentLogViewModel : BaseViewModel() {
    val isLoading = MutableLiveData<Boolean>()
    val listPayment = MutableLiveData<List<Payment>>()

}