package com.view.base.view

import com.hannesdorfmann.mosby3.mvp.MvpView

interface BaseView : MvpView {

    fun showProgress()

    fun hideProgress()

}