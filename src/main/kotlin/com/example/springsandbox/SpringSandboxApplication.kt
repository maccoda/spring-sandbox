package com.example.springsandbox

import com.example.springsandbox.repository.EmployeeEntity
import com.example.springsandbox.repository.EmployeeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class SpringSandboxApplication(val employeeRepository: EmployeeRepository): CommandLineRunner {


    override fun run(vararg args: String?) {
//        employeeRepository.deleteAll()
//        employeeRepository.save(EmployeeEntity(firstName = "Bob", lastName = "Johnson", jobTitle = "Analyst"))
//        employeeRepository.save(EmployeeEntity(firstName = "Jack", lastName = "Reacher", jobTitle = "Wanderer"))
//        employeeRepository.save(EmployeeEntity(firstName = "Jane", lastName = "Austin", jobTitle = "Author"))
//        employeeRepository.save(EmployeeEntity(firstName = "Raymond", lastName = "Reddington", jobTitle = "Business Man"))
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(SpringSandboxApplication::class.java, *args)
}
