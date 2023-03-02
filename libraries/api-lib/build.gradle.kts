plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.kapt")
    id("kotlinx-serialization")
}

android {
    namespace = "com.codedev.api_lib"
    compileSdk = Dependencies.compileSDK

    defaultConfig {
        minSdk = Dependencies.minSDK
        targetSdk = Dependencies.targetSDK

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = Dependencies.isMinifyEnabled
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(mapOf("path" to ":libraries:utils-lib")))

    implementation(Dependencies.retrofit)
    implementation(Dependencies.retrofit_gson)

    implementation(Dependencies.ktorclientcore)
    implementation(Dependencies.ktorclientcio)
    implementation(Dependencies.ktorclientokhttp)
    implementation(Dependencies.ktorclientcontentnego)
    implementation(Dependencies.ktorserialization)
    implementation(Dependencies.ktorclientlogging)

    implementation(Dependencies.timber)
    implementation(Dependencies.dagger)
    kapt(Dependencies.dagger_kapt)
}