plugins {
    id("org.jetbrains.kotlin.jvm").version("1.3.72")
}

repositories {
    mavenCentral()
}

dependencies {
    api(kotlin("stdlib-jdk8"))
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}
