package com.example.demo.module.service

import com.example.demo.module.dto.UserDto
import com.example.demo.module.entity.User
import com.example.demo.module.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(private val userRepository: UserRepository) {

    fun applyUser(userDto: UserDto): User {
        userDto.apply{
            return userRepository.save(User(userId,userName,userPassword))
        }
    }
    fun getById(): User {
        return userRepository.getById("sjh00kr")
    }

    }