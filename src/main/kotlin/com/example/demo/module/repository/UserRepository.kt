package com.example.demo.module.repository

import com.example.demo.module.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long>{

}
