package com.example.demo.module.controller

import com.example.demo.module.dto.BoardDto
import com.example.demo.module.dto.BoardModifyDto
import com.example.demo.module.dto.CommentDto
import com.example.demo.module.entity.Board
import com.example.demo.module.entity.Comment
import com.example.demo.module.service.BoardService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
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
    @GetMapping("{id}")
    fun getBoardById(@PathVariable id: String):Board{
        return boardService.getBoardById(id)
    }

    @DeleteMapping("{id}/delete")
    fun deleteBoardById(@PathVariable id:String){
        return boardService.deleteById(id)
    }

    @PatchMapping("{id}/modify")
    fun modifyBoardById(@PathVariable id:String,@RequestBody request : BoardModifyDto):Board {
        return boardService.modifyById(id, request)

    }

    @PostMapping("{id}/comment")
    fun postComment(@PathVariable id:String, @RequestBody request:CommentDto):Comment{
        return boardService.postComment(id, request)
    }
}