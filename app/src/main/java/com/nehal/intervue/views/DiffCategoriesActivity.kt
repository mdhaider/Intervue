package com.nehal.intervue.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nehal.intervue.R
import com.nehal.intervue.adapter.CategoryDiffUtilAdapter
import com.nehal.intervue.utils.DummyCategoryData.categories
import kotlinx.android.synthetic.main.activity_main2.*

class DiffCategoriesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val adapter = CategoryDiffUtilAdapter()
        viewPager2.adapter = adapter

        adapter.submitList(categories)
    }
}
