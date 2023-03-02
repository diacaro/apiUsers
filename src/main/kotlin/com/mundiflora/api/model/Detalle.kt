package com.mundiflora.api.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "detalles")
class Detalle {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @Column(name="id_orden")
    var idOrden: Long? = null
    @Column(name="id_productos")
    var idProductos: Long? = null
    var cantidad : Double? = null

}