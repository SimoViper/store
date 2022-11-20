package com.example.store.model

class RentalRequest (
    var films: List<Film>,
    var customerId: Long,
    var storeId: Long,
    var employeeId: Long
    )