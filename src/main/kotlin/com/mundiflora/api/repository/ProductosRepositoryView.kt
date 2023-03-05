package com.mundiflora.api.repository

import com.mundiflora.api.model.Clientes
import com.mundiflora.api.model.ProductosView
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface ProductosRepositoryView: JpaRepository <ProductosView , Long> {

    fun findById (id: Long?): ProductosView?

    @Query(nativeQuery = true)
    fun listByName (word: String?): List<ProductosView>
}