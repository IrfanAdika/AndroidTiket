object Environment {
    const val BASE_URL = "\"\""
}

object ApplicationId {
    const val id = "com.irfan.androidtiket"
}

object Modules {
    const val app = ":app"
    const val core = ":core"
    const val datasource = ":datasource"
}

object Releases {
    const val versionCode = 1
    const val versionName = "1.0"
}

object Versions {
    const val gradle = "4.0.0"
    const val compileSdk = 30
    const val minSdk = 21
    const val targetSdk = 30
    const val buildTools = "30.0.2"
    const val kotlin = "1.3.72"
    const val coreKtx = "1.3.2"
    const val appCompat = "1.2.0"
    const val constraintLayout = "2.0.4"
    const val recyclerview = "1.0.0"
    const val glide = "4.0.0"
    const val materialDesign = "1.1.0"
    const val retrofit = "2.9.0"
    const val retrofitCoroutinesAdapter = "0.9.2"
    const val junit = "4.12"
    const val legacySupport = "1.0.0"
    const val androidxJunit = "1.1.2"
    const val espresso = "3.3.0"
    const val multidex = "2.0.1"
    const val cardview = "1.1.0"
    const val realmExt = "2.5.0"
    const val koin = "2.2.0-rc-3"
    const val coroutines = "1.3.9"
    const val loggingInterceptor = "4.9.0"
    const val lifecycle = "2.2.0"
    const val navigation = "2.3.0"
    const val pagedList = "3.0.0-alpha03"
    const val timber = "4.7.1"
    const val room = "2.3.0-alpha02"
    const val roomCoroutines = "2.1.0-alpha04"
    const val playCore = "1.6.1"
    // Moshi
    const val moshi = "1.11.0"
    const val moshiRetrofitConverter = "2.9.0"
    const val swipeRefreshLayout = "1.1.0"
    // Stetho
    const val stetho = "1.5.1"
    const val arch_viewModelLiveData = "2.2.0"
    const val palette = "1.0.0"
    // KTX
    const val ktx_Fragment = "1.2.5"
    const val ktx_Palette = "1.0.0"
    const val ktx_Collections = "1.1.0"
    const val ktx_LifecycleViewModel = "2.3.0"
    const val ktx_ReactiveStreams = ktx_LifecycleViewModel
    const val navigationComponent = "2.3.4"
}

object Dependencies {
    //glide
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    //koin
    const val koinCore = "org.koin:koin-core:${Versions.koin}"
    const val koinAndroid = "org.koin:koin-android:${Versions.koin}"
    const val koinAndroidX = "org.koin:koin-androidx-scope:${Versions.koin}"
    const val koinViewModel = "org.koin:koin-android-viewmodel:${Versions.koin}"

    //retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitCoroutinesAdapter =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofitCoroutinesAdapter}"
    const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val okhttp = "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"

    // Moshi
    const val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"
    const val moshiKotlin = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
    const val moshiRetrofitConverter =
        "com.squareup.retrofit2:converter-moshi:${Versions.moshiRetrofitConverter}"

    //realm
    const val realmExt = "com.github.vicpinm:krealmextensions:${Versions.realmExt}"

    //room
    const val room = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomTesting = "androidx.room:room-testing:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val arch_RoomCoroutines = "androidx.room:room-coroutines:${Versions.roomCoroutines}"

    //coroutines
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    //navigation
    const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val pagedList = "androidx.paging:paging-runtime:${Versions.pagedList}"

    //timber
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    // Stetho
    const val stetho = "com.facebook.stetho:stetho:${Versions.stetho}"
    const val stethoInterceptor = "com.facebook.stetho:stetho-okhttp3:${Versions.stetho}"

    // Jars
    val jarLibs = mapOf("dir" to "libs", "include" to listOf("*.jar"))
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    const val palette = "androidx.palette:palette:${Versions.palette}"
    const val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefreshLayout}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val materialDesign  = "com.google.android.material:material:${Versions.materialDesign}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val ktx_Fragment = "androidx.fragment:fragment-ktx:${Versions.ktx_Fragment}"
    const val ktx_Palette = "androidx.palette:palette-ktx:${Versions.ktx_Palette}"
    const val ktx_Collections = "androidx.collection:collection-ktx:${Versions.ktx_Collections}"
    const val ktx_LifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.ktx_LifecycleViewModel}"
    const val ktx_ReactiveStreams =
        "androidx.lifecycle:lifecycle-reactivestreams-ktx:${Versions.ktx_ReactiveStreams}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val legacy = "androidx.legacy:legacy-support-v4:${Versions.legacySupport}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    const val cardview = "androidx.cardview:cardview:${Versions.cardview}"
    const val multidex = "androidx.multidex:multidex:${Versions.multidex}"
    const val androidxJunit = "androidx.test.ext:junit:${Versions.androidxJunit}"
    const val jUnit = "junit:junit:${Versions.junit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val lifecycle = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    // ViewModel + Lifecycle
    const val arch_ViewModelLiveData =
        "androidx.lifecycle:lifecycle-extensions:${Versions.arch_viewModelLiveData}"
    const val xmlRpc = "com.github.gturri:aXMLRPC:master-SNAPSHOT"
    const val playCore = "com.google.android.play:core:${Versions.playCore}"
}

object BuildPlugins {
    const val safeArgs =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val androidDynamicFeature = "com.android.dynamic-feature"
    const val androidxNavSafeArgs = "androidx.navigation.safeargs.kotlin"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
    const val kotlinAnnotationProcessor = "kotlin-kapt"
    const val plugin_GoogleServices = "com.google.gms.google-services"
    const val plugin_crashlytics = "com.google.firebase.crashlytics"
    const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}