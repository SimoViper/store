package com.example.store.model

import java.math.BigDecimal
import java.util.*

class Film (
    var filmId: Long,
    var title: String?,
    var description: String?,
    var releaseYear: Date?,
    var language: String?,
    var rentalDuration: Int,
    var rentalRate: BigDecimal?,
    var actors: List<String>?,
    var categories: List<String>?
)