package com.example.demo.module.controller

import com.example.demo.module.dto.BoardDto
import com.example.demo.module.dto.BoardModifyDto
import com.example.demo.module.dto.CommentDto
import com.example.demo.module.dto.CommentModifyDto
import com.example.demo.module.entity.Board
import com.example.demo.module.entity.Comment
import com.example.demo.module.service.BoardService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/board")
class BoardController(private val boardService: BoardService) {
    @PostMapping("/create")
    fun createBoard(@RequestBody request: BoardDto): Board {
        request.apply {
            return boardService.createBoard(BoardDto(id, title, content, userId))
        }
    }
    @GetMapping("{boardId}")
    fun getBoardById(@PathVariable boardId: String): Board {
        return boardService.getBoardById(boardId)
    }

    @DeleteMapping("{boardId}/delete")
    fun deleteBoardById(@PathVariable boardId: String) {
        return boardService.deleteById(boardId)
    }

    @PatchMapping("{boardId}/modify")
    fun modifyBoardById(@PathVariable boardId: String, @RequestBody request: BoardModifyDto): Board {
        return boardService.modifyById(boardId, request)
    }

    //댓글
    @PostMapping("{boardId}/comment")
    fun postComment(@PathVariable boardId: String, @RequestBody request: CommentDto): Comment {
        return boardService.postComment(boardId, request)
    }

    @PatchMapping("comment/{commentId}")
    fun modifyComment(@PathVariable commentId: Long, @RequestBody request: CommentModifyDto): Comment {
        return boardService.modifyComment(commentId, request)
    }

    @DeleteMapping("comment/{commentId}")
    fun deleteComment(@PathVariable commentId: Long) {
        return boardService.deleteComment(commentId)
    }
}