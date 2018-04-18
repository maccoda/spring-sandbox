package com.example.springsandbox.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import javax.persistence.*

@Entity
@Table(name="company")
data class CompanyEntity(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) // Needed as type is serial
              val id: Int? = null,
                         @Column(name = "name") val name: String)

@Repository
interface CompanyRepository: CrudRepository<CompanyEntity,Int>