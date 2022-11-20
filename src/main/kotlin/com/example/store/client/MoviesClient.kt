package com.example.store.client

import com.example.store.model.Film
import com.example.store.model.MoviesResponse
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder

@Component
class MoviesClient(private val restTemplate: RestTemplate) {

    fun findFilms(title: String?, category: String?, actorFirstName: String?, actorLastName: String?): List<Film> {
        val url = buildHttpURL(title, category, actorFirstName, actorLastName)
        val moviesResponse: MoviesResponse? = restTemplate.getForObject(url, MoviesResponse::class.java)

        if (moviesResponse?.films != null) {
            return moviesResponse.films
        }

        return emptyList()
    }

    fun buildHttpURL(title: String?, category: String?, actorFirstName: String?, actorLastName: String?) : String{
        return UriComponentsBuilder.fromHttpUrl("http://localhost:8081/api/v1/film")
            .queryParam("title", title)
            .queryParam("category", category)
            .queryParam("actor_name", actorFirstName)
            .queryParam("actor_surname", actorLastName)
            .build(false)
            .toUriString();

    }

}