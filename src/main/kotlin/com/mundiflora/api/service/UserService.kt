package com.mundiflora.api.service

import com.mundiflora.api.model.UserData
import com.mundiflora.api.repository.UserDataRepository
import com.mundiflora.api.user.User
import com.mundiflora.api.user.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class UserService {

    @Autowired
    lateinit var userDataRepository: UserDataRepository

    fun list ():List <UserData>{
        return userDataRepository.findAll()
    }


    fun delete (id:Long): Boolean{
        try {
            userDataRepository.findById(id)
                ?: throw Exception("La categoria no existe")
            userDataRepository.deleteById(id!!)
            return true
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    }