# Image Slide or Carousel Image

<div style="display: flex; justify-content: center;">
  <img src="https://github.com/GuadalupeVT/ImageSlider/assets/44481900/29695f76-89d2-4bc9-8697-1b76707245d0" width="200" alt="Screenshot_1688604021">
  <img src="https://github.com/GuadalupeVT/ImageSlider/assets/44481900/fd8065dc-f701-48b7-8642-1ffbb62efc02" alt="Screenshot_1688604030" width="200">
</div>
This project is based on another library (org.imaginativeworld.whynotimagecarousel:whynotimagecarousel:2.1.0) but customized to meet your specific needs. All you need are your own drawables and layouts.

The implementation is easy and requires fewer lines of code.

To use it, simply import the library into your project:

```
maven { url 'https://jitpack.io'}
implementation 'com.github.GuadalupeVT:ImageSlider:1.0.0'
```

In your XML file, add the ImageSlider component:
```
<com.gvt.imageslider.ImageSlider android:id="@+id/imageCarrousel" android:layout_width="match_parent" android:layout_height="200dp" app:layout_constraintEnd_toEndOf="parent" app:layout_constraintStart_toStartOf="parent" app:layout_constraintTop_toTopOf="parent"/>
```

In your activity, add the images:

Configure the slider, you will need the drawables and layouts if you want to use them
```
val imageSlider = findViewById<ImageSlider>(R.id.imageCarrousel)
```

Create a layout with your indicators, then add it to the image slider
```
mageSlider.configureNextButtonLayout(R.layout.layout_right) imageSlider.configurePreviousButtonLayout(R.layout.layout_left)
```

Add the images or update the current position
```
imageSlider.configure( activeIndicator = activeDrawable, inactiveIndicator = inactiveDrawable, listOfImages = listOf( "https://image","https://image","https://image",))
```

You can use the MainActivity as example
