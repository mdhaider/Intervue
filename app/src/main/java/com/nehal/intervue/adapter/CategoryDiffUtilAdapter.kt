package com.nehal.intervue.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.nehal.intervue.adapter.viewholder.DiffUtilCategoryItemViewHolder
import com.nehal.intervue.utils.Category

class CategoryDiffUtilAdapter : ListAdapter<Category, DiffUtilCategoryItemViewHolder>(
    DIFF_UTIL_ITEM_CALLBACK
) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DiffUtilCategoryItemViewHolder = DiffUtilCategoryItemViewHolder(parent)


    override fun onBindViewHolder(holder: DiffUtilCategoryItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    companion object {
        private val DIFF_UTIL_ITEM_CALLBACK =
            object : DiffUtil.ItemCallback<Category>() {
                override fun areItemsTheSame(oldItem: Category, newItem: Category) =
                    oldItem.id == newItem.id

                override fun areContentsTheSame(oldItem: Category, newItem: Category) =
                    oldItem == newItem
            }
    }
}