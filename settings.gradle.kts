rootProject.name = "My application"

include(":androidApp")
include(":shared")

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
    }

    plugins {
        val kotlinVersion = extra["kotlin.version"] as String
        val agpVersion = extra["agp.version"] as String
        val composeVersion = extra["compose.version"] as String

        kotlin("jvm").version(kotlinVersion)
        kotlin("multiplatform").version(kotlinVersion)
        kotlin("android").version(kotlinVersion)

        id("com.android.application").version(agpVersion)
        id("com.android.library").version(agpVersion)

        id("org.jetbrains.compose").version(composeVersion)
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven {
            val credentials = createCredentials()
            url = uri("https://maven.pkg.github.com/nanit/nanit.mobile.infra")
            println("gained access to $url")
            credentials {
                username = credentials.first
                password = credentials.second
            }
        }
    }
}

fun createCredentials(): Pair<String, String> {
    var actor = providers.gradleProperty("gpr.user").orNull ?: System.getenv("GITHUB_ACTOR")
    var token = providers.gradleProperty("gpr.token").orNull ?: System.getenv("GITHUB_TOKEN")
    val projectPropsFile = File(rootDir.path + "/nanit.properties")

    if ((actor == null || token == null) && projectPropsFile.exists()) {
        val props = java.util.Properties()
        props.load(java.io.FileInputStream(projectPropsFile))

        actor = props["GPR_ACTOR"] as? String
        token = props["GPR_TOKEN"] as? String
    }

    if (actor == null || token == null) {
        throw GradleException("Github Access token required to build Nanit apps")
    }

    println("gained access for: $actor")

    return actor to token
}
