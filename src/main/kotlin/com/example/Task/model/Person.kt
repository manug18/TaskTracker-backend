package com.example.Task.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "person")
data class Person(
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
    var password:String,

    @OneToMany(mappedBy = "person", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val tasks: MutableList<Task> = mutableListOf()

)



