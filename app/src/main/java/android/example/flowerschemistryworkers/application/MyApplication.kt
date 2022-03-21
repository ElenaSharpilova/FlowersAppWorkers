package android.example.flowerschemistryworkers.application

import android.app.Application
import android.example.flowerschemistryworkers.koin.retrofitModule
import android.example.flowerschemistryworkers.koin.viewModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(retrofitModule, viewModules))
            androidContext(this@MyApplication)
        }
    }
}