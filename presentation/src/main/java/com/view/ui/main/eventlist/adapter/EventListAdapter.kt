package com.view.ui.main.eventlist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.view.R
import com.view.base.adapter.BaseAdapter
import kotlinx.android.synthetic.main.item_event_view.view.*

class EventListAdapter : BaseAdapter<EventListItem>() {

    inner class EventItemViewHolder(itemView: View) : BaseViewHolder(itemView) {
        override fun bind(position: Int) {
            itemView?.mTvTitle?.text = getItem(position).dummy.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return EventItemViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.item_event_view, parent, false))
    }

}