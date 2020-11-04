package com.nehal.intervue.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nehal.intervue.R
import com.nehal.intervue.adapter.CategoryAdapter
import com.nehal.intervue.transformer.ViewPager2PageTransformation
import com.nehal.intervue.utils.DummyCategoryData.categories
import kotlinx.android.synthetic.main.activity_main2.*

class PageTransformerCategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val adapter = CategoryAdapter()
        viewPager2.adapter = adapter
        adapter.setItem(categories)
        with(viewPager2) {
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 3
        }

        viewPager2.setPageTransformer(ViewPager2PageTransformation())
    }
}
