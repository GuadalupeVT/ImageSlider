# Image Slide or Carousel Image

![Carrusel]([/images/picture.jpg](https://private-user-images.githubusercontent.com/44481900/251315224-29695f76-89d2-4bc9-8697-1b76707245d0.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MTQ0MDU2ODAsIm5iZiI6MTcxNDQwNTM4MCwicGF0aCI6Ii80NDQ4MTkwMC8yNTEzMTUyMjQtMjk2OTVmNzYtODlkMi00YmM5LTg2OTctMWI3NjcwNzI0NWQwLnBuZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDA0MjklMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQwNDI5VDE1NDMwMFomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPTU0ODMxMTdlMDhlMjVhM2FmOWQ5M2VlYmFkZGUwZTNmM2Q3ZDlkYWI4MGZkNTM4YWZkOTJiMDcxZWUwMTRmYzcmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0.7eKAVc6a9Bm054S2nHvN66w0OHozODB5G_SntMDQN_A))
![Carrusel]([/images/picture.jpg](https://private-user-images.githubusercontent.com/44481900/251315240-fd8065dc-f701-48b7-8642-1ffbb62efc02.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MTQ0MDU2ODAsIm5iZiI6MTcxNDQwNTM4MCwicGF0aCI6Ii80NDQ4MTkwMC8yNTEzMTUyNDAtZmQ4MDY1ZGMtZjcwMS00OGI3LTg2NDItMWZmYmI2MmVmYzAyLnBuZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDA0MjklMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQwNDI5VDE1NDMwMFomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPThlZTViMGIxNTliM2MwN2I5M2FkNGNmYTc5YjMwMjBkYjkxYzEyMzlkZjhiNmRmZDdjZDY0N2ExZGYyMTVhOTQmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0.PteAaqQOdj-kxioTziPvSmTTAtzlhYfmZPKwp96WDBY))
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
