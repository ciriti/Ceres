package io.ciriti.ceres

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

open class Greeting : DefaultTask() {
    // <1>
    @Input var message: String = ""
    @Input var recipient: String = "-"
    @Input var recipient2: String = "-"

    @TaskAction
    fun sayGreeting() {
        System.out.printf("%s, %s and %s! \n", message, recipient, recipient2) // <2>
    }
}