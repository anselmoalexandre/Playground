plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.anselmoalexandre.data"

    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_19
        targetCompatibility = JavaVersion.VERSION_19
    }

    kotlinOptions {
        jvmTarget = "19"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(project(path = ":core:api"))
    implementation(project(path = ":core:storage"))
    testImplementation(project(path = ":core:base-testing"))

    implementation(libs.hilt)
    ksp(libs.hilt.compiler)
}