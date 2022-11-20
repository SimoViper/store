package com.example.store.model

class PaymentRequest(
    var customerId: Long,
    var rentalId: Long,
    var employeeId: Long,
    var amount: Double
)