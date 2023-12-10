import com.expediagroup.graphql.plugin.gradle.config.GraphQLScalar
import com.expediagroup.graphql.plugin.gradle.config.GraphQLSerializer
import com.expediagroup.graphql.plugin.gradle.graphql


plugins {
    kotlin("jvm") version "1.9.21"
    id("com.expediagroup.graphql") version "7.0.2"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.expediagroup:graphql-kotlin-spring-client:7.0.2")
    implementation("com.expediagroup:graphql-kotlin-schema-generator:7.0.2")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}


kotlin {
    jvmToolchain(17)
}

graphql {
    client {
        packageName = "org.example"
        endpoint = "https://your-myshopify-domain-here/admin/api/unstable/graphql.json"
        allowDeprecatedFields = true
        headers = mapOf("X-Shopify-Access-Token" to "your-shopify-access-token-here")
        customScalars = listOf(
            GraphQLScalar("Locale", "com.ibm.icu.util.ULocale", "com.expediagroup.graphql.examples.client.gradle.ULocaleScalarConverter"),
            GraphQLScalar("UUID", "java.util.UUID", "com.expediagroup.graphql.examples.client.gradle.UUIDScalarConverter"),
        )
        serializer = GraphQLSerializer.JACKSON

    }
}

tasks {
    test {
        useJUnitPlatform()
    }
}

