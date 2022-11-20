package com.example.store.service

import com.example.store.client.MoviesClient
import com.example.store.model.Film
import org.springframework.stereotype.Service

@Service
class FilmService(private val moviesClient: MoviesClient) {


    fun findFilms(title: String?, category: String?, actorFirstName: String?, actorLastName: String?): List<Film> {
        return moviesClient.findFilms(title, category, actorFirstName, actorLastName)
    }

}
