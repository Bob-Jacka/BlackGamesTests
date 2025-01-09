plugins {
    id("java")
    kotlin("jvm")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

version {
    allure = "2.20.1",
    selenide = "7.4.0",
    awaitility = "4.2.0",
    kotlin = "2.0.0"
    junit5 = "5.10.0"
    allure_junit = "2.25.0"
}

dependencies {
    implementation("io.qameta.allure:allure-selenide:" + allure)
    implementation("com.codeborne:selenide:" + selenide)
    implementation("org.awaitility:awaitility:" + awaitility)
    implementation("org.jetbrains.kotlin:kotlin-stdlib:" + kotlin)
    testImplementation(platform("org.junit:junit-bom:" + junit5))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("io.qameta.allure:allure-junit5:" + allure_junit)
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}