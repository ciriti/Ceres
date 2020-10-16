package io.ciriti.ceres

import org.gradle.api.Project
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

class KmmFrameworkPluginTest {

    @get:Rule
    var testProjectDir = TemporaryFolder()
    private lateinit var buildFile: File
    private lateinit var gradleRunner: GradleRunner

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

}