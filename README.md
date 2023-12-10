# Kotlin GraphQL Shopify Client Example

An example client written in Kotlin that calls Shopify.

The only thing you need to do is write your queries as graphql files and then execute them. 
Super simple.

## Getting Started

### Running

1. Run the `assemble` task. This will generate the schema under `build/schema.graphql`.
2. Copy your myshopify domain and app's access token to `Main.kt` and `build.gradle.kts`
3. Run and view the output.

### Writing 

If you want to add more queries, you'll want introspection.

Run the *assemble* task then copy or move `build/schema.graphql` to `src/main/resources`.