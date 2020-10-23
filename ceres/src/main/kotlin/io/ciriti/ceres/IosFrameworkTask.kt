package io.ciriti.ceres

import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import javax.inject.Inject

open class IosFrameworkTask @Inject constructor(
    private val extension: KmmExtension
) : IosFrameworkBaseTask() {
    // <1>
    @Input var message: String = ""
    @Input var recipient: String = "-"
    @Input var recipient2: String = "-"

    override fun execute() {
        println("============================================================")
        System.out.printf("%s, %s and %s! \n", message, recipient, recipient2)
        System.out.printf("%s\n", extension.name)
        println("============================================================")

    }
}