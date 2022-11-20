package com.example.store.repository

import com.example.store.entity.Payment
import org.springframework.data.repository.CrudRepository

interface PaymentRepository : CrudRepository<Payment, Long> {
    fun save(payment: Payment) : Payment
}