package com.example.store.entity

import java.math.BigDecimal
import java.util.*
import javax.persistence.*

@Entity
class Payment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var paymentId: Long?,
    var customerId: Long?,
    var employeeId: Long?,
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rental_id")
    var rental: Rental?,
    var amount: BigDecimal?,
    var paymentDate: Date,
    var lastUpdate: Date
) {
    constructor(
        customerId: Long?,
        employeeId: Long?,
        rental: Rental?,
        amount: BigDecimal?,
        paymentDate: Date,
        lastUpdate: Date
    ) :
            this(paymentId = null, customerId, employeeId, rental, amount, paymentDate, lastUpdate)
}