package com.example.springsandbox.controller

import com.example.springsandbox.model.EmployeeModel
import com.example.springsandbox.repository.EmployeeEntity
import com.example.springsandbox.service.EmployeeService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class EmployeeController(val service: EmployeeService) {

    @GetMapping("/employees")
    fun getAllEmployees(): List<EmployeeModel> {
        return service.findAllEmployees()
    }

    @GetMapping("/employees/{id}")
    fun getEmployee(@PathVariable id: Int): EmployeeEntity {
        return service.findEmployee(id)
    }

    @PostMapping("/employees/add")
    fun addEmployee(@RequestBody employeeEntity: EmployeeModel): String {
        return service.addEmployee(employeeEntity)
    }

    @DeleteMapping("/employees/{id}")
    fun removeEmployee(@PathVariable id: Int): Optional<EmployeeEntity> {
        return service.deleteEmployee(id)
    }

    @PutMapping("/employees/{id}")
    fun updateEmployee(@PathVariable id:Int, @RequestBody update: EmployeeEntity) : EmployeeEntity {
        return service.updateEmployee(id, update)
    }
}