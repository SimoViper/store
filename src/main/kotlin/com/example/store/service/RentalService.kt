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
                val inventory: Inventory = saveInventory(film, rentalRequest)
                val rental = saveRental(inventory, rentalRequest, film.rentalDuration)

                rentals.add(RentalDTO(rentalId = rental.rentalId, rental.returnDate))
            }
        }
        return rentals
    }

    fun getRentalsByCustomer(customerId: Long): List<RentalDTO> {
        val rentals: List<Rental> = rentalRepository.findByCustomerId(customerId)
        val rentalDTOs = mutableListOf<RentalDTO>()
        rentals.stream().forEach { rental ->
            rentalDTOs.add(
                RentalDTO(
                    rentalId = rental.rentalId,
                    rentalDate = rental.rentalDate,
                    returnDate = rental.returnDate,
                    storeId = rental.inventory?.storeId,
                    filmId = rental.inventory?.filmId,
                    employeeId = rental.employeeId
                )
            )
        }
        return rentalDTOs
    }

    private fun saveRental(
        inventory: Inventory?,
        rentalRequest: RentalRequest,
        rentalDuration: Int
    ): Rental {
        val rental = rentalRepository.save(
            Rental(
                Date(),
                inventory,
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
    ): Inventory {
        return inventoryRepository.save(
            Inventory(
                filmId = film.filmId,
                storeId = rentalRequest.storeId,
                lastUpdate = Date()
            )
        )
    }

    private fun getReturnDate(rentalDuration: Int): Date {
        val calendar: Calendar = Calendar.getInstance()
        calendar.add(Calendar.DATE, rentalDuration)
        return calendar.time
    }
}