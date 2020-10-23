import io.ciriti.ceres.dsl.frameworkConfig
import io.ciriti.ceres.dsl.frameworkTask
import kotlinx.coroutines.internal.artificialFrame

buildscript {
    repositories {
        flatDir { dirs("../ceres/build/libs/") }
        mavenLocal()
        google()
        jcenter()
    }
    dependencies {
        classpath ("io.github.ciriti:ceres:+") //  this is for testing with maven local
//        classpath "io.github.ciriti:ceres:0.3.2-SNAPSHOT" //  this is for testing with maven local

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

version="0.1-SNAPSHOT"
group="pd.mlm"

//apply plugin: 'java-library'
apply(plugin = "java-library")
//apply plugin: 'io.github.ciriti.ceres'
apply(plugin = "io.github.ciriti.ceres")

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

/**
 * another way to configure it:
 *
 *  configure<io.ciriti.ceres.KmmExtension>{
 *      name = "Framework name"
 *      author = "Author"
 *  }
 *
 */

frameworkConfig {
    name = "Framework name"
    author = "Author"
}

tasks.frameworkTask{
    message = "test message"
    recipient = "rec"
    recipient2 = "rec2"
}


