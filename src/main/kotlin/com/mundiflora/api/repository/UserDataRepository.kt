package com.mundiflora.api.repository

import com.mundiflora.api.model.Categoria
import com.mundiflora.api.model.UserData
import org.springframework.data.jpa.repository.JpaRepository

interface UserDataRepository:JpaRepository<UserData,Long> {

    fun findById (id: Long?):UserData?



}