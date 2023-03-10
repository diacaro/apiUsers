package com.mundiflora.api.controller
import com.mundiflora.api.model.Clientes
import com.mundiflora.api.service.ClientesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
// @RequestMapping("/api/v1/auth/clientes")
@RequestMapping("/clientes")
//La siguiente linea habilita el acceso desde la api
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])

class ClienteController {
    @Autowired
    lateinit var clientesService: ClientesService

    @GetMapping
    fun list():List<Clientes>{
        return clientesService.list()
    }

    @GetMapping ("/{id}")
    fun listById(@PathVariable id:Long?):Clientes?{
        return clientesService.listById(id)
    }
    @GetMapping ("/{word}/search")
    fun listByClientes(@PathVariable("word") word: String):List<Clientes>{
        return clientesService.listByName(word)
    }

    @PostMapping
    fun save(@RequestBody clientes: Clientes): Clientes {
        return clientesService.save (clientes)
    }
    @PutMapping
    fun update (@RequestBody clientes: Clientes):  ResponseEntity<Clientes> {
        return  ResponseEntity(clientesService.update(clientes), HttpStatus.OK)
    }

    @PatchMapping ("/updateFullname")
    fun updateFullname (@RequestBody clientes: Clientes): ResponseEntity<Clientes> {
        return  ResponseEntity(clientesService.updateFullname(clientes), HttpStatus.OK)
    }
    @PatchMapping ("/updatePhone")
    fun updatePhone (@RequestBody clientes: Clientes): ResponseEntity<Clientes> {
        return  ResponseEntity (clientesService.updatePhone(clientes), HttpStatus.OK)
    }
    @PatchMapping ("/updateAddress")
    fun updateAddress (@RequestBody clientes: Clientes): ResponseEntity<Clientes> {
        return  ResponseEntity(clientesService.updateAddress(clientes), HttpStatus.OK)
    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long): Boolean {
        return clientesService.delete(id)
    }
}
