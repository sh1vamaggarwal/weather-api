/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java application project to get you started.
 * For more details on building Java & JVM projects, please refer to https://docs.gradle.org/8.8/userguide/building_java_projects.html in the Gradle documentation.
 */

plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    id("org.springframework.boot") version "3.5.4"
    id("io.spring.dependency-management") version "1.1.7"
    application
}

group = "com.shivamaggarwal"
version = "1.0-SNAPSHOT"

java.sourceCompatibility = JavaVersion.VERSION_21

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    // Define the main class for the application.
    mainClass = "com.shivamaggarwal.weatherapi.WeatherApiApplication"
}

tasks.withType<Test> {
    useJUnitPlatform()
}
