package com.backend.restapi.services

import com.backend.restapi.data.vo.v1.PersonVO
import com.backend.restapi.exception.ResourceNotFoundException
import com.backend.restapi.mapper.Dozermapper
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

    fun filterPerson(firstName: String, lastName: String, gender: String): List<PersonVO> {
        // TODO: implement filter
    }

    fun findById(id: Long): PersonVO {
        logger.info("finding a person")

        val person = repository.findById(id)
            .orElseThrow{ ResourceNotFoundException("Person not found") }

        return Dozermapper.parseObject(person, PersonVO::class.java)
    }

    fun findAll(): List<PersonVO> {
        logger.info("person list")

        val personList = repository.findAll()
        return Dozermapper.parseListObject(personList, PersonVO::class.java)
    }

    fun createPerson(person: PersonVO): PersonVO {
        logger.info("creating person -> ${person.firstName}")

        var entity: Person = Dozermapper.parseObject(person, Person::class.java)
        return Dozermapper.parseObject(repository.save(entity), PersonVO::class.java)
    }

    fun updatePerson(person: PersonVO): PersonVO {
        val entity = repository.findById(person.id)
            .orElseThrow{ ResourceNotFoundException("Person not found") }

        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender

        logger.info("updating person -> ${entity.id}")

        return Dozermapper.parseObject(repository.save(entity), PersonVO::class.java)
    }

    fun deletePerson(id: Long) {
        val entity = repository.findById(id)
            .orElseThrow{ ResourceNotFoundException("Person not found") }

        logger.info("deleting person -> $id")
        repository.delete(entity)
    }
}