package com.example.store.repository

import com.example.store.entity.Rental
import org.springframework.data.repository.CrudRepository
import java.util.*

interface RentalRepository : CrudRepository<Rental, Long> {
    fun save(inventory: Rental): Rental
    fun findByCustomerId(customerId: Long) : List<Rental>
    override fun findById(rentalId: Long) : Optional<Rental>
}