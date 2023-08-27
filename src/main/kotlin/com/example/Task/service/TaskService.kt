package com.example.Task.service

import com.example.Task.dto.request.TaskRequest
import com.example.Task.dto.response.TaskResponse
import com.example.Task.model.Person
import com.example.Task.model.Task
import com.example.Task.repository.TaskRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class TaskService
    (
    private val taskRepository: TaskRepository,
    private val personService: PersonService
) {
    fun addTask(taskRequest: TaskRequest) {
        taskRepository.save(
            Task(
                title = taskRequest.title,
                description = taskRequest.description,
                prioritylevel = taskRequest.priorityLevel,
                enddate = taskRequest.endDate,
                isdeleted = false,
                person = findByExaminerMail()
            )

        )
    }

    fun editTask(taskRequest: TaskRequest, taskId: UUID): TaskResponse {
        val task = taskRepository.findById(taskId).get()
        task.enddate = taskRequest.endDate
        task.isdeleted = taskRequest.isDeleted
        task.description = taskRequest.description
        task.prioritylevel = taskRequest.priorityLevel
        task.title = taskRequest.title
        taskRepository.save(task)
        return task.toTaskResponse()
    }

    fun getAllTask(): List<TaskResponse> {
        return taskRepository.findAll().filterNot { it.isdeleted }.map { it.toTaskResponse() }

    }

    fun findByExaminerMail(): Person {
        return personService.findByEmail("manasgoyal913@gmail.com")
    }
}