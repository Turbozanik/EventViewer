package com.dagger

import android.content.Context
import com.dagger.component.*
import com.dagger.module.*


open class DaggerController(eventViewerApp: Context) {

    private var mActivitySubComponent: ActivitySubComponent? = null
    private var mAuthActivitySubComponent: AuthActivitySubComponent? = null
    private var mMainActivitySubComponent: MainActivitySubComponent? = null
    private var mRegistrationFragmentSubComponent: RegistrationFragmentSubComponent? = null
    private var mLoginSubComponent: LoginFragmentSubComponent? = null
    private var mEventListFragmentSubComponent: EventListFragmentSubComponent? = null
    private var mEventDetailsSubComponent: EventDetailsFragmentSubComponent? = null
    //private var mSplashActivitySubComponent: SplashActivitySubComponent? = null
    private var mUserProfileActivitySubComponent: UserProfileActvitySubCopmonent? = null
    private var mUserProfileFragmentModule: UserProfileFragmentSubComponent? = null

    private val mAppComponent: AppComponent = DaggerAppComponent.builder()
            .appModule(AppModule(eventViewerApp))
            .build()

    val appComponent: AppComponent
        get() {
            return mAppComponent
        }

    //Activity module
    fun addActivitySubComponent() {
        mActivitySubComponent = mActivitySubComponent ?: mAppComponent.add(ActivityModule())
    }

    fun removeActivitySubComponent() {
        mActivitySubComponent?.let { mActivitySubComponent = null }
    }

    val activitySubComponent: ActivitySubComponent?
        get() {
            return mActivitySubComponent
        }

    //SplashActivity
//    fun addSplashActivitySubComponent() {
//        mSplashActivitySubComponent = mActivitySubComponent?.add(SplashActivityModule())
//    }
//
//    fun removeSplashActivitySubComponent() {
//        mSplashActivitySubComponent?.let { mSplashActivitySubComponent = null }
//    }
//
//    val splashActivitySubComponent: SplashActivitySubComponent?
//        get() {
//            return mSplashActivitySubComponent
//        }

    //RootGodlikeActivity module
    fun addMainActivitySubComponent() {
        mMainActivitySubComponent = mActivitySubComponent?.add(MainActivityModule())
    }

    fun removeMainActivitySubComponent() {
        mMainActivitySubComponent?.let { mMainActivitySubComponent = null }
    }

    val mainActivitySubComponent: MainActivitySubComponent?
        get() {
            return mMainActivitySubComponent
        }

    //AuthActivityModule
    fun addAuthActivitySubComponent() {
        mAuthActivitySubComponent = mActivitySubComponent?.add(AuthActivityModule())
    }

    fun removeAuthActivitySubComponent() {
        mAuthActivitySubComponent?.let { mAuthActivitySubComponent = null }
    }

    val authActivitySubComponent: AuthActivitySubComponent?
        get() {
            return mAuthActivitySubComponent
        }

    //RegistrationFragment
    fun addRegistrationFragmentSubComponent() {
        mRegistrationFragmentSubComponent = mAuthActivitySubComponent?.add(
                RegistrationFragmentModule())
    }

    fun removeRegistrationFragmentSubComponent() {
        mRegistrationFragmentSubComponent?.let { mRegistrationFragmentSubComponent = null }
    }

    val registrationFragmentSubComponent: RegistrationFragmentSubComponent?
        get() {
            return mRegistrationFragmentSubComponent
        }

    //LoginFragment
    fun addLoginFragmentSubComponent() {
        mLoginSubComponent = mAuthActivitySubComponent?.add(LoginFragmentModule())
    }

    fun removeLoginFragmentSubComponent() {
        mLoginSubComponent?.let { mLoginSubComponent = null }
    }

    val loginFragmentSubComponent: LoginFragmentSubComponent?
        get() {
            return mLoginSubComponent
        }

    //EventList
    fun addEventListFragmentSubComponent() {
        mEventListFragmentSubComponent = mMainActivitySubComponent?.add(EventListFragmentModule())
    }

    fun removeEventListFragmentSubComponent() {
        mEventListFragmentSubComponent?.let { mEventListFragmentSubComponent = null }
    }

    val eventListFragmentSubComponent: EventListFragmentSubComponent?
        get() {
            return mEventListFragmentSubComponent
        }

    //EventDetails
    fun addEventDetailsFragmentSubComponent() {
        mEventDetailsSubComponent = mMainActivitySubComponent?.add(EventDetailsFragmentModule())
    }

    fun removeEventDetailsFragmentSubComponent() {
        mEventDetailsSubComponent?.let { mEventDetailsSubComponent = null }
    }

    val eventDetailsFragmentSubComponent: EventDetailsFragmentSubComponent?
        get() {
            return mEventDetailsSubComponent
        }

    //UserProfileActivity
    fun addUserProfileActivitySubComponent() {
        mUserProfileActivitySubComponent = mActivitySubComponent?.add(UserProfileActivityModle())
    }

    fun removeUserProfileActivitySubComponent() {
        mUserProfileActivitySubComponent?.let { mUserProfileActivitySubComponent = null }
    }

    val userProfileActvitySubCopmonent: UserProfileActvitySubCopmonent?
        get() {
            return mUserProfileActivitySubComponent
        }

    //UserProfileFragment
    fun addUserProfileFragmentSubComponent() {
        mUserProfileFragmentModule = mUserProfileActivitySubComponent?.add(
                UserProfileFragmentModule())
    }

    fun removeUserProfileFragmentSubComponent() {
        mUserProfileFragmentModule?.let { mEventDetailsSubComponent = null }
    }

    val userProfileFragmentSubComponent: UserProfileFragmentSubComponent?
        get() {
            return mUserProfileFragmentModule
        }

}