package com.view.base.activity

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils.isEmpty
import com.ACTIVITY_ACTION_DATA_KEY
import com.ActivityAction
import com.ActivityNavigator
import com.EventViewerApp
import com.dagger.DaggerController
import com.view.base.view.HasRootScreen
import com.watchers.keepers.UserKeeper
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.SupportFragmentNavigator
import timber.log.Timber
import javax.inject.Inject


abstract class BaseActivity : AppCompatActivity(), HasRootScreen {

    private val CURRENT_FRAGMENT_KEY = "CURRENT_FRAGMENT_KEY"

    protected abstract inner class FragmentNavigator(fragmentManager: FragmentManager?,
                                                     containerId: Int)
        : SupportFragmentNavigator(fragmentManager, containerId) {

        override fun showSystemMessage(message: String?) {
            Timber.i(Throwable(message))
        }

        override fun exit() {
            finish()
        }

    }

    @Inject
    protected lateinit var mUserKeeper: UserKeeper
    val userKeeper: UserKeeper
        get() {
            return mUserKeeper
        }
    protected lateinit var mNavigator: Navigator
    protected var mCurrentFragment: Fragment? = null
    private lateinit var mActivityNavigator: ActivityNavigator
    private lateinit var mActivityInitAction: ActivityAction
    protected var mCurrentFragmentScreenKey: String? = null

    private val router: Router
        get() {
            return (application as EventViewerApp).getRouter()
        }

    private val mNavigatorHolder: NavigatorHolder
        get() {
            return EventViewerApp.getInstance().getNavigatorHolder()
        }

    val daggerController: DaggerController
        get() {
            return EventViewerApp.getInstance()
                    .getDaggerController()
        }

    val activityInitAction: ActivityAction
        get() {
            return mActivityInitAction
        }

    val activityNavigator: ActivityNavigator
        get() {
            return mActivityNavigator
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        handleDaggerDependencies()
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        readActivityInitialAction()
        initView()
        initActivityNavigator()
        initNavigator()
        showRootScreen(getRootScreenKey(activityInitAction))
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putString(CURRENT_FRAGMENT_KEY, mCurrentFragmentScreenKey)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState?.getString(CURRENT_FRAGMENT_KEY) != null
                && !isEmpty(savedInstanceState.getString(CURRENT_FRAGMENT_KEY))) {
            showFragment(savedInstanceState.getString(CURRENT_FRAGMENT_KEY), null)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        removeCurrentSubComponent()
    }

    override fun onPause() {
        super.onPause()
        removeNavigator()
    }

    override fun onResume() {
        super.onResume()
        initNavigator()
    }

    private fun setActivityNavigator(activityNavigator: ActivityNavigator) {
        mActivityNavigator = activityNavigator
    }

    @get:LayoutRes
    protected abstract val layoutId: Int

    protected abstract val navigator: Navigator

    protected abstract val fragmentContainerViewId: Int

    protected abstract fun addActivitySubComponent()

    protected abstract fun addCurrentActivitySubComponent()

    protected abstract fun getRootScreenKey(activityAction: ActivityAction?): String

    protected abstract fun removeCurrentSubComponent()

    protected abstract fun initView()

    protected abstract fun saveCurrentFragment(fragment: Fragment, screenKey: String?)

    private val currentFragment: Fragment?
        get() {
            return mCurrentFragment
        }

    private fun removeNavigator() {
        mNavigatorHolder.removeNavigator()
    }

    protected fun showFragment(screenKey: String, data: Any?) {
        router.navigateTo(screenKey, data)
    }

    private fun initNavigator() {
        mNavigatorHolder.setNavigator(navigator)
    }

    private fun initActivityNavigator() {
        setActivityNavigator(ActivityNavigator(this))
    }

    private fun readActivityInitialAction() {
        var activityAction: ActivityAction? = null
        intent.getSerializableExtra(ACTIVITY_ACTION_DATA_KEY)?.let {
            activityAction = intent.getSerializableExtra(
                    ACTIVITY_ACTION_DATA_KEY) as ActivityAction
        }
        mActivityInitAction = activityAction ?: ActivityAction.DEFAULT
    }

    private fun handleDaggerDependencies() {
        addActivitySubComponent()
        addCurrentActivitySubComponent()
    }

    protected fun getToolbarBackVisibility(): Int {
        return 0// TODO: 26.06.2018 add realisation
    }

    @StringRes
    protected fun getToolbarTitle(): Int {
        return 0// TODO: 26.06.2018 add realisation
    }

    override fun showRootScreen(screenKey: String?) {
        screenKey?.let {
            router.newRootScreen(screenKey)
        }
    }

}