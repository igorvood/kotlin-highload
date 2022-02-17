package ru.vood.coroutines.highload.loading

import kotlinx.coroutines.*
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import ru.vood.coroutines.highload.rest.MetricsState
import ru.vood.coroutines.highload.rest.SwitchState
import java.time.LocalDateTime


@Component
class ScheduledRequests(
    val switchState: SwitchState,
    val metricsState: MetricsState
) {
    val logger = LoggerFactory.getLogger(ScheduledRequests::class.java)
    private val job: CompletableJob = SupervisorJob()
    private val crScope: CoroutineScope = CoroutineScope(Dispatchers.IO + job)

    @Scheduled(fixedRate = 1)
//    @Scheduled(fixedDelay = 1)
    fun scheduleFixedDelayTask() {
        if (switchState.switch != 0) {
            val now: LocalDateTime = LocalDateTime.now()
            val key = now.hour.toString() + ":" + now.minute + ":" + now.second
            val i = metricsState.requestMetric[key]
            if (i != null) {
                metricsState.requestMetric[key] = i + 1
            } else metricsState.requestMetric[key] = 1
//            logger.info( "Fixed rate task async - " + System.currentTimeMillis() / 1000)
            crScope.async { Thread.sleep(100) }
        }
    }
}