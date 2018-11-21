package com.view.ui.godlikeroot

import com.view.base.view.BaseView


interface RootGodlikeActivityView : BaseView {

    fun showProfileFragment()

    fun goToAuthFragment()

    fun goToEventListFragment()

    fun goToConferenceFragment()

    fun goBack()

}