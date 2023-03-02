package com.mundiflora.api.model

import java.util.Date
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table


@Entity
@Table(name="productos")
class Productos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var nombre : String? = null
    var clima : String? = null
    var precio : Double? = null
    var cantidad : Double? = null

    @Column(name= "id_categoria")
    var idCategoria : Long? = null
    @Column(name= "id_mesa")
    var idMesa : Long? = null
}