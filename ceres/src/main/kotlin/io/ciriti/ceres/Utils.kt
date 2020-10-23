package io.ciriti.ceres

import org.gradle.api.Project
import org.gradle.internal.impldep.org.junit.rules.TemporaryFolder
import java.io.File

fun Project.getPodspecFile(fileName : String) : File =
    File("${buildDir}/ios_artifacts/generated/xcode-frameworks-${version}/${fileName}")

fun Project.getLicenseFile() : File =
    File("${buildDir}/ios_artifacts/generated/xcode-frameworks-${version}/LICENSE")

fun Project.getFrameworkDir() : File =
    File("${buildDir}/ios_artifacts/generated", "xcode-frameworks-${version}")

//fun TemporaryFolder.createSrcFile(name: String, content: String): File {
//
//    return File("${javaSrc.path}/$name")
//        .also {
//            it.createNewFile()
//            it.appendText(text = content)
//        }
//}
//fun TemporaryFolder.createKtSrcFile(name: String, content: String): File {
//
//    return File("${kotlinSrc.path}/$name")
//        .also {
//            it.createNewFile()
//            it.appendText(text = content)
//        }
//}

//fun TemporaryFolder.getSrcFile(name: String): File = javaSrc.resolve("${kotlinSrc}/$name")

//val TemporaryFolder.kotlinSrc: File
//    get() {
//        val dir = File("${this.root}/src/main/kotlin")
//        return when (dir.exists()) {
//            true -> dir
//            false -> this.newFolder("src", "main", "kotlin")
//        }
//    }
//
//val TemporaryFolder.javaSrc: File
//    get() {
//        val dir = File("${this.root}/src/main/java")
//        return when (dir.exists()) {
//            true -> dir
//            false -> this.newFolder("src", "main", "java")
//        }
//    }
//
//val TemporaryFolder.buildFile: File
//    get() {
//        val dir = File("${this.root}/src/main/java")
//        return when (dir.exists()) {
//            true -> dir
//            false -> this.newFolder("src", "main", "java")
//        }
//    }