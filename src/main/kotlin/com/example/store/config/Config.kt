package com.example.store.config
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

import org.springframework.web.client.RestTemplate
import java.time.Duration

@Component
@Configuration
class Config {

    @Bean
    fun getRestTemplate(): RestTemplate = RestTemplateBuilder()
        .setConnectTimeout(Duration.ofSeconds(10))
        .build()

}

