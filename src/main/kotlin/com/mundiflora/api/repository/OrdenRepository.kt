package com.mundiflora.api.repository
import com.mundiflora.api.model.Orden
import org.springframework.data.jpa.repository.JpaRepository

interface OrdenRepository: JpaRepository <Orden , Long> {

    fun findById (id: Long?): Orden?
}