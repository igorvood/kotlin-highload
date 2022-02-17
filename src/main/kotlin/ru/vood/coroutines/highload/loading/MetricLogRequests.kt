package ru.vood.coroutines.highload.loading

import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import ru.vood.coroutines.highload.rest.MetricsState


@Component
class MetricLogRequests(
    val metricsState: MetricsState
) {
    val logger = LoggerFactory.getLogger(MetricLogRequests::class.java)

    @Scheduled(fixedDelay = 10000)
    fun scheduleFixedDelayTask() {

        logger.info("request per second ${metricsState.requestMetric.map { it.value }.average()}")

    }
}