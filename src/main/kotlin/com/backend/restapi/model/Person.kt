package com.backend.restapi.model

import javax.persistence.*

@Entity
@Table(name = "person")
data class Person(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "first_name", nullable = false, length = 100)
    var firstName: String = "",

    @Column(name = "last_name", nullable = false, length = 100)
    var lastName: String = "",

    @Column(name = "address", nullable = false)
    var address: String = "",

    @Column(name = "gender", nullable = false)
    var gender: String = ""
)