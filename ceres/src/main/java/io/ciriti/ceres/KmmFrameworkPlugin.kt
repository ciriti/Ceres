package io.ciriti.ceres

import org.gradle.api.Plugin
import org.gradle.api.Project

class KmmFrameworkPlugin : Plugin<Project> {

    companion object{
        const val EXTENSION_NAME = "frameworkConfig"
    }

    override fun apply(project: Project) {

        val extension : KmmExtension = project.extensions.create(EXTENSION_NAME, KmmExtension::class.java)

//        project.tasks.create("hello", Greeting::class.java) { task: Greeting ->  // <1>
//            task.message = "Hello"
//            task.recipient = "World" // <2>
//        }.doLast {
//            println("""
//                name: ${extension.name}
//                author: ${extension.author}
//                testVersion: ${extension.testVersion}
//            """.trimIndent())
//        }

        project.tasks.create("uploadPodspec", UploadPodspecTask::class.java)

        project.tasks.create("createPodspec", CreatePodspecTask::class.java){
            this.ext = extension
        }.doLast {

            println(
                """
                name: ${extension.name}
                author: ${extension.author}
                testVersion: ${extension.testVersion}
            """.trimIndent()
            )
        }

        project.tasks.create("framework", IosFrameworkTask::class.java){
            this.extension = extension
//            it.extension = extension
        }.doLast {

            println(
                """
                name: ${extension.name}
                author: ${extension.author}
                testVersion: ${extension.testVersion}
            """.trimIndent()
            )
        }

    }
}