package com.example.store.model

import java.math.BigDecimal

class PaymentResponse(
    var totalAmount: BigDecimal,
    var paymentIds: List<Long?>
) {
}