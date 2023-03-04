package com.mundiflora.api.repository
import com.mundiflora.api.model.Clientes
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ClientesRepository: JpaRepository <Clientes , Long> {
    fun findById (id: Long?): Clientes?

    @Query(nativeQuery = true)
    fun listByName (word: String?): List<Clientes>
}