package com.view.base.view

import com.arellomobile.mvp.MvpView

interface BaseView : MvpView {

    fun showProgress()

    fun hideProgress()

}