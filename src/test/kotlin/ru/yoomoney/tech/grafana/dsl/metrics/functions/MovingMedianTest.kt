package ru.yoomoney.tech.grafana.dsl.metrics.functions

import org.amshove.kluent.shouldEqual
import org.testng.annotations.Test
import ru.yoomoney.tech.grafana.dsl.time.m

class MovingMedianTest {
    @Test
    fun `should create metric that gets median of metric`() {
        // given
        val metric = "*.*.count" movingMedian 30.m

        // then
        metric.asString() shouldEqual "movingMedian(*.*.count, '30m')"
    }
}