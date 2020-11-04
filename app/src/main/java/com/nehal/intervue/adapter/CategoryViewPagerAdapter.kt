package com.nehal.intervue.adapter

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.nehal.intervue.views.PageAdapter

class CategoryViewPagerAdapter(fm: FragmentActivity) : FragmentStateAdapter(fm) {
    override fun createFragment(position: Int) = PageAdapter.instance()
    override fun getItemCount(): Int = 4
}