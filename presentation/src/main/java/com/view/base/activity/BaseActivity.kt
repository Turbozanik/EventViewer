package com.view.base.activity

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.FragmentManager
import com.ACTIVITY_ACTION_DATA_KEY
import com.EventViewerApp
import com.InitialAction
import com.ModulesNavigator
import com.dagger.DaggerController
import com.view.base.fragment.BaseFragment
import com.view.base.view.HasRootScreen
import com.watchers.keepers.UserKeeper
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.SupportFragmentNavigator
import timber.log.Timber
import javax.inject.Inject


abstract class BaseActivity : com.view.base.activity.MvpActivity(), HasRootScreen {

    private val CURRENT_FRAGMENT_ID_KEY = "CURRENT_FRAGMENT_ID_KEY"

    protected abstract inner class FragmentNavigator(fragmentManager: FragmentManager?,
                                                     containerId: Int)
        : SupportFragmentNavigator(fragmentManager, containerId) {

        override fun showSystemMessage(message: String?) {
            Timber.i(Throwable(message))
        }

        override fun exit() {
            moveTaskToBack(true)
        }

    }

    @Inject
    protected lateinit var mUserKeeper: UserKeeper
    val userKeeper: UserKeeper
        get() {
            return mUserKeeper
        }

    private lateinit var mModulesNavigator: ModulesNavigator
    private lateinit var mInitialInitAction: InitialAction

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

    val initialAction: InitialAction
        get() {
            return mInitialInitAction
        }

    val modulesNavigator: ModulesNavigator
        get() {
            return mModulesNavigator
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        handleDaggerDependencies()
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        initView()
        readActivityInitialAction()
        if (savedInstanceState?.get(CURRENT_FRAGMENT_ID_KEY) == null) {
            handleInitialAction(initialAction)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(CURRENT_FRAGMENT_ID_KEY, currentFragment?.id ?: -1)
    }

    override fun onResume() {
        super.onResume()
        initNavigator()

    }

    override fun onPause() {
        removeNavigator()
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        removeCurrentSubComponent()
    }

    @get:LayoutRes
    protected abstract val layoutId: Int

    protected abstract val navigator: Navigator

    protected abstract val fragmentContainerViewId: Int

    protected abstract fun addActivitySubComponent()

    protected abstract fun addCurrentActivitySubComponent()

    protected abstract fun getScreenKeyByAction(initialAction: InitialAction?): String

    protected abstract fun removeCurrentSubComponent()

    protected abstract fun initView()

    protected abstract fun getDefaultInitialAction(): InitialAction

    protected val currentFragment: BaseFragment?
        get() = supportFragmentManager.findFragmentById(fragmentContainerViewId) as? BaseFragment

    private fun removeNavigator() {
        mNavigatorHolder.removeNavigator()
    }

    protected fun addFragment(screenKey: String, data: Any?) {
        router.navigateTo(screenKey, data)
    }

    protected fun goToPreviousFragment(screenKey: String?) {
        router.backTo(screenKey)
    }

    protected fun goToPreviousFragment() {
        router.exit()
    }

    protected fun createNewChain(screenKey: String?, data: Any?) {
        router.newScreenChain(screenKey, data)
    }

    private fun initNavigator() {
        mNavigatorHolder.setNavigator(navigator)
    }

    private fun readActivityInitialAction() {
        var initialAction: InitialAction? = null
        if (intent.hasExtra(ACTIVITY_ACTION_DATA_KEY)) {
            initialAction = intent.getSerializableExtra(
                    ACTIVITY_ACTION_DATA_KEY) as InitialAction
        }
        mInitialInitAction = initialAction ?: getDefaultInitialAction()
    }

    private fun handleDaggerDependencies() {
        addActivitySubComponent()
        addCurrentActivitySubComponent()
    }

    protected open fun handleInitialAction(initialAction: InitialAction) {
        showRootScreen(getScreenKeyByAction(initialAction), null)
    }

    override fun showRootScreen(screenKey: String?, bundle: Bundle?) {
        screenKey?.let {
            router.newRootScreen(screenKey, bundle)
        }
    }

}