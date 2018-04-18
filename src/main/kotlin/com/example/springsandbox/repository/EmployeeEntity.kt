package com.example.springsandbox.repository

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import javax.persistence.*

@Entity
@Table(name = "employee")
data class EmployeeEntity(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) // Needed as type is serial
                          val id: Int? = null,
                          @Column(name = "first_name")
                          val firstName: String,
                          @Column(name = "last_name")
                          val lastName: String,
                          @Column(name = "job_title")
                          val jobTitle: String,
                          @ManyToOne(cascade =[CascadeType.ALL])
                          @JoinColumn(name = "company_id")
                          val company: CompanyEntity)
@Repository
interface EmployeeRepository : CrudRepository<EmployeeEntity, Int> {
    fun findByLastName(lastName: String): List<EmployeeEntity>
    @Query(value="select e.*, c.name from employee as e left join company as c on e.company_id=c.id", nativeQuery = true)
    fun findAllCollapsed(): List<EmployeeEntity>
}