package com.view.base.fragment.presenter

import com.view.base.view.BaseView


interface BasePresenterContract {
    fun attachView(view: BaseView)
}