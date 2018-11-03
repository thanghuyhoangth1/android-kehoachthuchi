package kehoachthuchi.hoang.com.kehoachthuchi.screen.newpayment

import android.os.Bundle
import kehoachthuchi.hoang.com.kehoachthuchi.BR
import kehoachthuchi.hoang.com.kehoachthuchi.R
import kehoachthuchi.hoang.com.kehoachthuchi.base.BaseDialogFragment
import kehoachthuchi.hoang.com.kehoachthuchi.databinding.FragmentAddPaymentDialogBinding
import org.koin.android.viewmodel.ext.android.viewModel

class NewPaymentFragment : BaseDialogFragment<FragmentAddPaymentDialogBinding, NewPaymentViewModel>() {
    override val layoutResource: Int = R.layout.fragment_add_payment_dialog
    override val viewModel: NewPaymentViewModel by viewModel<NewPaymentViewModel>()
    override val viewModelId: Int = BR.viewModel

    override fun initComponent(savedInstanceState: Bundle?) {
    }

}