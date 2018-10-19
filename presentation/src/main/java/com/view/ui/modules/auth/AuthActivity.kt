package com.view.ui.modules.auth

//class AuthActivity : BaseActivity(), HasProgress {
//
//    override fun saveCurrentFragment(fragment: Fragment) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override val layoutId: Int
//        get() = R.layout.activity_auth
//
//    override fun initView() {
//        setSupportActionBar(mToolbar)
//    }
//
//    override val fragmentContainerViewId: Int
//        get() = R.id.mAuthFragmentContainer
//
//    override fun addActivitySubComponent() {
//        daggerController.addActivitySubComponent()
//    }
//
//    override fun addCurrentActivitySubComponent() {
//        daggerController.addAuthActivitySubComponent()
//    }
//
//    override fun removeCurrentSubComponent() {
//        daggerController.removeAuthActivitySubComponent()
//    }
//
//    override fun getScreenKeyByAction(activityAction: InitialAction?): String {
//        return when (activityAction) {
//            InitialAction.OPEN_AUTH_WITH_NO_SAVED_CREDENTIALS -> {
//                LOGIN_SCREEN
//            }
//            else -> {
//                LOGIN_SCREEN
//            }
//        }
//    }
//
//    override fun showProgress() {
//        progressView.visibility = View.VISIBLE
//    }
//
//    override fun hideProgress() {
//        progressView.visibility = View.GONE
//    }
//
//    override val progressView: View
//        get() {
//            return mProgressBar
//        }
//
//    fun showRegistrationFragment(data: Any?) {
//        addFragment(REGISTRATION_SCREEN, data)
//    }
//
//    fun goToMainActivityEventListFragment() {
//        modulesNavigator.startActivityWithInitialAction(
//                InitialAction.OPEN_MAIN_WITH_EVENT_LIST_FRAGMENT)
//    }
//
//    fun prepareRegistrationToolbar() {
//        mToolbar?.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)
//        mToolbar?.navigationContentDescription = BACK_CONTENT_DESCRIPTOR
//        mToolbar?.title = getString(R.string.registration)
//        mToolbar?.setNavigationOnClickListener {
//            mToolbar?.navigationIcon = null
//            goToPreviousFragment(LOGIN_SCREEN)
//        }
//    }
//
//    fun prepareLoginToolbar() {
//        mToolbar?.navigationIcon = null
//        mToolbar?.title = getString(R.string.login)
//    }
//
//}
