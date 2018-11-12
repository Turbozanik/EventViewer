package com.dagger

import android.content.Context
import com.dagger.component.*
import com.dagger.module.*


open class DaggerController(eventViewerApp: Context) {

    private var mActivitySubComponent: ActivitySubComponent? = null
    //private var mAuthActivitySubComponent: AuthActivitySubComponent? = null
    private var mRootGodlikeActivitySubComponent: RootGodlikeActivitySubComponent? = null
    private var mRegistrationFragmentSubComponent: RegistrationFragmentSubComponent? = null
    private var mLoginSubComponent: LoginFragmentSubComponent? = null
    private var mEventListFragmentSubComponent: EventListFragmentSubComponent? = null
    private var mEventDetailsSubComponent: EventDetailsFragmentSubComponent? = null
    //private var mSplashActivitySubComponent: SplashActivitySubComponent? = null
    //private var mUserProfileActivitySubComponent: UserProfileActvitySubCopmonent? = null
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

    //RootGodlikeActivity module
    fun addRootActivitySubComponent() {
        mRootGodlikeActivitySubComponent = mActivitySubComponent?.add(RootGodlikeActivityModule())
    }

    fun removeRootActivitySubComponent() {
        mRootGodlikeActivitySubComponent?.let { mRootGodlikeActivitySubComponent = null }
    }

    val rootGodlikeActivitySubComponent: RootGodlikeActivitySubComponent?
        get() {
            return mRootGodlikeActivitySubComponent
        }

    //RegistrationFragment
    fun addRegistrationFragmentSubComponent() {
        mRegistrationFragmentSubComponent = mRootGodlikeActivitySubComponent?.add(
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
        mLoginSubComponent = mRootGodlikeActivitySubComponent?.add(LoginFragmentModule())
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
        mEventListFragmentSubComponent = mRootGodlikeActivitySubComponent?.add(
                EventListFragmentModule())
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
        mEventDetailsSubComponent = mRootGodlikeActivitySubComponent?.add(
                EventDetailsFragmentModule())
    }

    fun removeEventDetailsFragmentSubComponent() {
        mEventDetailsSubComponent?.let { mEventDetailsSubComponent = null }
    }

    val eventDetailsFragmentSubComponent: EventDetailsFragmentSubComponent?
        get() {
            return mEventDetailsSubComponent
        }

    //UserProfileFragment
    fun addUserProfileFragmentSubComponent() {
        mUserProfileFragmentModule = mRootGodlikeActivitySubComponent?.add(
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