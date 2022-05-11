package com.example.demo.module.entity

import javax.persistence.*

@Entity
@Table(name="User")
class User (
    @Id
    @GeneratedValue
    val userId: Long,
    val userName: String,
    val userPassword: String,
)