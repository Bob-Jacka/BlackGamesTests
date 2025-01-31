plugins {
    id("java")
    kotlin("jvm")
    id("org.springframework.boot") version "3.4.1"
    id("io.spring.dependency-management") version "1.1.7"
    id("org.jetbrains.dokka") version "2.0.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    //Main logic dependencies
    implementation(platform("io.qameta.allure:allure-junit5:2.25.0"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib:2.0.20")
    implementation("io.qameta.allure:allure-selenide:2.20.1")
    implementation("com.codeborne:selenide:7.7.1")
    implementation("org.jetbrains.dokka:dokka-gradle-plugin:2.0.0")
    implementation("org.openjfx:javafx-swing:23.0.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")

    //Spring dependencies
    implementation("org.springframework.boot:spring-boot-starter-aop")
    implementation("org.springframework.boot:spring-boot-starter-test")
    implementation("org.springframework.boot:spring-boot-testcontainers")
    implementation("org.springframework.boot:spring-boot-devtools")

    //Lombok dependencies
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    //Test dependencies
    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.11.4")
    testImplementation("org.junit.platform:junit-platform-suite:1.11.4")
}

tasks.test {
    useJUnitPlatform()
}

val jvm_version = 17

kotlin {
    jvmToolchain(jvm_version)
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(jvm_version)
    }
}