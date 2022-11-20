package com.example.store.model

import com.fasterxml.jackson.annotation.JsonInclude
import java.util.Date

@JsonInclude(JsonInclude.Include.NON_NULL)
class RentalDTO(
    var rentalId: Long?,
    var rentalDate: Date?,
    var filmId: Long?,
    var storeId: Long?,
    var returnDate: Date?,
    var employeeId: Long?
) {
    constructor(
        rentalId: Long?,
        returnDate: Date?
    ) : this(
        rentalId = rentalId,
        rentalDate = null,
        filmId = null,
        storeId = null,
        returnDate = returnDate,
        employeeId = null
    )
}