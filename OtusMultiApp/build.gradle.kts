buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
        maven {
            url = uri("https://dl.bintray.com/icerockdev/plugins")
        }
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.21")
        classpath("com.android.tools.build:gradle:4.1.1")
        classpath("dev.icerock.moko:network-generator:0.8.0")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven {
            url = uri("https://dl.bintray.com/icerockdev/moko")
        }
    }
}