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

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {
    implementation(fileTree(Dependencies.jarLibs))
    implementation(project(Modules.core))

    api(Dependencies.room)
    api(Dependencies.arch_RoomCoroutines)
    kapt(Dependencies.roomCompiler)

    // Moshi Codegen
    kapt(Dependencies.moshiKotlin)

    // Testing
    testImplementation(Dependencies.roomTesting)

}