package com.mundiflora.api.service

import com.mundiflora.api.model.Orden
import com.mundiflora.api.model.OrdenView
import com.mundiflora.api.repository.OrdenRepository
import com.mundiflora.api.repository.OrdenViewRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class OrdenService {

    @Autowired
    lateinit var ordenRepository: OrdenRepository
    @Autowired
    lateinit var ordenViewRepository: OrdenViewRepository

//    fun list (orden:Orden):List<Orden>{
//        val matcher = ExampleMatcher.matching()
//            .withIgnoreNullValues()
//            .withMatcher(("idClientes"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
//        return ordenRepository.findAll(Example.of(orden, matcher))
//    }
    fun list ():List <Orden>{
        return ordenRepository.findAll()
    }

    fun listById (id:Long?):Orden? {
        return ordenRepository.findById(id)
    }
    fun listByIdOrdend (id:Long?):OrdenView? {
        return ordenViewRepository.findById(id)
    }

    fun listOrdenClientes ():List<OrdenView>{
        return ordenViewRepository.findAll()
    }

//    fun listByFullName (word:String):List<OrdenView>{
//        return ordenViewRepository.listByFullname(word)
//    }
//
//    fun listLast ():List<OrdenView>{
//        return ordenViewRepository.listLastTen()
//    }


    fun save (orden: Orden): Orden{
        return ordenRepository.save(orden)
    }


    fun update (orden: Orden):Orden?{
        ordenRepository.findById(orden.id) ?:
        throw Exception()
        return ordenRepository.save(orden)
    }

//    fun getClienteByOrden (id:Long):OrdenView{
//        return ordenViewRepository.getClienteByOrden(id)
//    }

    fun delete (id: Long?):Boolean?{
        ordenRepository.findById(id) ?:
        Exception()
        ordenRepository.deleteById(id!!)
        return true
    }

}