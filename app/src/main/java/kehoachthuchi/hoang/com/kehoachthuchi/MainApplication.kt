package kehoachthuchi.hoang.com.kehoachthuchi

import android.app.Application
import kehoachthuchi.hoang.com.kehoachthuchi.di.appModule
import kehoachthuchi.hoang.com.kehoachthuchi.di.viewModelModule
import org.koin.android.ext.android.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(
            this, listOf(
                viewModelModule, appModule
            )
        )
    }

}