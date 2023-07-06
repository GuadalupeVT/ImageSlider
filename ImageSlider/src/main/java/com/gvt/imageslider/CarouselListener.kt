package com.gvt.imageslider

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewbinding.ViewBinding
import org.imaginativeworld.whynotimagecarousel.databinding.ItemCarouselBinding
import org.imaginativeworld.whynotimagecarousel.listener.CarouselListener
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem
import org.imaginativeworld.whynotimagecarousel.utils.setImage

class CarouselListener: CarouselListener {

    override fun onCreateViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup
    ): ViewBinding {
        return ItemCarouselBinding.inflate(layoutInflater, parent, false)
    }

    override fun onBindViewHolder(
        binding: ViewBinding,
        item: CarouselItem,
        position: Int,
    ) {
        val currentBinding = binding as ItemCarouselBinding
        currentBinding.img.apply {
            scaleType = ImageView.ScaleType.FIT_XY
            setImage(item)
        }
    }
}