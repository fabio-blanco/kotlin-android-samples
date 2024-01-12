package br.com.globalbyte.sample.and.modularizedsample.buildlogic.convention

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

val Project.libs
    get(): VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")

val Project.compileSdkVersion
    get(): Int = libs.findVersion("compileSdk").get().toString().toInt()

val Project.targetSdkVersion
    get(): Int = libs.findVersion("targetSdk").get().toString().toInt()

val Project.minSdkVersion
    get(): Int = libs.findVersion("minSdk").get().toString().toInt()