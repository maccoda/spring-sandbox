package com.example.springsandbox.service

import com.example.springsandbox.repository.EmployeeEntity
import com.example.springsandbox.repository.EmployeeRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional(readOnly = true)
class EmployeeService(val repository: EmployeeRepository) {

    fun findAllEmployees(): List<EmployeeEntity> {
        return repository.findAll().filterNotNull()
    }

    @Transactional
    fun addEmployee(employee: EmployeeEntity): String {
        /* validate that it isn't a duplicate */
        if (repository.findByLastName(employee.lastName).none { it.firstName == employee.firstName }) {
            repository.save(employee)
            return "Successfully added employee"
        }
        return "Employee already exists"
    }

    @Transactional
    fun deleteEmployee(id: Int): Optional<EmployeeEntity> {
        val result = repository.findById(id)
        if (result.isPresent) {
            repository.deleteById(id)
        }
        return result
    }

    /**
     * Find an employee from the given ID
     */
    fun findEmployee(id: Int): EmployeeEntity {
        return repository.findById(id).get()
    }

    /**
     * Update the employee associated to the given ID with the provided data object.
     */
    @Transactional
    fun updateEmployee(id: Int, update: EmployeeEntity): EmployeeEntity {
        val result = repository.findById(id)
                .map { it.copy(firstName = update.firstName, lastName = update.lastName, jobTitle = update.jobTitle) }
        result.ifPresent { repository.save(it) }
        return result.get()
    }
}