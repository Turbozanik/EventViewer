package com.view.ui.modules.content.eventlist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.domain.models.EventDto
import com.view.R
import com.view.base.adapter.BaseAdapter
import com.view.base.adapter.BaseProgressAdapter
import kotlinx.android.synthetic.main.item_event_list_date_header.view.*
import kotlinx.android.synthetic.main.item_event_view.view.*


class EventListAdapter : BaseProgressAdapter<EventListAdapter.Config?>() {

    private val TYPE_ITEM = 1
    private val TYPE_DATE_HEADER = 2

    inner class Config {
        var mEvent: EventDto? = null
        var mDate: String = ""

        private constructor(title: String) {
            mDate = title
        }

        private constructor(event: EventDto) {
            mEvent = event
        }
    }

    inner class EventItemViewHolder(itemView: View) : BaseAdapter.BaseViewHolder(itemView) {
        override fun bind(position: Int) {
            itemView?.mTvTitle?.text = getItem(position)?.mEvent?.mTitle
        }
    }

    inner class DateHeaderViewHolder(itemView: View) : BaseAdapter.BaseViewHolder(itemView) {
        override fun bind(position: Int) {
            itemView?.mTvDate?.text = getItem(position)?.mDate
        }

    }

    override fun getItemViewType(position: Int): Int {
        val config = getItem(position)
        return when {
            config == null -> TYPE_PROGRESS
            config.mEvent != null -> TYPE_ITEM
            else -> TYPE_DATE_HEADER
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseAdapter.BaseViewHolder {
        return when (viewType) {
            TYPE_ITEM -> EventItemViewHolder(LayoutInflater.from(parent.context)
                                                     .inflate(R.layout.item_event_view,
                                                              parent, false))
            TYPE_PROGRESS -> ProgressHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.item_progress, parent,
                                                                false))
            TYPE_DATE_HEADER -> DateHeaderViewHolder(LayoutInflater.from(parent.context).inflate(
                    R.layout.item_event_list_date_header, parent, false))
            else -> {
                throw IllegalArgumentException("Hz")
            }
        }
    }

}