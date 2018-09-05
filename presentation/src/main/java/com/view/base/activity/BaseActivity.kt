package com.view.base.activity

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.ActivityAction
import com.ActivityNavigator
import com.Constants
import com.EventViewerApp
import com.dagger.DaggerController
import com.view.base.HasRootScreen
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.SupportFragmentNavigator
import timber.log.Timber


abstract class BaseActivity : AppCompatActivity(), HasRootScreen {

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

    protected lateinit var mNavigator: Navigator
    private lateinit var mActivityNavigator: ActivityNavigator
    private lateinit var mActivityInitAction: ActivityAction

    override fun onCreate(savedInstanceState: Bundle?) {
        handleDaggerDependencies()
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        readActivityInitialAction()
        initActivityNavigator()
        initNavigator()
        showRootScreen(getRootScreenKey(getActivityInitAction()))
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

    fun getDaggerController(): DaggerController {
        return EventViewerApp.getInstance()
                .getDaggerController()
    }

    fun getActivityInitAction(): ActivityAction {
        return mActivityInitAction
    }

    fun getActivityNavigator(): ActivityNavigator {
        return mActivityNavigator
    }

    private fun setActivityNavigator(activityNavigator: ActivityNavigator) {
        mActivityNavigator = activityNavigator
    }

    @get:LayoutRes
    protected abstract val layoutId: Int

    protected abstract fun getNavigator(): Navigator

    protected abstract val fragmentContainerViewId: Int

    protected abstract fun addActivitySubComponent()

    protected abstract fun addCurrentActivitySubComponent()

    protected abstract fun getRootScreenKey(activityAction: ActivityAction?): String

    protected abstract fun removeCurrentSubComponent()


    private fun getRouter(): Router {
        return (application as EventViewerApp).getRouter()
    }

    private fun getNavigatorHolder(): NavigatorHolder {
        return EventViewerApp.getInstance().getNavigatorHolder()
    }

    protected fun removeNavigator() {
        getNavigatorHolder().removeNavigator()
    }

    protected fun showFragment(screenKey: String, data: Any?) {
        getRouter().navigateTo(screenKey, data)
    }

    protected fun initNavigator() {
        getNavigatorHolder().setNavigator(getNavigator())
    }

    private fun initActivityNavigator() {
        setActivityNavigator(ActivityNavigator(this))
    }

    private fun readActivityInitialAction() {
        var activityAction: ActivityAction? = null
        intent.getSerializableExtra(Constants.ACTIVITY_ACTION_DATA_KEY)?.let {
            activityAction = intent.getSerializableExtra(
                    Constants.ACTIVITY_ACTION_DATA_KEY) as ActivityAction
        }
        mActivityInitAction = activityAction ?: ActivityAction.INITIAL_ACTION_DEFAULT
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
        screenKey?.let { getRouter().newRootScreen(screenKey) }
    }

}