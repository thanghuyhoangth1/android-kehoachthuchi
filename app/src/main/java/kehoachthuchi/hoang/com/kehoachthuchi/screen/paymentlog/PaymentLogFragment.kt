package kehoachthuchi.hoang.com.kehoachthuchi.screen.paymentlog

import android.support.v4.app.FragmentTransaction
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import kehoachthuchi.hoang.com.kehoachthuchi.BR
import kehoachthuchi.hoang.com.kehoachthuchi.R
import kehoachthuchi.hoang.com.kehoachthuchi.base.BaseFramgent
import kehoachthuchi.hoang.com.kehoachthuchi.databinding.FragmentPaymentLogBinding
import kehoachthuchi.hoang.com.kehoachthuchi.screen.main.MainActivity
import kehoachthuchi.hoang.com.kehoachthuchi.screen.newpayment.NewPaymentFragment
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
        val fe: FragmentTransaction? = fragmentManager?.beginTransaction()
        when (item?.itemId) {
            R.id.item_add -> NewPaymentFragment().show((activity as MainActivity).supportFragmentManager, "hihi")
        }
        return super.onOptionsItemSelected(item)
    }
}