package ru.yandex.money.tools.grafana.dsl.metrics

import ru.yandex.money.tools.grafana.dsl.DashboardElement
import ru.yandex.money.tools.grafana.dsl.json.emptyJsonArray
import ru.yandex.money.tools.grafana.dsl.json.jsonObject

/**
 * Variable that contains interval values that can be used in queries.
 *
 * @author Dmitry Komarov (komarovdmitry@yamoney.ru)
 * @since 7/23/18
 */
class ZabbixMetric private constructor(
    private val mode: Mode,
    private val group: String = "",
    private val application: String = "",
    private val host: String = "",
    private val item: String = "",
    private val showDisabledItems: Boolean = false,
    private val useCaptureGroups: Boolean = false
) : DashboardMetric {

    override fun toJson() = jsonObject {
        "group" to jsonObject {
            "filter" to group
        }
        "application" to jsonObject {
            "filter" to application
        }
        "host" to jsonObject {
            "filter" to host
        }
        "item" to jsonObject {
            "filter" to item
        }
        "functions" to emptyJsonArray()
        "mode" to mode.id
        "options" to jsonObject {
            "showDisabledItems" to showDisabledItems
        }
        "useCaptureGroups" to useCaptureGroups
    }

    @DashboardElement
    class Builder {

        open class Metrics {
            open var group = ""

            open var application = ""

            open var host = ""

            open var item = ""

            open var showDisabledItems = false

            internal fun createMetrics() = ZabbixMetric(
                mode = Mode.METRICS,
                group = group,
                application = application,
                host = host,
                item = item,
                showDisabledItems = showDisabledItems
            )
        }

        class Text : Metrics() {
            var useCaptureGroups = false

            internal fun createText() = ZabbixMetric(
                mode = Mode.TEXT,
                group = group,
                application = application,
                host = host,
                item = item,
                showDisabledItems = showDisabledItems
            )
        }
    }

    private enum class Mode(val id: Int) {
        METRICS(0),
        TEXT(2)
    }
}
