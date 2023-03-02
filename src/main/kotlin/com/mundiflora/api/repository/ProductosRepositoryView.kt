package com.mundiflora.api.repository

import com.mundiflora.api.model.ProductosView
import org.springframework.data.jpa.repository.JpaRepository

interface ProductosRepositoryView: JpaRepository <ProductosView , Long> {

    fun findById (id: Long?): ProductosView?
}