package com.mundiflora.api.controller

import com.mundiflora.api.model.DetalleView
import com.mundiflora.api.model.Detalle
import com.mundiflora.api.service.DetalleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/detalle")

@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
class DetalleController {
    @Autowired
    lateinit var detalleService: DetalleService
    @GetMapping
    fun list (@RequestHeader headers: HashMap<String, String>,detail:Detalle):List <Detalle>{
        return detalleService.list(detail)
    }
//    @GetMapping
//    fun listDetalleProductosId (): List<DetalleView>{
//        return detalleService.listProductosId()
//    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): Detalle?{
        return detalleService.listById(id)
    }
    @GetMapping("/{idOrden}/orden")
    fun listDetalleByOrden (@PathVariable("idOrden") idOrden: Long): List<DetalleView>? {
        return detalleService.getDetalleByOrden(idOrden)
    }

    @PostMapping
    fun save (@RequestBody detalle: Detalle): Detalle?{
        return detalleService.save(detalle)
    }

    @PutMapping
    fun update (@RequestBody detalle: Detalle): Detalle?{
        return detalleService.update(detalle)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return detalleService.delete(id)
    }
}