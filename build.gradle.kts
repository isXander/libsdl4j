plugins {
    `java-library`
    `maven-publish`
}

val sdlVersion = "2.28.2"

group = "io.github.libsdl4j"
version = sdlVersion + "-" + (System.getenv("GITHUB_RUN_NUMBER") ?: "local")

java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
}

dependencies {
    api("net.java.dev.jna:jna:5.13.0")
    api("org.jetbrains:annotations:23.0.0")
    api("org.slf4j:slf4j-api:1.7.36")

    testImplementation("org.junit.jupiter:junit-jupiter:5.7.2")
    testImplementation("net.java.dev.jna:jna-platform:5.11.0")
    testImplementation("ch.qos.logback:logback-classic:1.2.11")
}

java {
    withSourcesJar()
    withJavadocJar()
}

tasks {
    test {
        useJUnitPlatform()
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc> {
    options.encoding = "UTF-8"
}

val cloneSDLRepo by tasks.registering(Exec::class) {
    group = "natives"

    commandLine("git", "clone", "--depth", "1", "--branch", "release-$sdlVersion", "https://github.com/libsdl-org/SDL.git", "SDL")
}

publishing {
    repositories {
        val username = "XANDER_MAVEN_USER".let { System.getenv(it) ?: findProperty(it) }?.toString()
        val password = "XANDER_MAVEN_PASS".let { System.getenv(it) ?: findProperty(it) }?.toString()
        if (username != null && password != null) {
            maven(url = "https://maven.isxander.dev/releases") {
                name = "XanderReleases"
                credentials {
                    this.username = username
                    this.password = password
                }
            }
        } else {
            println("Xander Maven credentials not satisfied.")
        }
    }

    publications {
        create<MavenPublication>("javaLibrary") {
            artifact(tasks.jar.get())
            artifact(tasks["sourcesJar"])
            artifact(tasks["javadocJar"])

            groupId = "dev.isxander"
            artifactId = "libsdl4j"
        }

        create<MavenPublication>("natives") {
            val nativesPaths = project.files(
                "libs/natives/windows32",
                "libs/natives/windows64",
                "libs/natives/linux64",
                "libs/natives/macosx64",
                "libs/natives/macosxarm64",
            )
            for (nativeFolder in nativesPaths) {
                if (!nativeFolder.exists())
                    continue

                for (nativeFile in nativeFolder.listFiles() ?: emptyArray()) {
                    artifact(nativeFile) {
                        classifier = nativeFolder.nameWithoutExtension.substringAfterLast('-')
                    }
                }
            }

            groupId = "dev.isxander"
            artifactId = "libsdl4j-natives"
        }
    }
}
