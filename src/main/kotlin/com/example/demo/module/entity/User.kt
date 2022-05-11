package com.example.demo.module.entity

import javax.persistence.*

@Entity
@Table(name="User")
class User (
    @Id
    val userId: String,
    val userName: String,
    val userPassword: String,
)