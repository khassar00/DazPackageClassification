import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.10"
    id("org.jetbrains.compose") version "1.1.0"
}

group = "me.khassar"
version = "1.0"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    implementation(compose.desktop.currentOs)
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}
tasks.create("packageVersion"){
    doLast{
        println(compose.desktop.application.nativeDistributions.packageVersion)
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "DazPackageClassification"
            packageVersion = "1.0.0"
        }
        nativeDistributions {
            windows {
                /*dirChooser =false*/
                menuGroup = "start-menu-group"
                upgradeUuid = "65d6deeb-8017-45c7-b3bc-f3e8568991ce"
                iconFile.set(project.file("src\\main\\resources\\icon.ico"))
                appResourcesRootDir.set(project.layout.projectDirectory.dir("src\\main\\resources"))
            }
        }
    }
}
