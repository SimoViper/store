package com.example.store.entity

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Rental(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var rentalId: Long?,
    var rentalDate: Date,
    var inventoryId: Long?,
    var customerId: Long,
    var returnDate: Date,
    var employeeId: Long,
    var lastUpdate: Date
) {
    constructor(
        rentalDate: Date,
        inventoryId: Long?,
        customerId: Long,
        returnDate: Date,
        employeeId: Long,
        lastUpdate: Date
    ) :
            this(rentalId = null, rentalDate, inventoryId, customerId, returnDate, employeeId, lastUpdate)
}