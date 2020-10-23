package io.ciriti.ceres

import org.gradle.api.tasks.Exec
import org.gradle.api.tasks.TaskAction
import java.io.File

open class UploadPodspecTask : Exec() {

    companion object{
        const val DESCRIPTION = "Uploading the podspec file to cocoapods"
    }

    init {
        group = Constants.PLUGIN_GROUP_CERES
        description = DESCRIPTION
        workingDir = File(project.buildDir.path)
        commandLine = listOf("ls")
    }

}