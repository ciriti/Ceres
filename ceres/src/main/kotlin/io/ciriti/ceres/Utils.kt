package io.ciriti.ceres

import org.gradle.api.Project
import java.io.File

fun Project.getPodspecPath(fileName : String) : File =
    File("${project.buildDir}/ios_artifacts/generated/xcode-frameworks-${project.version}/${fileName}")