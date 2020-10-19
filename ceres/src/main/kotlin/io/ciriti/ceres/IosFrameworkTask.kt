package io.ciriti.ceres

import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

open class IosFrameworkTask : IosFrameworkBaseTask() {
    // <1>
    @Input var message: String = ""
    @Input var recipient: String = "-"
    @Input var recipient2: String = "-"

    @Input var extension : KmmExtension? = null

    override fun execute() {
        extension?: kotlin.run { throw RuntimeException("Porcodio") }
        System.out.printf("%s, %s and %s! \n", message, recipient, recipient2) // <2>
        System.out.printf("%s, %s and %s! \n", message, recipient, recipient2) // <2>
        System.out.printf("%s, %s and %s! \n", message, recipient, recipient2) // <2>
        System.out.printf("%s, %s and %s! \n", message, recipient, recipient2) // <2>
        System.out.printf("%s, %s and %s! \n", message, recipient, recipient2) // <2>
        System.out.printf("%s, %s and %s! \n", message, recipient, recipient2) // <2>
        System.out.printf("%s, %s and %s! \n", message, recipient, recipient2) // <2>
    }
}