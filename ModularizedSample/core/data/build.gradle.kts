@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.modularizedsample.android.library)
    alias(libs.plugins.modularizedsample.android.hilt)
}

android {
    namespace = "br.com.globalbyte.sample.and.modularizedsample.core.data"
}

dependencies {

    implementation(projects.core.model)

    implementation(libs.androidx.core.ktx)

}