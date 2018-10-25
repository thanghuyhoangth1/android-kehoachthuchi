package kehoachthuchi.hoang.com.kehoachthuchi.screen.paymentlog

import android.os.Bundle
import android.view.*
import android.widget.Toast
import kehoachthuchi.hoang.com.kehoachthuchi.BR
import kehoachthuchi.hoang.com.kehoachthuchi.R
import kehoachthuchi.hoang.com.kehoachthuchi.base.BaseFramgent
import kehoachthuchi.hoang.com.kehoachthuchi.databinding.FragmentPaymentLogBinding
import org.koin.android.viewmodel.ext.android.viewModel

class PaymentLogFragment() : BaseFramgent<FragmentPaymentLogBinding, PaymentLogViewModel>() {
    override val viewModelId: Int = BR.viewModel
    override val viewModel by viewModel<PaymentLogViewModel>()

    companion object {
        fun newInstance() = PaymentLogFragment()
    }

    override val layoutResource: Int = R.layout.fragment_payment_log

    override fun initComps(viewBinding: FragmentPaymentLogBinding) {
        activityViewModel.apply {
            title.value = getString(R.string.title_payment_log)
            isShowToolBar.value = true
            isShowArrowBack.value = false
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.fragment_payment_log, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        super.onOptionsItemSelected(item)
        when (item?.itemId) {
            R.id.item_add -> Toast.makeText(context, "Add roi ne", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}