package io.ciriti.ceres

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class GreetingPluginTest{
    @Test
    fun greetingTest() {
        val project: Project = ProjectBuilder.builder().build()
        project.pluginManager.apply("io.github.ciriti.ceres")
        assertTrue(
            project.pluginManager
                .hasPlugin("io.github.ciriti.ceres")
        )
        assertNotNull(project.tasks.getByName("hello"))
    }
}