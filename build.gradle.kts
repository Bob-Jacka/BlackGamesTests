plugins {
    id("java")
    kotlin("jvm")
    id("org.springframework.boot") version "3.4.1"
	id("io.spring.dependency-management") version "1.1.7"
	id("org.graalvm.buildtools.native") version "0.10.4"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

dependencies {
    implementation(platform("io.qameta.allure:allure-junit5:2.25.0"))
    implementation("io.qameta.allure:allure-selenide:2.20.1")
    implementation("com.codeborne:selenide:7.4.0")
    implementation("org.awaitility:awaitility:4.2.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:2.0.0")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.boot:spring-boot-testcontainers")
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.testcontainers:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}