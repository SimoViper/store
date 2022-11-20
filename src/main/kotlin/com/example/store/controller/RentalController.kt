package com.example.store.controller

import com.example.store.model.*
import com.example.store.service.FilmService
import com.example.store.service.PaymentService
import com.example.store.service.RentalService
import lombok.AllArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.web.bind.annotation.*

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/store")
class RentalController(
    private val filmService: FilmService,
    private val rentalService: RentalService,
    private val paymentService: PaymentService
) {

    @GetMapping("/film")
    fun search(
        @RequestParam(required = false, name = "title") title: String?,
        @RequestParam(required = false, name = "category") category: String?,
        @RequestParam(required = false, name = "actor_name") actorFirstName: String?,
        @RequestParam(required = false, name = "actor_surname") actorLastName: String?
    ): List<Film> {

        return filmService.findFilms(title, category, actorFirstName, actorLastName)
    }

    @PostMapping("/rent")
    fun rent(@RequestBody rentalRequest: RentalRequest): RentalResponse {
        return RentalResponse(rentals = rentalService.rentFilm(rentalRequest))
    }

    @PostMapping("/payment")
    fun payment(@RequestBody paymentRequest: PaymentRequest): PaymentResponse {
        return paymentService.createPayment(paymentRequest)
    }

    @GetMapping("/rent/customer/{customer_id}")
    fun getRentals(
        @PathVariable(name = "customer_id") customerId: Long
    ): RentalResponse {

        return RentalResponse(rentalService.getRentalsByCustomer(customerId))
    }

}