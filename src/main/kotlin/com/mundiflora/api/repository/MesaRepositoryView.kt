package com.mundiflora.api.repository
import com.mundiflora.api.model.MesaView
import org.springframework.data.jpa.repository.JpaRepository

interface MesaRepositoryView: JpaRepository<MesaView, Long> {
    fun findById (id: Long?): MesaView?
}
