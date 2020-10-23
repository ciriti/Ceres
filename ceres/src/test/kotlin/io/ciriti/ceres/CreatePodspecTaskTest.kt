package io.ciriti.ceres

import org.gradle.testkit.runner.GradleRunner
import org.gradle.testkit.runner.TaskOutcome
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import java.io.File

class CreatePodspecTaskTest{

    private val version = "1.0-SNAPSHOOT"

    @Rule
    @JvmField
    val testProjectDir: TemporaryFolder = TemporaryFolder()

    private val gradleRunner: GradleRunner by lazy {
        GradleRunner.create()
            .withDebug(true)
            .withPluginClasspath()
            .withProjectDir(testProjectDir.root)
            .withTestKitDir(testProjectDir.newFolder())
    }

    @Before
    fun setup(){
        testProjectDir
            .buildFile
            .appendText("build.gradle.txt".readResourceFileContent())
    }

    @Test
    fun `GIVEN a plugin CHECK the group of its task {codeLines}`() {

        val res = gradleRunner
            .withArguments(Constants.CREATE_PODSPEC_TASK)
            .build()

        Assert.assertTrue(testProjectDir.getPodspecFile("RickAndMortyData.podspec", "1.0-SNAPSHOOT").exists())
        Assert.assertEquals(TaskOutcome.SUCCESS, res.task(":${Constants.CREATE_PODSPEC_TASK}")!!.outcome)

    }

    @Test
    fun `GIVEN a MPP project CHECK the number of lines`(){
        val frameworkDir = testProjectDir.getFrameworkDir(version).apply { mkdirs() }
        "LICENSE".getResourceFileByName()
            .copyTo(File("$frameworkDir/LICENSE"), overwrite = true)

        testProjectDir.getLicenseFile(version).exists().assertTrue()
        // val res = project.mkdir("${project.buildDir.path}/ios_artifacts/generated/xcode-frameworks-${project.version}")
        // val framework = kotlin.targets.ios.binaries.getFramework("RickAndMortyData", mode)
        // println("=========== framework:" + framework)
        // println("=========== framework.outputFile.parentFile:" + framework.outputFile.parentFile)
    }


    @Test
    fun `check extension`() {

        val result = gradleRunner
            .withArguments(Constants.CREATE_PODSPEC_TASK)
            .build()

        testProjectDir.getPodspecFile("RickAndMortyData.podspec", version).exists().assertTrue()

        println(testProjectDir.getPodspecFile("RickAndMortyData.podspec", version).readText())

        Assert.assertEquals(TaskOutcome.SUCCESS, result.task(":${Constants.CREATE_PODSPEC_TASK}")!!.outcome)
    }

}

