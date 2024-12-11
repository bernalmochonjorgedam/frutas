plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.naxer.almacenimiento"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.naxer.almacenimiento"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.room.runtime) // Implementación de Room
    annotationProcessor(libs.room.compiler) // Procesador de anotaciones para Room
    implementation(libs.material) // Material Components
    implementation(libs.appcompat) // Compatibilidad con versiones anteriores
    implementation(libs.constraintlayout) // Layouts con ConstraintLayout
    implementation(libs.navigation.fragment) // Navegación de fragmentos
    implementation(libs.navigation.ui) // Navegación de interfaz de usuario
    testImplementation(libs.junit) // Pruebas unitarias
    androidTestImplementation(libs.ext.junit) // Pruebas instrumentadas
    androidTestImplementation(libs.espresso.core) // Pruebas de UI
    implementation(libs.recyclerview) // RecyclerView
}

