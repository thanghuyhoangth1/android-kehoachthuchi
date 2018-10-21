package kehoachthuchi.hoang.com.kehoachthuchi.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity<ViewModel : BaseViewModel> : AppCompatActivity() {
    abstract val layoutResource: Int
    abstract val viewModel: ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResource)
        initComps(savedInstanceState);
    }

    abstract fun initComps(savedInstanceState: Bundle?)
    fun addFragment(container: Int, fragment: Fragment, tag: String, isAddBackStack: Boolean) {
        (supportFragmentManager.beginTransaction()).apply {
            add(container, fragment)
            if (isAddBackStack) addToBackStack(tag)
        }.commit()
    }

    fun replaceFragment(container: Int, fragment: Fragment, tag: String, isAddBackStack: Boolean) {
        (supportFragmentManager.beginTransaction()).apply {
            replace(container, fragment)
            if (isAddBackStack)
                addToBackStack(tag)
        }.commit()
    }

    fun setShowToolBar(isShowToolbar: Boolean) {
        if (isShowToolbar) actionBar?.show() else actionBar?.hide()
    }

    fun setShowArrowBack(isShowArrowBack: Boolean) {
        actionBar?.apply {
            setDisplayShowHomeEnabled(isShowArrowBack)
            setDisplayHomeAsUpEnabled(isShowArrowBack)
        }
    }

    fun setActionBarTitle(title: String) {
        actionBar?.title = title
    }
}