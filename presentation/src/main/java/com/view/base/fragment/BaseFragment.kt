package com.view.base.fragment

import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ActivityNavigator
import com.FRAGMENT_DATA_KEY
import com.dagger.DaggerController
import com.view.base.activity.BaseActivity
import com.watchers.keepers.UserKeeper

abstract class BaseFragment : Fragment() {

    @get:LayoutRes
    protected abstract val layoutId: Int

    protected val initialAction: Any?
        get() = if (arguments != null)
            arguments!!.getSerializable(FRAGMENT_DATA_KEY)
        else
            null

    protected val daggerController: DaggerController
        get() = (activity as BaseActivity).daggerController

    protected val activityNavigator: ActivityNavigator
        get() = (activity as BaseActivity).activityNavigator

    @CallSuper
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutId, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        handleInitialAction()
    }

    override fun onResume() {
        super.onResume()
        updateToolbar()
    }

    protected abstract fun initView()

    protected abstract fun updateToolbar()

    protected abstract fun handleInitialAction()

    protected fun getUserKeeper(): UserKeeper {
        return (activity as BaseActivity).userKeeper
    }

}
