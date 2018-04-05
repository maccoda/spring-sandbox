package com.example.springsandbox.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import javax.persistence.*

@Entity
@Table(name="employee")
data class EmployeeEntity(@Id @GeneratedValue(strategy=GenerationType.IDENTITY) // Needed as type is serial
                          val id: Int? = null,
                          @Column(name = "first_name")
                          val firstName: String,
                          @Column(name = "last_name")
                          val lastName: String,
                          @Column(name = "job_title")
                          val jobTitle: String) {

    // Needed for deleteAll function
    constructor() : this(0, "","","")
}

@Repository
interface EmployeeRepository: CrudRepository<EmployeeEntity, Int> {
    fun findByLastName(lastName: String): List<EmployeeEntity>
}