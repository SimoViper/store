package com.example.store.repository

import com.example.store.entity.Rental
import org.springframework.data.repository.CrudRepository

interface RentalRepository : CrudRepository<Rental, Long> {
    fun save(inventory: Rental): Rental
}