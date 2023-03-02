pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "VoiceAssistant"
include(":app")
include(":libraries:room-lib")
include(":libraries:api-lib")
include(":libraries:data-lib")
include(":libraries:utils-lib")
include(":libraries:ui-base-lib")
include(":libraries:speech-recognition-lib")

include(":features:base")
