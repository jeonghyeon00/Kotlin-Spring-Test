package com.example.demo


import com.example.demo.module.dto.BoardModifyDto
import com.example.demo.module.entity.Board
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.transaction.annotation.EnableTransactionManagement
import java.util.*

@EnableTransactionManagement
@SpringBootApplication
@EnableJpaRepositories
@EnableAsync
class DemoApplication



fun main(args: Array<String>) {
		runApplication<DemoApplication>(*args)
	}

