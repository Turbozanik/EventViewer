package com.view.base.view

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.view.base.adapter.BaseProgressAdapter

abstract class OnScrolledToEndListener(private val swipeRefresh: SwipeRefreshLayout?,
                                       private val adapter: BaseProgressAdapter<*>) : RecyclerView.OnScrollListener() {

    abstract fun onScrolledToEnd()

    override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
        super.onScrollStateChanged(recyclerView, newState)
        if (newState == RecyclerView.SCROLL_STATE_IDLE
                && !adapter.hasProgressItem()
                && (swipeRefresh == null || !swipeRefresh.isRefreshing)) {
            val lm = recyclerView!!.layoutManager as LinearLayoutManager
            if (lm.findLastVisibleItemPosition() == adapter.itemCount - 1) {
                onScrolledToEnd()
            }
        }
    }

}