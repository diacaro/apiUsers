package com.mundiflora.api.service

import com.mundiflora.api.model.*
import com.mundiflora.api.repository.InvernaderoRepository
import com.mundiflora.api.repository.MesaRepository
import com.mundiflora.api.repository.MesaRepositoryView
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class MesaService {
    @Autowired
    lateinit var mesaRepository: MesaRepository
    @Autowired
    lateinit var invernaderoRepository: InvernaderoRepository
    @Autowired
    lateinit var mesaRepositoryView: MesaRepositoryView

    fun list ():List <Mesa>{
        return mesaRepository.findAll()
    }
    fun listById (id:Long?):Mesa? {
        return mesaRepository.findById(id)
    }

    fun listByInvernaderoId (id:Long?):List <Mesa> {
        return mesaRepository.ListByInvernaderoId(id)
    }
    fun listView ():List <MesaView>{
        return mesaRepositoryView.findAll()
    }

    fun save (mesa: Mesa): Mesa {
        try{

            val response = invernaderoRepository.findById(mesa.idInvernadero)
                ?: throw Exception("El ID ${mesa.idInvernadero} del invernadero no existe")

            return mesaRepository.save(mesa)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }

    }
//        return mesaRepository.save(mesa)


    fun  update (mesa: Mesa): Mesa {
        try {
            mesaRepository.findById(mesa.id)
                ?: throw Exception("Id Existe")
            return mesaRepository.save(mesa)
        }
        catch (ex: Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun delete (id:Long?): Boolean{
        try {
            mesaRepository.findById(id)
                ?: throw Exception("NO existe el ID")
            mesaRepository.deleteById(id!!)
            return true
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

}