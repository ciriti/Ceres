package io.ciriti.ceres

import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.tasks.TaskAction

open abstract class IosFrameworkBaseTask : DefaultTask(){

    companion object{
        const val GROUP = "kmmFramework"
        const val DESCRIPTION = "Creating an ios framework"
    }

    init {
        group = GROUP
        description = DESCRIPTION
    }

    abstract fun execute()

    @TaskAction
    fun start(){
        try {
            execute()
        }catch (e : Throwable){
            throw GradleException(e.message?:"", e)
        }
    }
}