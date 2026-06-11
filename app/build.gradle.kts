plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.kingstudio.weatherforecast"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "com.kingstudio.weatherforecast"
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

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)

    // Retrofit — for making API calls
    implementation(libs.retrofit)

    // Gson Converter — converts JSON response to Kotlin data class automatically
    implementation(libs.converter.gson)

    // Coroutines — for suspend functions and background work
    implementation(libs.kotlinx.coroutines.android)

    // ViewModel — for WeatherViewModel
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    // lifecycleScope and repeatOnLifecycle — for collecting StateFlow in Activity
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // by viewModels() delegate
    implementation(libs.androidx.activity.ktx.v190)


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}