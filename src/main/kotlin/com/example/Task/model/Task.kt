package com.example.Task.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table
data class Task(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,

    @Column
    var title: String? = "",

    @Column
    var description: String? = "",

    @Column
    var priorityLevel: String,

    @Column
    var endDate: Date,

    @Column
    var isDeleted: Boolean

)
