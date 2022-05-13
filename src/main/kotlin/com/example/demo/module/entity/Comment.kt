package com.example.demo.module.entity

import javax.persistence.*

@Entity
@Table(name="comment")
data class Comment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long=0,

    @ManyToOne
    @JoinColumn(name="userId")
    val user:User,

    @ManyToOne
    @JoinColumn(name="boardId")
    val board:Board,

    val content:String,
)
