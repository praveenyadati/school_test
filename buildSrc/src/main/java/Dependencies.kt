import org.gradle.api.artifacts.dsl.DependencyHandler

object AndroidLibraries {
    private object Versions {
        const val jetpack = "1.6.1"
        const val constraintLayout = "1.1.3"
        const val ktx = "1.6.0"
        const val nav_version = "2.5.0"
    }

    private const val appCompat = "androidx.appcompat:appcompat:${Versions.jetpack}"
    private const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    private const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"
    private const val refresh = "androidx.swiperefreshlayout:swiperefreshlayout:1.0.0"

    private const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.nav_version}"
    private const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.nav_version}"

    private const val navDynamic = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.nav_version}"

    val dependencies = arrayListOf<String>().apply {
        add(ktxCore)
        add(appCompat)
        add(constraintLayout)
        add(refresh)
        add(navigationFragment)
        add(navigationUI)
        add(navDynamic)
    }
}

object NetworkLibraries {
    private object Versions {
        const val retrofit = "2.9.0"
        const val loggerVersion = "4.11.0"
    }

    private const val retrofitCore = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    private const val retrofitConvertGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    private const val logger = "com.squareup.okhttp3:logging-interceptor:${Versions.loggerVersion}"

    val dependencies = arrayListOf<String>().apply {
        add(retrofitCore)
        add(retrofitConvertGson)
        add(logger)
    }
}

//util functions for adding the different type dependencies from build.gradle file

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

