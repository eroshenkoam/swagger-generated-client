import org.openapitools.generator.gradle.plugin.extensions.OpenApiGeneratorGenerateExtension

buildscript {
    repositories {
        mavenCentral()
    }

    dependencies {
        classpath("org.openapitools:openapi-generator-gradle-plugin:3.3.3")
    }
}

tasks.existing(Wrapper::class) {
    gradleVersion = "4.10.2"
    distributionType = Wrapper.DistributionType.ALL
}

plugins {
    id("java")
}

apply(plugin = "org.openapi.generator")

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8

    sourceSets["main"].java {
        srcDir("build/generated-retrofit2/src/main/java")
    }
}

tasks.withType(JavaCompile::class) {
    options.encoding = "UTF-8"
}

configure(allprojects) {
    group = "io.eroshenkoam.swagger"
    version = version
}

repositories {
    mavenCentral()
}

dependencies {
    compile("com.squareup.retrofit2:retrofit:2.4.0")
}

configure<OpenApiGeneratorGenerateExtension> {
    generatorName.set("java")
    library.set("retrofit2")
    inputSpec.set(project.rootDir.resolve("src/main/resources/petstore-v3.0.yaml").toString())
    outputDir.set(project.buildDir.resolve("generated-retrofit2").toString())
    apiPackage.set("org.openapitools.example.api")
    modelPackage.set("org.openapitools.example.model")
    invokerPackage.set("org.openapitools.example.invoker")
}
