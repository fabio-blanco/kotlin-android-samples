@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.modularizedsample.android.feature)
    alias(libs.plugins.modularizedsample.android.library.compose)
}

android {
    namespace = "br.com.globalbyte.sample.and.modularizedsample.feature.home"
}

dependencies {

}