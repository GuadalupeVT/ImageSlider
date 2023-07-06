package com.gvt.imageslider

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

class ImageSlider @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private var imageCarrousel: ImageCarousel
    private var indicatorsView: RecyclerView
    private val carouselAdapter = CarouselListener()
    private lateinit var navigationDotsAdapter: IndicatorsAdapter

    init {
        LayoutInflater.from(context).inflate(R.layout.component_image_slider, this, true)
        imageCarrousel = findViewById(R.id.imageCarousel)
        indicatorsView = findViewById(R.id.indicatorsNavigation)
    }

    fun configure(
        showCaption: Boolean = false,
        infiniteCarousel: Boolean = true,
        autoPlay: Boolean = false,
        showBottomShadow: Boolean = false,
        showTopShadow: Boolean = false,
        activeIndicator: Drawable,
        inactiveIndicator: Drawable,
        listOfImages: List<String>,
        actualPosition: Int = 0
    ) {
        imageCarrousel.showCaption = showCaption
        imageCarrousel.infiniteCarousel = infiniteCarousel
        imageCarrousel.autoPlay = autoPlay
        imageCarrousel.showIndicator = false
        imageCarrousel.showBottomShadow = showBottomShadow
        imageCarrousel.showTopShadow = showTopShadow

        navigationDotsAdapter = IndicatorsAdapter(activeIndicator, inactiveIndicator, ::goToNextImage)
        imageCarrousel.carouselListener = carouselAdapter
        indicatorsView.adapter = navigationDotsAdapter

        val list = listOfImages.map { CarouselItem(it) }

        navigationDotsAdapter.list = list
        navigationDotsAdapter.positionActive = actualPosition
        navigationDotsAdapter.notifyDataSetChanged()
        imageCarrousel.currentPosition = actualPosition
        imageCarrousel.setData(list)
    }

    private fun goToNextImage(position: Int) {
        imageCarrousel.currentPosition = position
        navigationDotsAdapter.positionActive = position
        navigationDotsAdapter.notifyDataSetChanged()
    }

    fun configurePreviousButtonLayout(layoutId: Int) {
        imageCarrousel.previousButtonLayout = layoutId
        imageCarrousel.findViewById<AppCompatImageView>(imageCarrousel.previousButtonId).setOnClickListener {
            imageCarrousel.previous()
            if (navigationDotsAdapter.positionActive == 0) {
                navigationDotsAdapter.positionActive = navigationDotsAdapter.list.size - 1
            } else {
                navigationDotsAdapter.positionActive = navigationDotsAdapter.positionActive - 1
            }
            navigationDotsAdapter.notifyDataSetChanged()
        }
    }

    fun configureNextButtonLayout(layoutId: Int) {
        imageCarrousel.nextButtonLayout = layoutId
        imageCarrousel.findViewById<AppCompatImageView>(imageCarrousel.nextButtonId).setOnClickListener {
            imageCarrousel.next()
            if (navigationDotsAdapter.list.size == navigationDotsAdapter.positionActive +1)
                navigationDotsAdapter.positionActive = 0
            else navigationDotsAdapter.positionActive = navigationDotsAdapter.positionActive + 1
            navigationDotsAdapter.notifyDataSetChanged()
        }
    }
}