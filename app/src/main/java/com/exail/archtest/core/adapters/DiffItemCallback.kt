package com.exail.archtest.core.adapters

import androidx.recyclerview.widget.DiffUtil
import java.util.*

/**
 * Created by eduardsdenisjonoks  on 2019-05-21.
 */
class DiffItemCallback<T> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T) = oldItem == newItem

    override fun areContentsTheSame(oldItem: T, newItem: T) = Objects.equals(oldItem, newItem)

}