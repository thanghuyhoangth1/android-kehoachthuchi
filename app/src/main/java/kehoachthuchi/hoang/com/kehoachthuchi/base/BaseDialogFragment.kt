package kehoachthuchi.hoang.com.kehoachthuchi.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseDialogFragment<ViewBinding : ViewDataBinding, ViewModel : BaseViewModel> : DialogFragment() {
    abstract val layoutResource: Int
    abstract val viewModel: ViewModel
    abstract val viewModelId: Int
    lateinit var viewBinding: ViewBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog.setTitle("Gugugu")
        viewBinding = DataBindingUtil.inflate(inflater, layoutResource, container, false)
        viewBinding.apply {
            setLifecycleOwner(this@BaseDialogFragment)
            setVariable(viewModelId, viewModel)
        }
        initComponent(savedInstanceState)
        return viewBinding.root
    }

    abstract fun initComponent(savedInstanceState: Bundle?)
}