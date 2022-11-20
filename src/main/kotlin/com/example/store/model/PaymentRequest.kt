package com.example.store.model

class PaymentRequest(
    var customerId: Long,
    var employeeId: Long,
    var rentals: List<RentalPayment>
)