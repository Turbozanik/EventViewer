package com.view.base.module

import android.support.v4.app.Fragment


abstract class BaseFragmentHolder {

    abstract fun createFragment(screenKey: String?, data: Any?): Fragment
}