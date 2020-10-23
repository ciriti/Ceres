package io.ciriti.ceres.dsl

import io.ciriti.ceres.KmmExtension
import io.ciriti.ceres.KmmFrameworkPlugin
import org.gradle.api.Project

fun Project.frameworkConfig(configure : KmmExtension.() -> Unit){
    extensions.configure(KmmFrameworkPlugin.EXTENSION_NAME, configure)
}