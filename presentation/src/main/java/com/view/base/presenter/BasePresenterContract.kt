package com.view.base.presenter

import com.view.base.view.BaseView


interface BasePresenterContract {
    fun attachView(view: BaseView)
}