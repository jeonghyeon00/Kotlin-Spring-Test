package com.example.demo.module.dto

import com.example.demo.module.entity.User

data class BoardDto(
    val id:Long,
    val title:String,
    val content:String,
    val userId:String,
)