package com.mundiflora.api.repository
import com.mundiflora.api.model.Invernadero
import org.springframework.data.jpa.repository.JpaRepository

interface InvernaderoRepository: JpaRepository<Invernadero, Long> {
    fun findById (id: Long?): Invernadero?
}