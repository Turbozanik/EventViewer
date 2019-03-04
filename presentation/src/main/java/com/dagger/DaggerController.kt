package com.dagger

import android.content.Context
import com.dagger.component.*
import com.dagger.module.*


open class DaggerController(eventViewerApp: Context) {

    private var mActivitySubComponent: ActivitySubComponent? = null
    private var mRootGodlikeActivitySubComponent: RootGodlikeActivitySubComponent? = null
    private var mRegistrationFragmentSubComponent: RegistrationFragmentSubComponent? = null
    private var mLoginSubComponent: LoginFragmentSubComponent? = null
    private var mEventListFragmentSubComponent: EventListFragmentSubComponent? = null
    private var mEventDetailsSubComponent: EventDetailsFragmentSubComponent? = null
    private var mUserProfileFragmentSubComponent: UserProfileFragmentSubComponent? = null
    private var mOrganizationDetailsSubComponent: OrganizationFragmentDetailsSubComponent? = null
    private var mOrganizationFragmentListSubComponent: OrganizationListFragmentSubComponent? = null

    private val mAppComponent: AppComponent? = DaggerAppComponent.builder()
            .appModule(AppModule(eventViewerApp))
            .build()

    private val appComponent: AppComponent?
        get() {
            return mAppComponent
        }

    //Activity module
    fun addActivitySubComponent() {
        mActivitySubComponent = appComponent?.add(ActivityModule())
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
        mUserProfileFragmentSubComponent = mRootGodlikeActivitySubComponent?.add(
                UserProfileFragmentModule())
    }

    fun removeUserProfileFragmentSubComponent() {
        mUserProfileFragmentSubComponent?.let { mUserProfileFragmentSubComponent = null }
    }

    val userProfileFragmentSubComponent: UserProfileFragmentSubComponent?
        get() {
            return mUserProfileFragmentSubComponent
        }

    //OrganizationDetails
    fun addOrganizationDetailsFragmentSubComponent() {
        mOrganizationDetailsSubComponent = mRootGodlikeActivitySubComponent?.add(
                OrganizationFragmentDetailsModule())
    }

    fun removeOrganizationDetailsFragmentSubComponent() {
        mOrganizationDetailsSubComponent?.let { mOrganizationDetailsSubComponent = null }
    }

    val organizationDetailsFragmentSubComponent: OrganizationFragmentDetailsSubComponent?
        get() {
            return mOrganizationDetailsSubComponent
        }

    //OrganizationList
    fun addOrganizationListFragmentSubComponent() {
        mOrganizationFragmentListSubComponent = mRootGodlikeActivitySubComponent?.add(
                OrganizationListFragmentModule())
    }

    fun removeOrganizationListFragmentSubComponent() {
        mOrganizationFragmentListSubComponent?.let { mOrganizationFragmentListSubComponent = null }
    }

    val organizationListFragmentSubComponent: OrganizationListFragmentSubComponent?
        get() {
            return mOrganizationFragmentListSubComponent
        }

}