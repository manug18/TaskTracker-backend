package com.example.Task.repository

import com.example.Task.model.Task
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TaskRepository : JpaRepository<Task, UUID> {

    override fun findById(id: UUID): Optional<Task>

//    fun findAll(): List<Task>
}