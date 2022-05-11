package com.example.demo.module.controller

import com.example.demo.module.dto.BoardDto
import com.example.demo.module.entity.Board
import com.example.demo.module.service.BoardService
import com.example.demo.module.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/board")
class BoardController(private val boardService: BoardService) {
    @PostMapping("/create")
    fun createBoard(@RequestBody request:BoardDto):Board{
        request.apply {
            return boardService.createBoard(BoardDto(id,title, content, userId))
        }

    }

}