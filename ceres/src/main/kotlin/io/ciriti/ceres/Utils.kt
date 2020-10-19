package io.ciriti.ceres

import org.gradle.api.Project
import java.io.File

fun Project.getPodspecFile(fileName : String) : File =
    File("${buildDir}/ios_artifacts/generated/xcode-frameworks-${version}/${fileName}")

fun Project.getLicenseFile() : File =
    File("${buildDir}/ios_artifacts/generated/xcode-frameworks-${version}/LICENSE")

fun Project.getFrameworkDir() : File =
    File("${buildDir}/ios_artifacts/generated", "xcode-frameworks-${version}")