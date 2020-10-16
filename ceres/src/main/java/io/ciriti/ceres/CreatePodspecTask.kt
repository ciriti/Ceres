package io.ciriti.ceres

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Exec
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import java.io.File

open class CreatePodspecTask : IosFrameworkBaseTask() {

    @Input
    lateinit var ext : KmmExtension

    override fun execute() {
        val frameworkDir = File("${project.buildDir}/ios_artifacts/generated", "xcode-frameworks-${project.version}")
        if(!frameworkDir.exists()) frameworkDir.mkdirs()
        File(frameworkDir, "RickAndMortyData.podspec").apply {
            writeText(
                text = """
                    Pod::Spec.new do |s|
                        s.name              = 'RickAndMortyData'
                        s.version           = '${project.version}'
                        s.summary           = 'The datalayer for the RickAndMorty app'
                        s.homepage          = 'https://github.com/ciriti/RepoArtifacts/'

                        s.author            = { 'Name' => 'ciriti@gmail.com' }
                        s.license           = { :type => 'Apache-2.0', :file => 'LICENSE' }

                        s.platform          = :ios, '9.0' //TO REMOVE ${ext.name}
                        s.source            = { :http => 'https://github.com/ciriti/RepoArtifacts/blob/master/RickAndMortyData_${project.version}.zip?raw=true' }

                        s.ios.deployment_target = '13.5'
                        s.ios.vendored_frameworks = 'RickAndMortyData.framework'
                    end
                    """.trimIndent()
            )
        }.createNewFile()
    }

}