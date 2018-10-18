package com.view.base.module

import android.app.Activity
import android.support.v4.app.Fragment
import com.EventViewerApp
import ru.terrakok.cicerone.Router


abstract class BaseModule(private val context: Activity, fragmentContainerId: Int) {

    interface OnFragmentAddedListener {
        fun onFragmentAdded(fragment: Fragment)
    }

    protected val fragmentContainerViewId: Int = fragmentContainerId

    private val router: Router
        get() {
            return EventViewerApp.getInstance().getRouter()
        }

    fun addFragment(screenKey: String, data: Any?) {
        router.navigateTo(screenKey, data)
    }

    fun goToPreviousFragment(screenKey: String?) {
        router.backTo(screenKey)
    }

}