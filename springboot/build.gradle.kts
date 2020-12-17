import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinVersion: String by project
val spekVersion: String by project

plugins {
    application
    id("com.github.johnrengelman.shadow")
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.kotlin.kapt")
    id("org.jetbrains.kotlin.plugin.allopen")
    id("org.jetbrains.kotlin.plugin.spring")
}


dependencies {
    implementation(platform("org.springframework.boot:spring-boot-dependencies:2.2.5.RELEASE"))
    implementation(platform("org.camunda.bpm:camunda-bom:7.13.0"))

    implementation("org.camunda.bpm.springboot:camunda-bpm-spring-boot-starter")

    implementation("org.springframework.boot:spring-boot-starter-jdbc")

    implementation("org.camunda.bpm.springboot:camunda-bpm-spring-boot-starter-webapp")
    implementation("org.camunda.bpm.springboot:camunda-bpm-spring-boot-starter-rest")

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")

    implementation("org.camunda.bpm:camunda-engine-plugin-spin")
    implementation("org.camunda.spin:camunda-spin-dataformat-json-jackson")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.10.3")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.10.3")

    runtimeOnly("ch.qos.logback:logback-classic:1.2.3")

    runtimeOnly("com.h2database:h2:1.4.200")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
//
    implementation(project(":usertasknameplugin"))
}

application {
    mainClassName = "com.github.stephenott.camunda.plugin.Application"
}

tasks {
    withType<Test> {
        useJUnitPlatform()
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
