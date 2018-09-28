package com.view.base.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import java.util.*

abstract class BaseAdapter<ItemType> : RecyclerView.Adapter<BaseAdapter.BaseViewHolder>() {

    private var mList: MutableList<ItemType> = ArrayList()
    private lateinit var mOnItemClickListener: OnItemClickListener

    val items: List<ItemType>
        get() = mList

    val isEmpty: Boolean
        get() = mList.isEmpty()

    interface OnItemClickListener {
        fun onClick(view: View, position: Int)
    }

    abstract class BaseViewHolder protected constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        abstract fun bind(position: Int)

        fun setListeners(position: Int, onItemClickListener: OnItemClickListener?) {
            itemView.setOnClickListener {
                onItemClickListener?.onClick(itemView, position)
            }
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(position)
        holder.setListeners(position, mOnItemClickListener)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    protected fun getItem(position: Int): ItemType {
        return mList[position]
    }

    protected fun update(list: List<ItemType>) {
        this.mList.clear()
        addAll(list)
    }

    protected fun addAll(list: List<ItemType>?) {
        if (list != null && !list.isEmpty()) {
            this.mList.addAll(list)
        }
        notifyDataSetChanged()
    }

    protected fun add(item: ItemType) {
        mList.add(item)
        notifyDataSetChanged()
    }

    protected fun add(pos: Int, item: ItemType) {
        mList.add(pos, item)
        notifyDataSetChanged()
    }

    protected fun remove(position: Int) {
        mList.removeAt(position)
        notifyDataSetChanged()
    }

    protected fun updateItem(item: ItemType, position: Int) {
        mList.removeAt(position)
        mList.add(position, item)
        notifyDataSetChanged()
    }

    protected fun clear() {
        mList.clear()
        notifyDataSetChanged()
    }

    protected fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.mOnItemClickListener = onItemClickListener
    }

}
