package com.example.store.entity

import java.util.Date
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Inventory(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var inventoryId: Long?,
    var filmId: Long,
    var storeId: Long,
    var lastUpdate: Date
) {
    constructor(filmId: Long, storeId: Long, lastUpdate: Date) :
            this(inventoryId = null, filmId, storeId, lastUpdate)
}
