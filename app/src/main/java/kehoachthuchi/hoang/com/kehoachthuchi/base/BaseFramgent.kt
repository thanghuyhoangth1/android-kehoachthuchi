package kehoachthuchi.hoang.com.kehoachthuchi.base

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import kehoachthuchi.hoang.com.kehoachthuchi.screen.main.MainActivity
import kehoachthuchi.hoang.com.kehoachthuchi.screen.main.MainViewModel

abstract class BaseFramgent<ViewBinding : ViewDataBinding, ViewModel : BaseViewModel> : Fragment() {
    abstract val layoutResource: Int
    lateinit var viewBinding: ViewBinding
    abstract val viewModelId: Int
    abstract val viewModel: ViewModel
    lateinit var activityViewModel: MainViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = DataBindingUtil.inflate(inflater, layoutResource, container, false)
        viewBinding.setLifecycleOwner(this)
        lifecycle.addObserver(viewModel)
        viewBinding.setVariable(viewModelId, viewModel)
        setHasOptionsMenu(true)
        initComps(viewBinding)
        return viewBinding.root
    }

    abstract fun initComps(viewBinding: ViewBinding)
    fun addFragment(container: Int, fragment: Fragment, tag: String, isAddBackstack: Boolean) {
        (fragmentManager?.beginTransaction())?.apply {
            add(container, fragment)
            if (isAddBackstack) addToBackStack(tag)
        }?.commit()
    }

    fun replaceFramgnet(container: Int, fragment: Fragment, tag: String, isAddBackstack: Boolean) {
        (fragmentManager?.beginTransaction())?.apply {
            replace(container, fragment)
            if (isAddBackstack) addToBackStack(tag)
        }?.commit()
    }

    fun addChildFragment(container: Int, fragment: Fragment, tag: String, isAddBackstack: Boolean) {
        (childFragmentManager.beginTransaction()).apply {
            add(container, fragment)
            if (isAddBackstack) addToBackStack(tag)
        }.commit()
    }

    fun replaceChildFragment(container: Int, fragment: Fragment, tag: String, isAddBackstack: Boolean) {
        (childFragmentManager.beginTransaction()).apply {
            replace(container, fragment)
            if (isAddBackstack) addToBackStack(tag)
        }.commit()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (activity is MainActivity)
            (activity as MainActivity).apply {
                activityViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
            }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> fragmentManager?.popBackStack()
        }
        return super.onOptionsItemSelected(item)

    }
}