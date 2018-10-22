package com.view.base.module

import android.support.v4.app.Fragment
import com.InitialAction


abstract class BaseFragmentHolder() {

    abstract fun createFragment(screenKey: String?, data: Any?,
                                initialInitialAction: InitialAction): Fragment
}