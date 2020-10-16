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

//apply plugin: 'java-library'
apply(plugin = "java-library")
//apply plugin: 'io.github.ciriti.ceres'
apply(plugin = "io.github.ciriti.ceres")

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

configure<io.ciriti.ceres.KmmExtension>{
    name = "Carmelo"
    author = "PD"
}

//hello {
//    message = "Porco dio"
//    recipient = "Carmelo"
//    recipient2 = "Carmelo"
//}

//frameworkConfig {
//    name = "Achille"
//    author = "Achillele dog"
//    testVersion = "pd"
//    person{
//        name = "Carmelo"
//    }
//}


