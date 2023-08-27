package com.example.Task.controller

import com.example.Task.dto.Response
import com.example.Task.dto.request.TaskRequest
import com.example.Task.dto.response.TaskResponse
import com.example.Task.service.TaskService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/task")
class TaskController(
    private val taskService: TaskService
) {

    @PostMapping
    fun addTask(@RequestBody taskRequest: TaskRequest) {
        taskService.addTask(taskRequest)
    }

    @PutMapping("/{taskId}")
    fun editTask(
        @RequestBody taskRequest: TaskRequest,
        @PathVariable taskId: UUID
    ): ResponseEntity<Response<TaskResponse>> {
        val res = taskService.editTask(taskRequest, taskId)
        return ResponseEntity.ok(Response(message = "edited", data = res))
    }

    @GetMapping()
    fun getAllTask(): ResponseEntity<Response<List<TaskResponse>>> {
        val res = taskService.getAllTask();
        return ResponseEntity.ok(Response(message = "Tasks are ", data = res))
    }

}