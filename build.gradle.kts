import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    val kotlinVersion = "1.4.10"
    application
    id("com.github.johnrengelman.shadow") version "5.1.0" apply false
    id("org.jetbrains.kotlin.jvm") version kotlinVersion apply false
    id("org.jetbrains.kotlin.kapt") version kotlinVersion apply false
    id("org.jetbrains.kotlin.plugin.allopen") version kotlinVersion apply false
    id("org.jetbrains.kotlin.plugin.spring") version kotlinVersion apply false
    id("idea")
}

idea {
    module {
        isDownloadJavadoc = true
        isDownloadSources = true
    }
}


allprojects {

    version = "1.0"
    group = "camunda-usertask-name-expression-process-engine-plugin"

    repositories {
        jcenter()
    }

    tasks {
        withType<KotlinCompile> {
            kotlinOptions {
                jvmTarget = JavaVersion.VERSION_1_8.toString()
                javaParameters = true
            }
        }
    }
}
