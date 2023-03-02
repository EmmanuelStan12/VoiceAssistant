plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.kapt")
}

android {
    namespace = "com.codedev.data_lib"
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
    testOptions {
        animationsDisabled = true

        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    /* to allow base feature module access */
    api(project(mapOf("path" to ":libraries:api-lib")))
    api(project(mapOf("path" to ":libraries:room-lib")))
    implementation(project(mapOf("path" to ":libraries:utils-lib")))

    implementation(Dependencies.appcompat)
    implementation(Dependencies.timber)
    implementation(Dependencies.dagger)
    kapt(Dependencies.dagger_kapt)

//    testImplementation(Dependencies.junit)
//    testImplementation(Dependencies.truth)
//    testImplementation(Dependencies.mockito_kotlin)
//    testImplementation(Dependencies.robolectric)
}