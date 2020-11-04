package com.nehal.intervue.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.nehal.intervue.R
import com.nehal.intervue.adapter.CategoryAdapter
import com.nehal.intervue.utils.DummyCategoryData.categories
import kotlinx.android.synthetic.main.activity_multiple_categories.*

class CategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        val orientationType = intent.getStringExtra(ORIENTATION_TYPE)

        val adapter = CategoryAdapter()
        viewPager2.adapter = adapter

        if (orientationType == ORIENTATION_VERTICAL) {
            viewPager2.orientation = ViewPager2.ORIENTATION_VERTICAL
        }
        adapter.setItem(categories)
    }

    companion object {
        const val ORIENTATION_HORIZONTAL = "ORIENTATION_HORIZONTAL"
        const val ORIENTATION_VERTICAL = "ORIENTATION_VERTICAL"
    }
}