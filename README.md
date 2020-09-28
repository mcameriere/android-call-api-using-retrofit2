# android-call-api-using-retrofit2

* Launch **Android Studio**
* Click **Start a new Android Studio project**
* Choose **Empty activity**
* Click **Next**
* Name **Call API**
* Package **com.yourdomain.callapi**
* Minimum API Level **API 21: Android 5.0 (Lollipop)**
* Click **Finish**

## AndroidManifest.xml

    <uses-permission android:name="android.permission.INTERNET"/>

## app/build.gradle

    dependencies {
        ...  
        implementation 'com.squareup.retrofit2:retrofit:2.5.0'
        implementation 'com.squareup.retrofit2:converter-gson:2.5.0'
    }
