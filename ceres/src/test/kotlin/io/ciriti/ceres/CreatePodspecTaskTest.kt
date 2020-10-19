package io.ciriti.ceres

import org.gradle.testfixtures.ProjectBuilder
import org.gradle.testkit.runner.GradleRunner
import org.gradle.testkit.runner.TaskOutcome
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class CreatePodspecTaskTest{

    private val project by lazy { ProjectBuilder.builder().build() }
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
            appendText("build.gradle.txt".readFileContent())
        }
    }

    @Test
    fun `GIVEN a plugin CHECK the group of its task {codeLines}`() {

        val res = gradleRunner
            .withArguments(Constants.CREATE_PODSPEC_TASK)
            .build()

        Assert.assertTrue(project.getPodspecPath("RickAndMortyData.podspec").exists())
        Assert.assertEquals(TaskOutcome.SUCCESS, res.task(":${Constants.CREATE_PODSPEC_TASK}")!!.outcome)

    }

}

