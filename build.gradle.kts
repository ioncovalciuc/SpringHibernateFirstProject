plugins {
    kotlin("jvm") version "1.8.20" // Add the Kotlin plugin
    id("java")
}

group = "md.covalciuc.testSpringMVC"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_16
    targetCompatibility = JavaVersion.VERSION_16
}

dependencies {
    implementation("org.hibernate.orm:hibernate-core:6.2.7.Final")
    runtimeOnly("org.postgresql:postgresql:42.6.0")
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
    testCompileOnly("org.projectlombok:lombok:1.18.30")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.30")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation ("org.hibernate:hibernate-core:5.5.7.Final") // Use the appropriate version
    // Other dependencies
}

tasks.test {
    useJUnitPlatform()
}
