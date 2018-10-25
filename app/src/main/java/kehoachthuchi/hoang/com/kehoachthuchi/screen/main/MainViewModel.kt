package kehoachthuchi.hoang.com.kehoachthuchi.screen.main

import android.arch.lifecycle.MutableLiveData
import kehoachthuchi.hoang.com.kehoachthuchi.base.BaseViewModel

class MainViewModel : BaseViewModel() {
    val title = MutableLiveData<String>()
    val isShowArrowBack = MutableLiveData<Boolean>()
    val isShowToolBar = MutableLiveData<Boolean>()
}