package ru.vood.coroutines.highload.configuration

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

import java.time.Duration
//import io.ktor.client.*
//import io.ktor.client.engine.cio.*



@Configuration
class RestConfiguration {
    @Bean
    fun restTemplate(builder: RestTemplateBuilder): RestTemplate = builder
        .setConnectTimeout(Duration.ofMillis(3000))
        .setReadTimeout(Duration.ofMillis(3000))
        .build()


//    val client = HttpClient()
    fun ktorClient() {

//    HttpClient()
//        val client = HttpClient.newBuilder().build();
//        val request = HttpRequest.newBuilder()
//            .uri(URI.create("http://webcode.me"))
//            .build();
//
//        val response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        println(response.body())
//
//        return client
        TODO()
    }
}