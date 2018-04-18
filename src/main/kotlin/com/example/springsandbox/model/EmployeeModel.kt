package com.example.springsandbox.model

import com.example.springsandbox.repository.EmployeeEntity

data class EmployeeModel(val id: Int, val firstName: String, val lastName: String, val jobTitle: String, val companyName: String){
    companion object {
        fun from(entity: EmployeeEntity): EmployeeModel {
            return EmployeeModel(entity.id?:0, entity.firstName, entity.lastName, entity.jobTitle, entity.company.name)
        }
    }
}