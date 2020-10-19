package io.ciriti.ceres

import org.gradle.api.Task
import org.gradle.testfixtures.ProjectBuilder
import org.gradle.testkit.runner.GradleRunner
import org.gradle.testkit.runner.TaskOutcome
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import java.io.File
import io.ciriti.ceres.Constants.CREATE_PODSPEC_TASK
import io.ciriti.ceres.Constants.PLUGIN_GROUP_CERES
import io.ciriti.ceres.Constants.PLUGIN_ID

class KmmFrameworkPluginTest {

    @get:Rule
    var testProjectDir = TemporaryFolder()
    private lateinit var buildFile: File
    private lateinit var gradleRunner: GradleRunner

    private val project by lazy { ProjectBuilder.builder().build() }
    private val gradleRunner4Project by lazy {
        GradleRunner.create()
            .withPluginClasspath()
            .withDebug(true)
            .withProjectDir(project.rootProject.projectDir)
    }


    @Before
    fun setup() {
        buildFile = testProjectDir.newFile("build.gradle")

        // add common configuration for all tests in this class
        buildFile.appendText(
            """
                plugins {
                    id 'java'                      // `code-lines` plugin is dependent on `java` plugin
                    id 'io.github.ciriti.ceres'
                }
            """.trimIndent()
        )

        gradleRunner = GradleRunner.create()
            .withPluginClasspath()
            .withProjectDir(testProjectDir.root)
            .withTestKitDir(testProjectDir.newFolder())
    }

    @Test
    fun `check test setup`() {
        val result = gradleRunner
            .withArguments("createPodspec")
            .build()

        assertTrue(testProjectDir.root.resolve("build/ios_artifacts/generated/xcode-frameworks-unspecified/RickAndMortyData.podspec").exists())

        assertEquals(TaskOutcome.SUCCESS, result.task(":createPodspec")!!.outcome)
    }

    @Test
    fun `GIVEN a plugin CHECK the group of its task {codeLines}`() {
        project.buildFile.apply {
            createNewFile()
            appendText("build.gradle.txt".readResourceFileContent())
        }
        project.pluginManager.apply(PLUGIN_ID)
        assertTrue(
            project.pluginManager
                .hasPlugin(PLUGIN_ID)
        )
        val task: Task = project.tasks.getByName(CREATE_PODSPEC_TASK)
        assertEquals(PLUGIN_GROUP_CERES, task.group)

        val res = gradleRunner4Project
            .withArguments(CREATE_PODSPEC_TASK)
            .build()

//        assertTrue(res.output.contains("Hello from CodeLinesCounterPlugin"))
        assertTrue(project.getPodspecFile("RickAndMortyData.podspec").exists())
        assertEquals(TaskOutcome.SUCCESS, res.task(":$CREATE_PODSPEC_TASK")!!.outcome)

    }

}