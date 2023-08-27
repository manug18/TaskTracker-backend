package com.example.Task.dto.response

import java.util.*

data class TaskResponse(
    var taskId: UUID,
    var title: String,
    var description: String,
    var priorityLevel: String,
    var isDeleted: Boolean,
    val endDate: Date
)