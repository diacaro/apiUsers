package com.mundiflora.api.controller
import com.mundiflora.api.model.Categoria
import com.mundiflora.api.model.UserData
import com.mundiflora.api.service.CategoriaService
import com.mundiflora.api.service.UserService
import com.mundiflora.api.user.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])

class UserController {
    @Autowired
    lateinit var userService: UserService

    @GetMapping
    fun list():List<UserData>{
        return userService.list()
    }


    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long): Boolean {
        return userService.delete(id)
    }
}

