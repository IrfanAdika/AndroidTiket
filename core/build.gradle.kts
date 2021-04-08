plugins {
    id(BuildPlugins.androidLibrary)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id(BuildPlugins.kotlinAnnotationProcessor)
}

android {
    compileSdkVersion(Versions.compileSdk)
    defaultConfig {

        minSdkVersion(Versions.minSdk)
        targetSdkVersion(Versions.targetSdk)

        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildTypes {
        getByName("release"){
            buildConfigField("String", "BASE_URL", Environment.BASE_URL.toString())

            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

        getByName("debug") {
            buildConfigField("String", "BASE_URL", Environment.BASE_URL.toString())
        }
    }
}

dependencies {
    implementation(fileTree(Dependencies.jarLibs))

    // Kotlin
    api(Dependencies.kotlin)

    // AndroidX
    api(Dependencies.appcompat)
    api(Dependencies.constraintLayout)
    api(Dependencies.recyclerview)
    api(Dependencies.materialDesign)
    api(Dependencies.swipeRefreshLayout)
    api(Dependencies.palette)

    // Navigation
    api(Dependencies.navigationFragmentKtx)
    api(Dependencies.navigationUiKtx)

    // Glide
    api(Dependencies.glide)

    // KTX
    api(Dependencies.ktx_Fragment)
    api(Dependencies.ktx_Palette)
    api(Dependencies.ktx_Collections)
    api(Dependencies.ktx_LifecycleViewModel)
    api(Dependencies.ktx_ReactiveStreams)

    // Architecture Components
    api(Dependencies.arch_ViewModelLiveData)

    // Moshi
    api(Dependencies.moshi)
    implementation(Dependencies.moshiRetrofitConverter)

    // Coroutines
    api(Dependencies.coroutinesAndroid)
    api(Dependencies.coroutinesCore)

    // Architecture Components
    api(Dependencies.arch_ViewModelLiveData)

    // Retrofit
    api(Dependencies.retrofit)
    implementation(Dependencies.retrofitCoroutinesAdapter)
    implementation(Dependencies.okhttp)

    // Stetho
    implementation(Dependencies.stetho)
    implementation(Dependencies.stethoInterceptor)

    // Gson
    api(Dependencies.converterGson)

    // Koin
    api(Dependencies.koinAndroid)
    api(Dependencies.koinCore)
    api(Dependencies.koinViewModel)

    // Testing
    testImplementation(Dependencies.jUnit)

    // Android Testing
    androidTestImplementation(Dependencies.androidxJunit)
    androidTestImplementation(Dependencies.espresso)
}