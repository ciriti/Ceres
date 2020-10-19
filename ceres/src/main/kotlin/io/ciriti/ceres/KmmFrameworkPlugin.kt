package io.ciriti.ceres

import org.gradle.api.Plugin
import org.gradle.api.Project

class KmmFrameworkPlugin : Plugin<Project> {

    companion object{
        const val EXTENSION_NAME = "frameworkConfig"
    }

    override fun apply(project: Project) {

        val extension : KmmExtension = project.extensions.create(EXTENSION_NAME, KmmExtension::class.java)

        project.tasks.create("uploadPodspec", UploadPodspecTask::class.java)

        project.tasks.create("createPodspec", CreatePodspecTask::class.java, "RickAndMortyData.podspec", extension)

        project.tasks.create("framework", IosFrameworkTask::class.java){
            this.extension = extension
//            it.extension = extension
        }.doLast {

            println(
                """
                name: ${extension.name}
                author: ${extension.author}
            """.trimIndent()
            )
        }

    }
}