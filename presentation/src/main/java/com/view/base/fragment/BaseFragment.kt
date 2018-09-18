package com.view.base.fragment

import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ActivityNavigator
import com.Constants
import com.dagger.DaggerController
import com.view.base.activity.BaseActivity
import com.watchers.keepers.UserKeeper

abstract class BaseFragment : Fragment() {

	@get:LayoutRes
	protected abstract val layoutId: Int

	protected val initialAction: Any?
		get() = if (arguments != null)
			arguments!!.getSerializable(Constants.FRAGMENT_DATA_KEY)
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
	}

	protected abstract fun initView()

	protected fun getUserKeeper(): UserKeeper {
		return (activity as BaseActivity).userKeeper
	}

}
