package com.mundiflora.api.model

import java.util.Date
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "orden_view")
class OrdenView {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @Column(name="create_at")
    var createAt: Date? = null
    @Column(name="id_clientes")
    var id_clientes: String? = null
    var clientes: String? = null


}