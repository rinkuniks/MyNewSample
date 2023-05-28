package com.nikhil.mynewsample


import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.viewpager2.widget.ViewPager2
import com.nikhil.mynewsample.adapters.ViewPagerAdapter

class CarousalViewActivity : AppCompatActivity() {
    private lateinit var dot1: ImageView
    private lateinit var dot2: ImageView
    private lateinit var dot3: ImageView
    private lateinit var viewPager2: ViewPager2

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carousal_view)

            viewPager2 = findViewById(R.id.mainViewPager)
            dot1 = findViewById(R.id.dot1)
            dot2 = findViewById(R.id.dot2)
            dot3 = findViewById(R.id.dot3)

            val images = listOf(R.color.grey, R.color.black, R.color.purple_500)
            val myAdapter = ViewPagerAdapter(images)
            viewPager2.adapter = myAdapter
            viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                    changeColor()
                    super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                }

                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                }

                override fun onPageScrollStateChanged(state: Int) {
                    changeColor()
                    super.onPageScrollStateChanged(state)
                }

            })

        }


        private fun changeColor() {
            when(viewPager2.currentItem){
                0->{
                    dot1.setBackgroundColor(applicationContext.resources.getColor(R.color.active))
                    dot2.setBackgroundColor(applicationContext.resources.getColor(R.color.grey))
                    dot3.setBackgroundColor(applicationContext.resources.getColor(R.color.grey))
                }
                1->{
                    dot1.setBackgroundColor(applicationContext.resources.getColor(R.color.grey))
                    dot2.setBackgroundColor(applicationContext.resources.getColor(R.color.active))
                    dot3.setBackgroundColor(applicationContext.resources.getColor(R.color.grey))
                }
                2->{
                    dot1.setBackgroundColor(applicationContext.resources.getColor(R.color.grey))
                    dot2.setBackgroundColor(applicationContext.resources.getColor(R.color.grey))
                    dot3.setBackgroundColor(applicationContext.resources.getColor(R.color.active))
                }
            }
        }
}