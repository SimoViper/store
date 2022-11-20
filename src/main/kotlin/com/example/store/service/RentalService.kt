package com.example.store.service

import com.example.store.entity.Inventory
import com.example.store.entity.Rental
import com.example.store.model.Film
import com.example.store.model.RentalDTO
import com.example.store.model.RentalRequest
import com.example.store.repository.InventoryRepository
import com.example.store.repository.RentalRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class RentalService @Autowired constructor(
    val inventoryRepository: InventoryRepository,
    val rentalRepository: RentalRepository
) {

    fun rentFilm(rentalRequest: RentalRequest): List<RentalDTO> {
        val rentals = mutableListOf<RentalDTO>()
        rentalRequest.films.forEach { film ->
            run {
                val inventoryId: Long? = saveInventory(film, rentalRequest)
                val rental = saveRental(inventoryId, rentalRequest, film.rentalDuration)

                rentals.add(RentalDTO(rentalId = rental.rentalId, rental.returnDate))
            }
        }
        return rentals
    }

    private fun saveRental(
        inventoryId: Long?,
        rentalRequest: RentalRequest,
        rentalDuration: Int
    ): Rental {
        val rental = rentalRepository.save(
            Rental(
                Date(),
                inventoryId,
                rentalRequest.customerId,
                getReturnDate(rentalDuration),
                rentalRequest.employeeId,
                Date()
            )
        )
        return rental
    }

    private fun saveInventory(
        film: Film,
        rentalRequest: RentalRequest
    ): Long? {
        val inventory = inventoryRepository.save(
            Inventory(
                filmId = film.filmId,
                storeId = rentalRequest.storeId,
                lastUpdate = Date()
            )
        )
        return inventory.inventoryId
    }

    private fun getReturnDate(rentalDuration: Int): Date {
        val calendar: Calendar = Calendar.getInstance()
        calendar.add(Calendar.DATE, rentalDuration)
        return calendar.time
    }
}