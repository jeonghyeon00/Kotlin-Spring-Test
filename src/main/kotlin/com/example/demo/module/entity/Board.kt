package com.example.demo.module.entity
import javax.persistence.*
import com.example.demo.module.entity.User

@Entity
@Table(name="board")
class Board (
    @Id
    @GeneratedValue
    val Idx: Long,
    val title: String,
    val content: String,
    @ManyToOne
    @JoinColumn(name = "userId")
    val user:User

)