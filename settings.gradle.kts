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
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
	    maven {
            url = uri("https://maven.pkg.github.com/tribalfs/sesl-androidx")
            credentials {
                username = "Bohdan157"
                password = "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"
            }
        }
        maven {
            url = uri("https://maven.pkg.github.com/tribalfs/sesl-material-components-android")
            credentials {
                username = "Bohdan157"
                password = "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"
            }
        }
    }
}

include(":lib")

rootProject.name = "My Application"
include(":app")
 