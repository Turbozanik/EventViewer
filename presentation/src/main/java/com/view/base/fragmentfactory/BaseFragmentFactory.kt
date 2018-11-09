package com.view.base.fragmentfactory

import android.support.v4.app.Fragment


abstract class BaseFragmentFactory {

    abstract fun createFragment(screenKey: String?, data: Any?): Fragment
}