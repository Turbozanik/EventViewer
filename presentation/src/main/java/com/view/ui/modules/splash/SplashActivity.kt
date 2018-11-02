package com.view.ui.modules.splash


//class SplashActivity : BaseActivity() {
//
//    @Inject
//    protected lateinit var mGetUserEmailUseCase: GetUserEmailUseCase
//
//    override val layoutId: Int
//        get() = R.layout.activity_splash
//    override val navigator: Navigator
//        get() = Navigator { }
//    override val fragmentContainerViewId: Int
//        get() = R.id.root
//
//    override fun addActivitySubComponent() {
//        daggerController.addActivitySubComponent()
//    }
//
//    override fun addCurrentActivitySubComponent() {
//        daggerController.addSplashActivitySubComponent()
//    }
//
//    override fun getScreenKeyByAction(activityAction: ContentHolderInitialAction?): String {
//        return ""
//    }
//
//    override fun removeCurrentSubComponent() {
//        daggerController.removeSplashActivitySubComponent()
//    }
//
//    @SuppressLint("CheckResult")
//    override fun initView() {
//        daggerController.splashActivitySubComponent?.inject(this)
//        if (GoogleSignIn.getLastSignedInAccount(this) != null) {
//            modulesNavigator.startActivity(MAIN_ACTIVITY)
//        } else {
//            mGetUserEmailUseCase.execute().subscribe {
//                if (!isEmpty(it)) {
//                    modulesNavigator.startActivityWithInitialAction(
//                            ContentHolderInitialAction.OPEN_AUTH_WITH_SAVED_CREDENTIALS)
//                } else {
//                    modulesNavigator.startActivityWithInitialAction(
//                            ContentHolderInitialAction.OPEN_AUTH_WITH_NO_SAVED_CREDENTIALS)
//                }
//            }
//        }
//    }
//
//    override fun saveCurrentFragment(fragment: Fragment, screenKey: String?) {
//        mCurrentFragment = fragment
//    }
//
//}