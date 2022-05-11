package com.example.demo.module.service

import com.example.demo.module.dto.BoardDto
import com.example.demo.module.entity.Board
import com.example.demo.module.repository.BoardRepository
import com.example.demo.module.repository.UserRepository
import org.springframework.stereotype.Service


@Service
class BoardService(private val boardRepository: BoardRepository,private val userRepository: UserRepository) {

    fun createBoard(boardDto: BoardDto):Board{
        val userId=userRepository.getById(boardDto.userId)
        boardDto.apply {
            return boardRepository.save(Board(id,title,content,userId))
        }
    }
}