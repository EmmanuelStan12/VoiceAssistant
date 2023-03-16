plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.codedev.voiceassistant"
    compileSdk = Dependencies.compileSDK

    defaultConfig {
        applicationId = "com.codedev.voiceassistant"
        minSdk = Dependencies.minSDK
        targetSdk = Dependencies.targetSDK
        versionCode = Dependencies.versionCode
        versionName = Dependencies.versionName

        testInstrumentationRunner = Dependencies.tiRunner
    }

    buildTypes {
        debug {
            isDebuggable = true
            isMinifyEnabled = Dependencies.isMinifyEnabled
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
        }

        release {
            isDebuggable = false
            isMinifyEnabled = Dependencies.isMinifyEnabled
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
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
        viewBinding = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.kce_version
    }
}

dependencies {

    implementation(project(mapOf("path" to ":features:base")))
    implementation(project(mapOf("path" to ":features:home")))
    implementation(project(mapOf("path" to ":features:dictionary")))
    implementation(project(mapOf("path" to ":libraries:ui-base-lib")))
    implementation(Dependencies.core)
    implementation(Dependencies.appcompat)
    implementation(Dependencies.timber)
    implementation(Dependencies.material)

    implementation(Dependencies.material)
    implementation(Dependencies.appcompat)
    implementation(Dependencies.constraintlayout)
    implementation(Dependencies.fragmentnavigation)
    implementation(Dependencies.navigationui)
}