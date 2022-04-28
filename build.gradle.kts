import org.gradle.crypto.checksum.Checksum
import org.gradle.internal.impldep.org.bouncycastle.asn1.bsi.BSIObjectIdentifiers.*
import org.gradle.nativeplatform.SharedLibraryBinarySpec.TasksCollection
import org.jetbrains.compose.ComposePlugin.Dependencies.desktop
import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    kotlin("jvm") version "1.6.10"
    id("org.jetbrains.compose") version "1.1.0"
    id("org.gradle.crypto.checksum") version "1.4.0"
}

group = "me.khassar"
version = "1.0"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    maven("https://jitpack.io")

}

dependencies {
    implementation(compose.desktop.currentOs)
    implementation("com.github.komputing.khash:keccak:1.1.1")
    implementation("commons-io:commons-io:2.11.0")
    implementation("commons-codec:commons-codec:1.15")
    implementation("org.apache.commons:commons-compress:1.21")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.3.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.6.10")
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.cio)
    implementation(libs.ktor.client.logging)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.serialization.kotlinx.json)
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}
tasks.create("packageVersion") {
    doLast {
        print(compose.desktop.application.nativeDistributions.packageVersion)
    }
}

tasks.create<Checksum>("checksum") {


    inputFiles.setFrom(File("build/compose/binaries/main/msi"))
    outputDirectory.set(File("build/compose/binaries/main/msi"))
    checksumAlgorithm.set(Checksum.Algorithm.SHA256)
    appendFileNameToChecksum.set(false)


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
