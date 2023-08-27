package com.example.Task.model

import com.example.Task.dto.response.TaskResponse
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "task")
data class Task(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,

    @Column
    var title: String? = "",

    @Column
    var description: String? = "",

    @Column
    var prioritylevel: String,

    @Column
    var enddate: Date,

    @Column
    var isdeleted: Boolean,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    val person: Person

) {
    fun toTaskResponse(): TaskResponse {
        return TaskResponse(
            taskId = this.id!!,
            title = this.title!!,
            description = this.description!!,
            priorityLevel = this.prioritylevel!!,
            isDeleted = this.isdeleted,
            endDate = this.enddate
        )
    }
}

