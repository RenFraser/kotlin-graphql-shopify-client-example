package org.example

import com.expediagroup.graphql.client.spring.GraphQLWebClient
import kotlinx.coroutines.runBlocking
import org.springframework.web.reactive.function.client.WebClient

fun main() {

    // You can also pass in an existing web client.
    // See: https://opensource.expediagroup.com/graphql-kotlin/docs/client/client-customization/#global-client-customization-1

    val webClientBuilder = WebClient
        .builder()
        .defaultHeader("X-Shopify-Access-Token", "your-access-token-here")

    val client = GraphQLWebClient(
        url = "https://your-myshopify-domain-here/admin/api/unstable/graphql.json",
        builder = webClientBuilder
    )

    runBlocking {
        val shopQuery = ShopQuery()
        val result = client.execute(shopQuery)

        val errors = result.errors ?: listOf()

        if (errors.isNotEmpty()) {
            println(errors)
        }

        val shop = checkNotNull(result.data?.shop)

        println(shop.id)
        println(shop.name)
    }
}