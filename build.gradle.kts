plugins {
    id("java")
    kotlin("jvm")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}



dependencies {
    implementation("io.qameta.allure:allure-selenide:2.20.1")
    implementation("com.codeborne:selenide:7.4.0")
    implementation("org.awaitility:awaitility:4.2.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:2.0.0")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("io.qameta.allure:allure-junit5:2.25.0")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}