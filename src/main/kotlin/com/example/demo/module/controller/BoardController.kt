package com.example.demo.module.controller

import com.example.demo.module.dto.BoardDto
import com.example.demo.module.dto.BoardModifyDto
import com.example.demo.module.entity.Board
import com.example.demo.module.service.BoardService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
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
    @GetMapping("{id}")
    fun getBoardById(@PathVariable id: String):Board{
        return boardService.getBoardById(id)
    }

    @GetMapping("{id}/delete")
    fun deleteBoardById(@PathVariable id:String){
        return boardService.deleteById(id)
    }

    @PutMapping("{id}/modify")
    fun modifyBoardById(@PathVariable id:String,@RequestBody request : BoardModifyDto):Board{
        return boardService.modifyById(id,request)
    }
}