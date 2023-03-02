package com.mundiflora.api.repository

import com.mundiflora.api.model.Productos
import com.mundiflora.api.model.ProductosView
import org.springframework.data.jpa.repository.JpaRepository

interface ProductosRepository: JpaRepository <Productos , Long> {

    fun findById (id: Long?): Productos?
}