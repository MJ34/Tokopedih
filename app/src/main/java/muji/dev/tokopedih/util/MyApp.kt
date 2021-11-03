package muji.dev.tokopedih.util

import android.app.Application
import com.chibatching.kotpref.Kotpref
import muji.dev.tokopedih.core.di.appModule
import muji.dev.tokopedih.core.di.repositoryModule
import muji.dev.tokopedih.core.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Kotpref.init(this)
        startKoin {
            androidContext(this@MyApp)
            modules(listOf(appModule, viewModelModule, repositoryModule))
        }
    }
}