package com.example.store.service

import com.example.store.entity.Payment
import com.example.store.model.PaymentRequest
import com.example.store.model.PaymentResponse
import com.example.store.model.RentalPayment
import com.example.store.repository.PaymentRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.util.*

@Service
class PaymentService(private val paymnentRepository: PaymentRepository) {

    fun createPayment(paymentRequest: PaymentRequest) : PaymentResponse {
        val paymentIds = mutableListOf<Long?>()
        var totalAmount = BigDecimal.ZERO

        paymentRequest.rentals.forEach {  rental ->
            val payment = savePayment(paymentRequest, rental)
            paymentIds.add(payment.paymentId)
           totalAmount =  totalAmount.add(rental.amount)
        }

        return PaymentResponse(totalAmount, paymentIds)
    }

    private fun savePayment(paymentRequest: PaymentRequest, rental: RentalPayment): Payment {
        return paymnentRepository.save(
            Payment(
                customerId = paymentRequest.customerId, employeeId = paymentRequest.employeeId,
                rentalId = rental.rentalId, amount = rental.amount, paymentDate = Date(), lastUpdate = Date()
            )
        )
    }
}