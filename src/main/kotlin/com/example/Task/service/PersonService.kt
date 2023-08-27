package com.example.Task.service

import com.example.Task.model.Person
import com.example.Task.repository.PersonRepository
import org.springframework.stereotype.Service

@Service
class PersonService(
    private val personRepository: PersonRepository
) {
    fun findByEmail(mailId: String): Person {
        return personRepository.findByEmail(mailId)
    }
}