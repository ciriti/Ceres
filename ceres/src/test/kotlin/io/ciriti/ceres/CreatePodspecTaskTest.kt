package io.ciriti.ceres

import org.gradle.testfixtures.ProjectBuilder
import org.gradle.testkit.runner.GradleRunner
import org.gradle.testkit.runner.TaskOutcome
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.io.File

class CreatePodspecTaskTest{

    private val project by lazy {
        ProjectBuilder.builder()
            .build()
    }
    private val gradleRunner by lazy {
        GradleRunner.create()
            .withPluginClasspath()
            .withDebug(true)
            .withProjectDir(project.rootProject.projectDir)
    }

    @Before
    fun setup(){
        project.buildFile.apply {
            createNewFile()
            appendText("build.gradle.txt".readResourceFileContent())
        }
    }

    @Test
    fun `GIVEN a plugin CHECK the group of its task {codeLines}`() {

        val res = gradleRunner
            .withArguments(Constants.CREATE_PODSPEC_TASK)
            .build()

        Assert.assertTrue(project.getPodspecFile("RickAndMortyData.podspec").exists())
        Assert.assertEquals(TaskOutcome.SUCCESS, res.task(":${Constants.CREATE_PODSPEC_TASK}")!!.outcome)

    }

    @Test
    fun `GIVEN a MPP project CHECK the number of lines`(){
        // project.pluginManager.apply("kotlin-multiplatform")
        project.version = "1.0-SNAPSHOOT"
        project.buildDir = "build".getResourceFolderByName()
        val frameworkDir = project.getFrameworkDir().apply { mkdirs() }
        "LICENSE".getResourceFileByName()
            .copyTo(File("$frameworkDir/LICENSE"), overwrite = true)

        project.getLicenseFile().exists().assertTrue()
        // val res = project.mkdir("${project.buildDir.path}/ios_artifacts/generated/xcode-frameworks-${project.version}")
        // val framework = kotlin.targets.ios.binaries.getFramework("RickAndMortyData", mode)
        // println("=========== framework:" + framework)
        // println("=========== framework.outputFile.parentFile:" + framework.outputFile.parentFile)
    }

}

