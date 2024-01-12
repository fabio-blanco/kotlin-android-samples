@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    //alias(libs.plugins.com.android.application)
    //alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.modularizedsample.android.application)
    alias(libs.plugins.modularizedsample.android.application.compose)
    alias(libs.plugins.modularizedsample.android.hilt)
}

android {
    namespace = "br.com.globalbyte.sample.and.modularizedsample"
//    compileSdk = 33

    defaultConfig {
        applicationId = "br.com.globalbyte.sample.and.modularizedsample"
//        minSdk = 24
//        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    /*compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }*/
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(projects.core.designsystem)

    implementation(projects.feature.home)
    implementation(projects.feature.note)
    implementation(projects.feature.check)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    // ---
//    implementation(platform(libs.androidx.compose.bom))
//    implementation(libs.androidx.compose.ui)
//    implementation(libs.androidx.compose.ui.graphics)
//    implementation(libs.androidx.compose.ui.tooling.preview)
//    implementation(libs.androidx.compose.material3)
    // ---
    implementation(libs.androidx.navigation.compose)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    // ---
//    androidTestImplementation(platform(libs.androidx.compose.bom))
    // ---
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.navigation.testing)
    // ---
//    debugImplementation(libs.androidx.compose.ui.tooling)
    // ---
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}