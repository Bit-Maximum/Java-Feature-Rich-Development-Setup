plugins {
    id("java")
    id("checkstyle")
    id("com.github.spotbugs") version "6.4.4"
    id("com.diffplug.spotless") version "8.0.0"
    id("net.ltgt.errorprone") version "4.3.0"
    id("pmd")
}


spotless {
    java {
        googleJavaFormat("1.30.0").aosp()
        target("src/**/*.java")
        toggleOffOn()
    }
}

checkstyle {
    // https://docs.gradle.org/current/userguide/checkstyle_plugin.html
    toolVersion = "12.1.0"
    configFile = file("config/checkstyle/checkstyle.xml")
    isIgnoreFailures = false
    maxWarnings = 0
}

spotbugs {
    // https://plugins.gradle.org/plugin/com.github.spotbugs
    effort.set(com.github.spotbugs.snom.Effort.MAX)
    reportLevel.set(com.github.spotbugs.snom.Confidence.LOW)
    ignoreFailures.set(false)
}

pmd {
    toolVersion = "7.17.0"
    isIgnoreFailures = false
    isConsoleOutput = true
    rulesMinimumPriority = 5
    // https://docs.pmd-code.org/pmd-doc-7.13.0/pmd_rules_java.html
    ruleSets = listOf(
        "category/java/bestpractices.xml",
        "category/java/errorprone.xml",
        "category/java/design.xml",
        "category/java/performance.xml",
        "category/java/security.xml",
        "category/java/multithreading.xml",
    )
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:6.0.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    errorprone("com.google.errorprone:error_prone_core:2.42.0")
}

tasks.test {
    useJUnitPlatform()
}

tasks.register("codeQuality") {
    group = "verification"
    description = "Run all code style and static analysis checks"
    dependsOn("spotlessCheck", "checkstyleMain", "spotbugsMain", "pmdMain")
}
