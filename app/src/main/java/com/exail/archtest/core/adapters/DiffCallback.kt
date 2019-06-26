package com.exail.archtest.core.adapters

import androidx.recyclerview.widget.DiffUtil

/**
 * Created by eduardsdenisjonoks  on 2019-05-21.
 */
class DiffCallback<T>(private var oldItems: List<T>, private var newItems: List<T>) :
    DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldItems.size

    override fun getNewListSize(): Int = newItems.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldItems[oldItemPosition] == newItems[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldItems[oldItemPosition] == newItems[newItemPosition]
}