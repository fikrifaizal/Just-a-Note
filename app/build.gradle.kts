plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
    id("com.google.devtools.ksp")
    alias(libs.plugins.hiltAndroid)
}

android {
    namespace = "com.portme.just_a_note"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.portme.just_a_note"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {
//    Kotlin
    implementation(libs.androidx.core.ktx)

//    UI
    implementation(libs.material)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.fragment)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.swiperefreshlayout)

//    Navigation
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

//    Architecture KTX
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)

//    Networking
    implementation (libs.retrofit2)
    implementation (libs.retrofit2.converter.gson)
    implementation (libs.logging.interceptor)

//    Database and Paging
    implementation (libs.androidx.room.runtime)
    implementation (libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)
    implementation (libs.androidx.room.paging)
    implementation (libs.androidx.paging.runtime.ktx)

//    Datastore
    implementation(libs.androidx.datastore.preferences)

//    Coroutine
    implementation (libs.kotlinx.coroutines.android)

//    Dependency Injection
//    Dagger Hilt cannot use ksp instead kapt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

//    Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}