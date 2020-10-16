// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        mavenCentral()
        mavenLocal()
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.0.1")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.10")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

plugins {
    id ("java-gradle-plugin")
    id ("com.gradle.plugin-publish") version ("0.12.0")
    id ("org.jetbrains.kotlin.jvm") version ("1.4.10")
    id ("maven-publish")
    id ("org.gradle.kotlin.kotlin-dsl") version ("1.4.2")
}

//group 'io.github.ciriti'
//version '0.2.5-SNAPSHOT'

//repositories {
//    mavenCentral()
//}

allprojects {
    repositories {
        mavenLocal()
        google()
        jcenter()
//        mavenCentral()
    }
}

//task clean(type: Delete) {
//    delete rootProject.buildDir
//}



//pluginBundle {
//    website = 'https://github.com/ciriti/Ceres.git'
//    vcsUrl = 'https://github.com/ciriti/Ceres.git'
//    tags = ['kotlin', 'KMP', 'framework', 'ios']
//}
//
//gradlePlugin {
//    plugins {
//        greetingsPlugin {
//            id = 'io.github.ciriti.ceres'
//            displayName = 'Ceres kmp'
//            description = 'This plugin will help you to crete an ios framework out of a KMP project'
//            implementationClass = 'io.ciriti.ceres.GreetingPlugin'
//        }
//    }
//}

//dependencies {
//    implementation "org.jetbrains.kotlin:kotlin-stdlib"
//    testCompile group: 'junit', name: 'junit', version: '4.12'
//}
//
//compileKotlin {
//    kotlinOptions {
//        jvmTarget = "1.8"
//    }
//}
//compileTestKotlin {
//    kotlinOptions {
//        jvmTarget = "1.8"
//    }
//}
//
//publishing {
////    publications {
////        jar(MavenPublication) {
////            groupId = group
////            artifactId = 'ceres'
////            artifact("$buildDir/libs/${project.getName()}-${version}.jar")
////        }
////    }
//    repositories {
//        maven {
//            name = "Ceres" //  optional target repository name
//            url = "https://oss.sonatype.org/content/repositories/snapshots"
//            credentials {
//                username = MVN_USERNAME
//                password = MVN_PASSWORD
//            }
//        }
//    }
//}
