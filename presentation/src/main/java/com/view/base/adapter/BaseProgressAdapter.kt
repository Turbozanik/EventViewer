package com.view.base.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.view.R


abstract class BaseProgressAdapter<T> : BaseAdapter<T>() {

    protected val TYPE_PROGRESS = 0

    protected inner class ProgressHolder internal constructor(
            itemView: View) : BaseAdapter.BaseViewHolder(
            itemView) {

        override fun bind(position: Int) {}
    }

    override fun getItemViewType(position: Int): Int {
        return if (isProgressItem(position)) TYPE_PROGRESS else -1
    }

    protected fun createProgressHolder(inflater: LayoutInflater,
                                       parent: ViewGroup): ProgressHolder {
        return ProgressHolder(inflater.inflate(R.layout.item_progress, parent, false))
    }

    private fun isProgressItem(position: Int): Boolean {
        return position < itemCount && getItem(position) == null
    }

    fun hasProgressItem(): Boolean {
        return !isEmpty && isProgressItem(itemCount - 1)
    }

    fun setProgress(needShow: Boolean?, parent: RecyclerView): Boolean {
        if (needShow != true && !isEmpty && parent.visibility == View.VISIBLE) {
            val lastItemIndex = itemCount - 1
            val lastItemType = getItemViewType(lastItemIndex)
            if (needShow == null) {
                if (lastItemType != TYPE_PROGRESS) {
                    add(null)
                    notifyDataSetChanged()
                    parent.scrollToPosition(itemCount - 1)
                }
                return true
            } else if (lastItemType == TYPE_PROGRESS) {
                remove(lastItemIndex)
                notifyDataSetChanged()
                return true
            }
        }
        return false
    }

}