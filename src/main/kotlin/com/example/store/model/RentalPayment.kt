package com.example.store.model

import com.fasterxml.jackson.annotation.JsonInclude
import java.math.BigDecimal

@JsonInclude(JsonInclude.Include.NON_NULL)
class RentalPayment(
    var rentalId: Long,
    var amount: BigDecimal
)