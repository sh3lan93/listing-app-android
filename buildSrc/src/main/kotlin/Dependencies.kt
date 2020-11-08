object Dependencies {

    val gradle_classpath = "com.android.tools.build:gradle:${Versions.gradle_version}"

    val kotlin_gradle_plugin_classpath =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin_version}"

    val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin_version}"

    val app_compact = "androidx.appcompat:appcompat:${Versions.app_compact}"

    val core_ktx = "androidx.core:core-ktx:${Versions.core_ktx}"

    val junit = "junit:junit:${Versions.junit}"

    val androidx_test_junit = "androidx.test.ext:junit:${Versions.androidx_test_junit}"

    val androidx_espresso = "androidx.test.espresso:espresso-core:${Versions.androidx_espresso}"

    val constraint_layout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"

    val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"

    val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"

    val lifecycle_annotations = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"


    val chuckerDebug = "com.github.chuckerteam.chucker:library:${Versions.chuckerVersion}"

    val chuckerRelease = "com.github.chuckerteam.chucker:library-no-op:${Versions.chuckerVersion}"

    val hyperion = "com.willowtreeapps.hyperion:hyperion-core:${Versions.hyperion}"

    val hyperionSharedPreferences =
        "com.willowtreeapps.hyperion:hyperion-shared-preferences:${Versions.hyperion}"

    val hyperionRelease = "com.willowtreeapps.hyperion:hyperion-core-no-op:${Versions.hyperion}"

    val hyperionCrash = "com.willowtreeapps.hyperion:hyperion-crash:${Versions.hyperion}"

    val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"

    val googleMaterial = "com.google.android.material:material:${Versions.googleMaterial}"

    val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"

    val navigation_component =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation_component}"

    val navigation_component_ui =
        "androidx.navigation:navigation-ui-ktx:${Versions.navigation_component}"

    val activity_ktx = "androidx.activity:activity-ktx:${Versions.activity_ktx}"

    val swipeToRefresh = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeToRefresh}"

    val kotlinx_coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinx_corotunies}"

    val safe_args_classpath =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation_component}"
}
