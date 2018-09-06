package com.view.ui

import android.support.v4.app.Fragment
import com.ActivityAction
import com.EventViewerApp
import com.view.R
import com.view.base.activity.BaseActivity
import com.view.ui.register.RegistrationFragment
import com.view.ui.register.configurator.RegistrationFragmentAction
import ru.terrakok.cicerone.Navigator

class MainActivity : BaseActivity() {

    override fun addActivitySubComponent() {
        EventViewerApp.getInstance().getDaggerController().addActivitySubComponent()
    }

    override fun addCurrentActivitySubComponent() {
        EventViewerApp.getInstance().getDaggerController().addMainActivitySubComponent()
    }

    override fun getRootScreenKey(activityAction: ActivityAction?): String {
        return when (activityAction) {
            ActivityAction.INITIAL_ACTION_DEFAULT -> {
                MainActivityScreens.REGISTRATION_SCREEN
            }
            else -> {
                MainActivityScreens.REGISTRATION_SCREEN
            }
        }
    }

    override fun removeCurrentSubComponent() {
        EventViewerApp.getInstance().getDaggerController().removeActivitySubComponent()
    }

    override val layoutId: Int
        get() = R.layout.activity_main

    override val fragmentContainerViewId: Int
        get() = R.id.mFragmentContainer

    override val navigator: Navigator
        get() {
            mNavigator = object : FragmentNavigator(supportFragmentManager,
                                                    fragmentContainerViewId) {
                override fun createFragment(screenKey: String?, data: Any?): Fragment {
                    when (screenKey) {
                        MainActivityScreens.REGISTRATION_SCREEN -> {
                            val fragment = RegistrationFragment.createNewInstance()
                            if (activityInitAction === ActivityAction.INITIAL_ACTION_DEFAULT) {
                                RegistrationFragment.addInitialAction(fragment,
                                                                      RegistrationFragmentAction.INITIAL_ACTION_DEFAULT)
                            }
                            return fragment
                        }
                        else -> {
                            throw IllegalArgumentException(Throwable("Unknown screen"))
                        }
                    }
                }
            }
            return mNavigator
        }

}