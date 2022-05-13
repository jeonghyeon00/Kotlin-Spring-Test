package com.example.demo.module.service

import com.example.demo.module.dto.BoardDto
import com.example.demo.module.dto.BoardModifyDto
import com.example.demo.module.dto.CommentDto
import com.example.demo.module.entity.Board
import com.example.demo.module.entity.Comment
import com.example.demo.module.repository.BoardRepository
import com.example.demo.module.repository.CommentRepository
import com.example.demo.module.repository.UserRepository
import org.springframework.stereotype.Service


@Service
class BoardService(private val boardRepository: BoardRepository,private val userRepository: UserRepository,private val commentRepository: CommentRepository) {

    fun createBoard(boardDto: BoardDto):Board{
        val userId=userRepository.getById(boardDto.userId)
        boardDto.apply {
            return boardRepository.save(Board(id,title,content,userId, replyList= emptyList()))
        }
    }

    fun getBoardById(boardId:String):Board{
        return boardRepository.getById(boardId.toLong())
    }

    fun deleteById(boardId: String){
        return boardRepository.deleteById(boardId.toLong())
    }

    fun modifyById(boardId: String,board:BoardModifyDto): Board {
        val getBoard=boardRepository.getById(boardId.toLong())
        getBoard.title=board.title
        getBoard.content=board.content
        return boardRepository.save(getBoard)
    }

    fun postComment(boardId: String,comment:CommentDto): Comment {
        val user= userRepository.getById(comment.userId)
        val board=boardRepository.getById(boardId.toLong())
        comment.apply {
            return commentRepository.save(Comment(id,user,board,content))
        }

    }
}