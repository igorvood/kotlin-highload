package ru.vood.coroutines.highload.rest

import org.springframework.stereotype.Component

@Component
class MetricsState {

    val requestMetric = mutableMapOf<String, Int>()
}