plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.kapt")
}

android {
    namespace = "com.codedev.base"
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
    viewBinding {
        android.buildFeatures.viewBinding = true
    }

}

android.buildTypes.forEach { type ->
    type.buildConfigField("String", "APP_ID","\"com.freexitnow.freexit\"" )
}

dependencies {
    api(project(mapOf("path" to ":libraries:ui-base-lib")))
    api(project(mapOf("path" to ":libraries:data-lib")))
    api(project(mapOf("path" to ":libraries:utils-lib")))

    api(Dependencies.core)
    api(Dependencies.appcompat)
    api(Dependencies.lifecycle_runtime)
    api(Dependencies.lifecycle_viewmodel)
    api(Dependencies.coroutines_android)
    api(Dependencies.timber)
    api(Dependencies.dagger)
    kapt(Dependencies.dagger_kapt)

}