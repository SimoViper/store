package com.example.movies.movies

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.web.client.RestTemplate

@SpringBootApplication
@EntityScan("com.example.store.entity")
@EnableJpaRepositories("com.example.store.repository")
@ComponentScan(basePackages = ["com.example.store"])
class StoreApplication

fun main(args: Array<String>) {
	runApplication<StoreApplication>(*args)
}

