@file:JvmName("TestUtils")
@file:Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")

package io.ciriti.ceres

import org.gradle.api.Project
import org.gradle.internal.impldep.org.junit.Assert
import java.io.File

/**
 * Receive file.json and return the content as string
 */
fun String.readResourceFileContent(): String = Thread.currentThread()
    .contextClassLoader
    .getResourceAsStream(this)
    .bufferedReader().use { it.readText() }
    .trimIndent()

fun String.getResourceFolderByName() : File =
    File(
        Thread.currentThread()
            .contextClassLoader
            .getResource(this)
            .file
    )

fun String.getResourceFileByName() : File =
    File(
        Thread.currentThread()
            .contextClassLoader
            .getResource(this)
            .file
    )


infix fun <T> T.assertEquals(t: T) = apply { Assert.assertEquals(t, this) }
fun <T : Boolean> T.assertTrue() = apply { Assert.assertTrue(this) }
fun <T> T?.assertNotNull(): T = apply { Assert.assertNotNull(this) }!!