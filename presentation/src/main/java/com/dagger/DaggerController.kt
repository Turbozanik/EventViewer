package com.dagger

import android.content.Context
import com.dagger.component.*
import com.dagger.module.ActivityModule
import com.dagger.module.AppModule
import com.dagger.module.MainActivityModule
import com.dagger.module.RegistrationFragmentModule


open class DaggerController(eventViewerApp: Context) {

    private var mActivitySubComponent: ActivitySubComponent? = null
    private var mMainActivitySubComponent: MainActivitySubComponent? = null
    private var mRegistrationActivitySubComponent: RegistrationFragmentSubComponent? = null

    private val mAppComponent: AppComponent = DaggerAppComponent.builder()
            .appModule(AppModule(eventViewerApp))
            .build()

    val appComponent: AppComponent
        get() {
            return mAppComponent
        }

    //Activity module
    fun addActivitySubComponent() {
        mActivitySubComponent = mActivitySubComponent ?: mAppComponent.add(ActivityModule())
    }

    fun removeActivitySubComponent() {
        mActivitySubComponent?.let { mActivitySubComponent = null }
    }

    fun getActivitySubComponent(): ActivitySubComponent? {
        return mActivitySubComponent
    }

    //MainActivity module
    fun addMainActivitySubComponent() {
        mMainActivitySubComponent = mActivitySubComponent?.add(MainActivityModule())
    }

    fun removeMainActivitySubComponent() {
        mMainActivitySubComponent?.let { mMainActivitySubComponent = null }
    }

    fun getMainActivitySubComponent(): MainActivitySubComponent? {
        return mMainActivitySubComponent
    }

    //RegistrationFragment
    fun addRegistrationFragmentSubComponent() {
        mRegistrationActivitySubComponent = mMainActivitySubComponent?.add(
                RegistrationFragmentModule())
    }

    fun removeRegistrationFragmentSubComponent() {
        mRegistrationActivitySubComponent?.let { mRegistrationActivitySubComponent = null }
    }

    fun getRegistrationFragmentSubComponent(): RegistrationFragmentSubComponent? {
        return mRegistrationActivitySubComponent
    }

}