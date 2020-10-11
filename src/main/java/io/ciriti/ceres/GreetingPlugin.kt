package io.ciriti.ceres

import org.gradle.api.Plugin
import org.gradle.api.Project

class GreetingPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.tasks.create("hello", Greeting::class.java) { task: Greeting ->  // <1>
            task.message = "Hello"
            task.recipient = "World" // <2>
        }
    }
}