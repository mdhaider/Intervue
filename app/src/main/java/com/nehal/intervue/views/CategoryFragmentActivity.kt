package com.nehal.intervue.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.nehal.intervue.R
import com.nehal.intervue.adapter.CategoryViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main2.*

class CategoryFragmentActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        viewPager2.adapter = createFragmentStateAdapter()
    }

    private fun createFragmentStateAdapter(): RecyclerView.Adapter<*> =
        CategoryViewPagerAdapter(this)
}

class PageAdapter : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.item_category_page, container, false)
    }

    companion object {
        fun instance() = PageAdapter()
    }
}