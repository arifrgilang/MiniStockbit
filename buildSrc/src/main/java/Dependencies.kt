object DefaultConfig {
    val appId = "com.arifrgilang.sslglobal"

    val minSdk = 21
    val targetSdk = 29
    val compileSdk = 29
    val buildTools = "29.0.3"

    val testRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object Releases {
    val versionCode = 1
    val versionName = "1.0"
}

object Versions {
    val kotlin = "1.4.21"
    val coreKtx = "1.3.2"
    val appCompat = "1.2.0"
    val material = "1.3.0"
    val constraintLayout = "2.0.4"

    val activityKtx = "1.1.0"
    val fragmentKtx = "1.2.5"
    val lifecycle = "1.1.1"
    val navVersion = "2.3.4"

    val koin = "2.2.2"
    val hawk = "2.0.1"
    val anko = "0.10.8"
    val scarlet = "0.2.5-SNAPSHOT"

    val swipeRefreshLayout = "1.1.0-rc01"
    val glide = "4.10.0"
    val glideLegacy = "1.0.0"
    val glideKapt = "4.10.0"

    val retrofit = "2.7.1"
    val okHttpInterceptor = "4.5.0"
    val okHttp = "4.7.2"

    val rxJava = "2.2.10"
    val rxAndroid = "2.1.1"

    val junit = "4.13"
    val extJunit = "1.1.2"
    val espresso = "3.3.0"
}

object Deps {
    // Base
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    val material = "com.google.android.material:material:${Versions.material}"
    val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefreshLayout}"
    val activityKtx = "androidx.activity:activity-ktx:${Versions.activityKtx}"
    val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"
    val lifeCycle = "android.arch.lifecycle:extensions:${Versions.lifecycle}"

    // Other
    val koinViewModel = "org.koin:koin-android-viewmodel:${Versions.koin}"
    val navFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navVersion}"
    val navUi = "androidx.navigation:navigation-ui-ktx:${Versions.navVersion}"
    val hawk = "com.orhanobut:hawk:${Versions.hawk}"
    val anko = "org.jetbrains.anko:anko:${Versions.anko}"

    // Scarlet
    val scarlet = "com.tinder.scarlet:scarlet:${Versions.scarlet}"
    val scarletRx = "com.tinder.scarlet:stream-adapter-rxjava2:${Versions.scarlet}"
    val scarletGson = "com.tinder.scarlet:message-adapter-gson:${Versions.scarlet}"
    val scarletOkHttp = "com.tinder.scarlet:protocol-websocket-okhttp:${Versions.scarlet}"
//    val scarletLifecycle = "com.tinder.scarlet:scarlet-lifecycle-android:${Versions.scarlet}"

    // Glide
    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    val glideLegacy = "androidx.legacy:legacy-support-v4:${Versions.glideLegacy}"
    val glideKapt = "com.github.bumptech.glide:compiler:${Versions.glideKapt}"

    // Retrofit
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofitRxJava = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

    // OkHttp
    val interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttpInterceptor}"
    val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"

    // RxJava
    val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"
    val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"

    // Test
    val junit = "junit:junit:${Versions.junit}"
    val extJunit = "androidx.test.ext:junit:${Versions.extJunit}"
    val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}