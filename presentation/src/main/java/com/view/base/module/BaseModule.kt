package com.view.base.module

import android.app.Activity
import android.support.v4.app.Fragment
import com.InitialAction


abstract class BaseModule(private val context: Activity, fragmentContainerId: Int) {

    abstract fun createFragment(screenKey: String?, data: Any?,
                                initialInitialAction: InitialAction): Fragment
}