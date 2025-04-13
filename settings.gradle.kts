pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
gradle.settingsEvaluated {
    val githubUsername =
        settings.extra["GITHUB_USERNAME"] as? String ?: System.getenv("GITHUB_USERNAME")
    val githubToken = settings.extra["GITHUB_TOKEN"] as? String ?: System.getenv("GITHUB_TOKEN")

    val authMavenUrl: String? = providers.gradleProperty("GITHUB_AUTH_MAVEN_URL").orNull
    val tripMavenUrl: String? = providers.gradleProperty("GITHUB_TRIP_MAVEN_URL").orNull
    val trackingMavenUrl: String? = providers.gradleProperty("GITHUB_TRACKING_MAVEN_URL").orNull

    dependencyResolutionManagement {
        repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
        repositories {
            google()
            mavenCentral()

            maven {
                name = "rider-auth"
                url = uri(authMavenUrl ?: System.getenv("GITHUB_AUTH_MAVEN_URL"))
                credentials {
                    username = githubUsername
                    password = githubToken
                }
            }

            maven {
                name = "rider-trip"
                url = uri(tripMavenUrl ?: System.getenv("GITHUB_TRIP_MAVEN_URL"))
                credentials {
                    username = githubUsername
                    password = githubToken
                }
            }

            maven {
                name = "rider-tracking"
                url = uri(trackingMavenUrl ?: System.getenv("GITHUB_TRACKING_MAVEN_URL"))
                credentials {
                    username = githubUsername
                    password = githubToken
                }
            }
        }
    }
}

rootProject.name = "RiderTrackingApp"
include(":app")
