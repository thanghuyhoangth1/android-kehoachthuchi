package kehoachthuchi.hoang.com.kehoachthuchi.screen.main

import android.arch.lifecycle.Observer
import android.os.Bundle
import kehoachthuchi.hoang.com.kehoachthuchi.base.BaseActivity
import kehoachthuchi.hoang.com.kehoachthuchi.R
import kehoachthuchi.hoang.com.kehoachthuchi.screen.paymentlog.PaymentLogFragment
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<MainViewModel>() {
    override val viewModel: MainViewModel by viewModel<MainViewModel>()
    override val layoutResource: Int = R.layout.activity_main
    override fun initComps(savedInstanceState: Bundle?) {
        replaceFragment(R.id.container, PaymentLogFragment.newInstance(), "", false)
        viewModel.apply {
            title.observe(this@MainActivity, Observer {
                setTitle(it ?: return@Observer)
            })
            isShowArrowBack.observe(this@MainActivity, Observer {
                setShowArrowBack(it == true)
            })
            isShowToolBar.observe(this@MainActivity, Observer {
                setShowToolBar(it == true)
            })
        }

    }
}
