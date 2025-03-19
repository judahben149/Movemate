import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.judahben149.movemate"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.judahben149.movemate"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    signingConfigs {
        getByName("debug"){
            val secretProps = Properties()
            val secretPropsFile = rootProject.file("secrets.properties")

            if (secretPropsFile.exists()) {
                secretProps.load(FileInputStream(secretPropsFile))

                storeFile = file(secretProps.getProperty("keystore.file"))
                storePassword = secretProps.getProperty("keystore.password")
                keyAlias = secretProps.getProperty("keystore.key.alias")
                keyPassword = secretProps.getProperty("keystore.key.password")
            } else {
                storeFile = file("debug.keystore")
                storePassword = "android"
                keyAlias = "androiddebugkey"
                keyPassword = "android"
            }
        }

        create("release") {
                val secretProps = Properties()
                val secretPropsFile = rootProject.file("secrets.properties")

                if (secretPropsFile.exists()) {
                    secretProps.load(FileInputStream(secretPropsFile))

                    storeFile = file(secretProps.getProperty("keystore.file"))
                    storePassword = secretProps.getProperty("keystore.password")
                    keyAlias = secretProps.getProperty("keystore.key.alias")
                    keyPassword = secretProps.getProperty("keystore.key.password")
                } else {
                    storeFile = file("debug.keystore")
                    storePassword = "android"
                    keyAlias = "androiddebugkey"
                    keyPassword = "android"
                }
            }
    }

    buildTypes {
        debug {
            isDebuggable = true
            signingConfigs.getByName("debug")
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-debug"
        }

        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
            signingConfigs.getByName("release")
        }
    }
    compileOptions {
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
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.constraintlayout.compose.android)

    // Hilt
//    implementation(libs.hilt.android)
//    ksp(libs.hilt.compiler)
//    implementation(libs.androidx.hilt.navigation.compose)

    // Splash screen
    implementation(libs.androidx.core.splashscreen)

    // Coil Image loading library
    implementation(libs.coil.compose)


    // Test implementation
    testImplementation(libs.junit)

    // Instrumentation testing
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)

    // Debug
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}