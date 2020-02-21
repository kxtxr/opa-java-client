import org.gradle.api.JavaVersion.VERSION_11

version = "0.0.1-SNAPSHOT"
group = "com.bisnode.opa"

plugins {
    groovy
    java
    `java-library`
    `maven-publish`
}

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = VERSION_11
    targetCompatibility = VERSION_11
}
dependencies {
    annotationProcessor("org.projectlombok:lombok:1.18.8")
    compileOnly("org.projectlombok:lombok:1.18.8")

    implementation("org.codehaus.groovy:groovy-all:2.5.9")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.10.2")

    testImplementation(platform("org.spockframework:spock-bom:2.0-M1-groovy-2.5"))
    testImplementation("org.spockframework:spock-core")
    testImplementation("com.github.tomakehurst:wiremock-jre8:2.26.0")
}

tasks.test {
    useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }
}
