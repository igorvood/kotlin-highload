package ru.vood.coroutines.highload.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("switch")
class SwitchController(val switchState: SwitchState) {

    @GetMapping("/{id}", produces = ["application/json"])
    fun getBook(@PathVariable id: Int): Int {
        switchState.switch = id
        return id
    }
}