// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
        jcenter()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:${Dependencies.gradle_v}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Dependencies.kotlin_v}")
        classpath("org.jetbrains.kotlin:kotlin-serialization:${Dependencies.kotlin_v}")
    }
}

tasks.register("clean", Delete::class){
    delete(rootProject.buildDir)
}