package com.nehal.intervue.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nehal.intervue.R
import com.nehal.intervue.ViewPager2PageChangeCallback
import com.nehal.intervue.adapter.CategoryAdapter
import com.nehal.intervue.utils.Category
import kotlinx.android.synthetic.main.activity_main2.*

class InfinitiveCategoryPageActivity : AppCompatActivity() {
    private lateinit var viewPager2PageChangeCallback: ViewPager2PageChangeCallback

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        val list: MutableList<Category> = mutableListOf()

        list.add(Category(1, "Your Recording"))
        list.add(Category(1, "Your Recording"))
        list.add(Category(2, "Film"))
        list.add(Category(3, "Series"))
        list.add(Category(4, "Kids"))
        list.add(Category(5, "Sport"))
        list.add(Category(5, "Sport"))

        val adapter = CategoryAdapter()
        viewPager2.adapter = adapter
        adapter.setItem(list)

        viewPager2.currentItem = 1

        viewPager2PageChangeCallback = ViewPager2PageChangeCallback {
            viewPager2.post {
                viewPager2.setCurrentItem(it, false)
            }
        }
        viewPager2.registerOnPageChangeCallback(viewPager2PageChangeCallback)
    }

    override fun onDestroy() {
        super.onDestroy()
        viewPager2.unregisterOnPageChangeCallback(viewPager2PageChangeCallback)
    }
}