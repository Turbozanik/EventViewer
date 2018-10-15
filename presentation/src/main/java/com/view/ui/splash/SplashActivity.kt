package com.view.ui.splash

import android.annotation.SuppressLint
import android.support.v4.app.Fragment
import android.text.TextUtils.isEmpty
import com.ActivityAction
import com.MAIN_ACTIVITY
import com.domain.usecase.prefs.user.GetUserEmailUseCase
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.view.R
import com.view.base.activity.BaseActivity
import ru.terrakok.cicerone.Navigator
import javax.inject.Inject


class SplashActivity : BaseActivity() {

    @Inject
    protected lateinit var mGetUserEmailUseCase: GetUserEmailUseCase

    override val layoutId: Int
        get() = R.layout.activity_splash
    override val navigator: Navigator
        get() = Navigator { }
    override val fragmentContainerViewId: Int
        get() = R.id.root

    override fun addActivitySubComponent() {
        daggerController.addActivitySubComponent()
    }

    override fun addCurrentActivitySubComponent() {
        daggerController.addSplashActivitySubComponent()
    }

    override fun getScreenKeyByAction(activityAction: ActivityAction?): String {
        return ""
    }

    override fun removeCurrentSubComponent() {
        daggerController.removeSplashActivitySubComponent()
    }

    @SuppressLint("CheckResult")
    override fun initView() {
        daggerController.splashActivitySubComponent?.inject(this)
        if (GoogleSignIn.getLastSignedInAccount(this) != null) {
            activityNavigator.startActivity(MAIN_ACTIVITY)
        } else {
            mGetUserEmailUseCase.execute().subscribe {
                if (!isEmpty(it)) {
                    activityNavigator.startActivityWithInitialAction(
                            ActivityAction.OPEN_AUTH_ACTIVITY_WITH_SAVED_CREDENTIALS)
                } else {
                    activityNavigator.startActivityWithInitialAction(
                            ActivityAction.OPEN_AUTH_ACTIVITY_WITH_NO_SAVED_CREDENTIALS)
                }
            }
        }
    }

    override fun saveCurrentFragment(fragment: Fragment, screenKey: String?) {
        mCurrentFragment = fragment
    }

}