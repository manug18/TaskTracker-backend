package com.example.Task.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "user")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,

    @Column
    var name: String? = "",

    @Column
    var phone: String? = "",

    @Column(unique = true)
    var email: String,

    @Column
    var password:String

)



