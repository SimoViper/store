package com.example.store.controller

import com.example.store.model.Film
import com.example.store.model.PaymentRequest
import com.example.store.model.RentalRequest
import com.example.store.model.RentalResponse
import com.example.store.service.FilmService
import com.example.store.service.RentalService
import lombok.AllArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.web.bind.annotation.*

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/store")
class RentalController (private val filmService: FilmService,
private val rentalService: RentalService){

    @GetMapping("/film")
    fun search(@RequestParam(required = false, name = "title") title: String?,
                 @RequestParam(required = false, name = "category") category: String?,
                 @RequestParam(required = false, name = "actor_name") actorFirstName: String?,
                 @RequestParam(required = false, name = "actor_surname") actorLastName: String?): List<Film> {

        return filmService.findFilms(title, category, actorFirstName, actorLastName)
    }

    @PostMapping("/rent")
    fun rent(@RequestBody rentalRequest:RentalRequest): RentalResponse {
        return RentalResponse(rentals = rentalService.rentFilm(rentalRequest))
    }

    @PostMapping("/payment")
    fun payment(@RequestBody paymentRequest: PaymentRequest): String {
        return "OK"
    }

}