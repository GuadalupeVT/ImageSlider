package com.gvt.imageslider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configure the slider, you will need the drawables and layouts if you want to use them
        val imageSlider = findViewById<ImageSlider>(R.id.imageCarrousel)

        //Create a layout with your indicators then add it to the image slider
        imageSlider.configureNextButtonLayout(R.layout.layout_right)
        imageSlider.configurePreviousButtonLayout(R.layout.layout_left)

        // Add the images or update the current position
        val activeDrawable = ContextCompat.getDrawable(this, R.drawable.active_status)
        val inactiveDrawable = ContextCompat.getDrawable(this, R.drawable.inactive_status)
        if (activeDrawable != null && inactiveDrawable != null) {
            imageSlider.configure(
                activeIndicator = activeDrawable,
                inactiveIndicator = inactiveDrawable,
                listOfImages = listOf(
                    "https://cdn.pixabay.com/photo/2017/07/15/20/50/iron-man-2507706_1280.png",
                    "https://cdn.pixabay.com/photo/2021/01/29/03/46/hulk-5959621_1280.png",
                    "https://hips.hearstapps.com/hmg-prod/images/spider-man-manos-fotogramas-1638388698.jpg?crop=1xw:1xh;center,top&resize=1200:*"
                )
            )
        }
    }
}