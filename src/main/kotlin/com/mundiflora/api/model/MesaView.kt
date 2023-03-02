package com.mundiflora.api.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name="mesa_view")
class MesaView {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var mesa : String? = null
    @Column(name= "id_invernadero")
    var idInvernadero : Long? = null
    var invernadero : String? = null

}