package io.ciriti.ceres.dsl

import io.ciriti.ceres.IosFrameworkTask
import org.gradle.api.tasks.TaskContainer
import org.gradle.api.tasks.TaskProvider

val TaskContainer.frameworkTask : TaskProvider<IosFrameworkTask>
get() = named("framework", IosFrameworkTask::class.java)