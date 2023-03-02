package com.mundiflora.api.repository

import com.mundiflora.api.model.Categoria
import org.springframework.data.jpa.repository.JpaRepository

interface CategoriaRepository:JpaRepository<Categoria,Long> {

    fun findById (id: Long?):Categoria?



}