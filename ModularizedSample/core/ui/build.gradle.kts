@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.modularizedsample.android.library)
    alias(libs.plugins.modularizedsample.android.library.compose)
}

android {
    namespace = "br.com.globalbyte.sample.and.modularizedsample.core.ui"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {

    /*api(libs.androidx.core.ktx)
    api(libs.bundles.compose)

    debugApi(libs.androidx.compose.ui.tooling)*/

    implementation(projects.core.designsystem)
    implementation(projects.core.model)

}