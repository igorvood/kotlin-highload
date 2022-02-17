package ru.vood.coroutines.highload

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class HighLoadApplication

fun main(args: Array<String>) {
    runApplication<HighLoadApplication>(*args)
}
