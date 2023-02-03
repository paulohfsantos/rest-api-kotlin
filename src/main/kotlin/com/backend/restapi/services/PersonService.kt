package com.backend.restapi.services

import com.backend.restapi.exception.ResourceNotFoundException
import com.backend.restapi.model.Person
import com.backend.restapi.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PersonService {

    @Autowired
    private lateinit var repository: PersonRepository
    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findById(id: Long): Person {
        logger.info("finding a person")

        return repository.findById(id)
            .orElseThrow{ ResourceNotFoundException("Person not found") }
    }

    fun findAll(): List<Person> {
        logger.info("person list")

        return repository.findAll()
    }

    fun createPerson(person: Person): Person {
        logger.info("creating person -> ${person.firstName}")
        return repository.save(person)
    }

    fun updatePerson(person: Person): Person {
        val entity = repository.findById(person.id)
            .orElseThrow{ ResourceNotFoundException("Person not found") }

        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender

        logger.info("updating person -> ${entity.id}")

        return repository.save(entity)
    }

    fun deletePerson(id: Long) {
        val entity = repository.findById(id)
            .orElseThrow{ ResourceNotFoundException("Person not found") }

        logger.info("deleting person -> $id")
        repository.delete(entity)
    }
}