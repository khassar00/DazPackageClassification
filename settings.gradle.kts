enableFeaturePreview("VERSION_CATALOGS")
dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            version("ktor", "2.0.0")
            library("ktor-client-core","io.ktor","ktor-client-core").versionRef("ktor")
            library("ktor-serialization-kotlinx-json","io.ktor","ktor-serialization-kotlinx-json").versionRef("ktor")
            library("ktor-client-logging","io.ktor","ktor-client-logging").versionRef("ktor")
            library("ktor-client-cio","io.ktor","ktor-client-cio").versionRef("ktor")
            library("ktor-client-content-negotiation","io.ktor","ktor-client-content-negotiation").versionRef("ktor")
        }
    }
}
pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven ("https://jitpack.io" )
    }

}
rootProject.name = "DazPackageClassification"

