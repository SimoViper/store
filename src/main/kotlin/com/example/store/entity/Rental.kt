package com.example.store.entity

import java.util.*
import javax.persistence.*

@Entity
class Rental(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var rentalId: Long?,
    var rentalDate: Date,
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventory_id")
    var inventory: Inventory?,
    var customerId: Long,
    var returnDate: Date,
    var employeeId: Long,
    var lastUpdate: Date,
    @OneToOne(mappedBy = "rental")
    var payment: Payment?
) {
    constructor(
        rentalDate: Date,
        inventory: Inventory?,
        customerId: Long,
        returnDate: Date,
        employeeId: Long,
        lastUpdate: Date
    ) :
            this(rentalId = null, rentalDate, inventory, customerId, returnDate, employeeId, lastUpdate, null)
}