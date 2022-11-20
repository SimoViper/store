package com.example.store.repository

import com.example.store.entity.Inventory
import org.springframework.data.repository.CrudRepository

interface InventoryRepository : CrudRepository<Inventory, Long> {
    fun save(inventory: Inventory): Inventory
}