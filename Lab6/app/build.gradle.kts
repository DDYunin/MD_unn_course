plugins {
    id("com.android.application")
    id("kotlin-kapt")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.lab6"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.lab6"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("com.google.devtools.ksp:symbol-processing-api:1.8.0-1.0.9")
    //=================== Data Base Support =========================
    implementation("androidx.room:room-runtime:2.2.4")
    implementation("androidx.room:room-common:2.2.4")
    implementation("androidx.room:room-ktx:2.2.4")
    annotationProcessor("androidx.room:room-compiler:2.2.4")
//
//    // To use Kotlin annotation processing tool (kapt)
    kapt("androidx.room:room-compiler:2.2.4")
//    // To use Kotlin Symbol Processing (KSP)
//    ksp("androidx.room:room-compiler:2.2.4")
    //===============================================================

    //=================== Http lib support ==========================
    implementation("com.squareup.okhttp3:okhttp:4.10.0")
    //===============================================================

    //=================== Store App Settings ========================
    implementation("androidx.datastore:datastore-preferences:1.0.0")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.1")
    //===============================================================

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}