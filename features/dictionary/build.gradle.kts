plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.codedev.dictionary"
    compileSdk = Dependencies.compileSDK

    defaultConfig {
        minSdk = Dependencies.minSDK
        targetSdk = Dependencies.targetSDK

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.kce_version
    }

}

dependencies {

    implementation(project(mapOf("path" to ":features:base")))

    implementation(Dependencies.core)
    implementation(Dependencies.coroutines_android)
    implementation(Dependencies.composeicons)
    implementation(Dependencies.composematerial)
    implementation(Dependencies.composeui)
    implementation(Dependencies.composeactivity)
    implementation(Dependencies.composenavigation)
    implementation(Dependencies.appcompat)
    implementation(Dependencies.material)
    implementation(Dependencies.dotsindicator)
    implementation(Dependencies.fragmentnavigation)
    implementation(Dependencies.navigationui)
}