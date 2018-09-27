package com.view.base.fragment

open class BaseState<ActionType> {
    var mInitialAction: ActionType? = null
    var actionList: MutableList<ActionType> = ArrayList()
}