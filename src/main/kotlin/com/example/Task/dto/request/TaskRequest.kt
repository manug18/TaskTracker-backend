package com.example.Task.dto.request

import java.util.*

data class TaskRequest(
//    val taskId: UUID,
    var title: String,
    var description: String,
    var priorityLevel: String,
    var isDeleted: Boolean,
    val endDate: Date
)