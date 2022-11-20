package com.example.store.entity

import java.math.BigDecimal
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Payment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var paymentId: Long?,
    var customerId: Long?,
    var employeeId: Long?,
    var rentalId: Long?,
    var amount: BigDecimal?,
    var paymentDate: Date,
    var lastUpdate: Date
) {
    constructor(
        customerId: Long?,
        employeeId: Long?,
        rentalId: Long,
        amount: BigDecimal?,
        paymentDate: Date,
        lastUpdate: Date
    ) :
            this(paymentId = null, customerId, employeeId, rentalId, amount, paymentDate, lastUpdate)
}