plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.anselmoalexandre.api"

    compileSdk = libs.versions.compileSdk.get().toInt()

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_19
        targetCompatibility = JavaVersion.VERSION_19
    }

    kotlinOptions {
        jvmTarget = "19"
    }
}

dependencies {
    implementation(libs.hilt)
    ksp(libs.hilt.compiler)

    implementation(libs.bundles.retrofit)

    implementation(libs.bundles.moshi)
    ksp(libs.moshi.codegen)

    implementation(libs.androidx.core.ktx)
}