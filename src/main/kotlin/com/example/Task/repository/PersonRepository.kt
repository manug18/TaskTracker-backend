package com.example.Task.repository

import com.example.Task.model.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PersonRepository : JpaRepository<Person, UUID> {
    fun findByEmail(email: String): Person
}