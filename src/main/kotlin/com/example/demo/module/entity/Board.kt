package com.example.demo.module.entity
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name="board")
class Board(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    var title: String,
    var content: String,
    @ManyToOne
    @JoinColumn(name = "userId")
    val user: User,
    @JsonIgnoreProperties("board")
    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
    var replyList:List<Comment>,
)