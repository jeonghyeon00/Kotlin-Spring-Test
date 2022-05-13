package com.example.demo.module.repository

import com.example.demo.module.entity.Board
import com.example.demo.module.entity.Comment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CommentRepository:JpaRepository<Comment,Long>{
}