package com

import android.app.Application
import com.crashlytics.android.Crashlytics
import com.dagger.DaggerController
import com.data.BuildConfig
import io.fabric.sdk.android.Fabric
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import timber.log.Timber


class EventViewerApp : Application() {

    companion object {
        private lateinit var sInstance: EventViewerApp
        fun getInstance(): EventViewerApp {
            return sInstance
        }
    }

    private lateinit var mDaggerController: DaggerController
    private lateinit var mCicerone: Cicerone<Router>

    override fun onCreate() {
        super.onCreate()
        sInstance = this
        mDaggerController = DaggerController(this)
        initCicerone()
        initTimber()
        initCrashlytisc()
    }

    fun getNavigatorHolder(): NavigatorHolder {
        return mCicerone.navigatorHolder
    }

    fun getRouter(): Router {
        return mCicerone.router
    }


    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun initCicerone() {
        mCicerone = Cicerone.create()
    }

    private fun initCrashlytisc() {
        Fabric.with(this, Crashlytics())
    }

    fun getDaggerController(): DaggerController {
        return mDaggerController
    }

}