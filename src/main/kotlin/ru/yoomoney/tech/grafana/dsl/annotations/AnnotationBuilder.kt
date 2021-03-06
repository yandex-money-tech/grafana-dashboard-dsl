package ru.yoomoney.tech.grafana.dsl.annotations

import ru.yoomoney.tech.grafana.dsl.DashboardElement
import ru.yoomoney.tech.grafana.dsl.panels.Color

/**
 * Mutable builder of basic annotation information.
 *
 * Used for supplying such basic information to concrete annotation builders (see [ZabbixAnnotation.Builder]).
 *
 * @property name see [BasicAnnotation.name]
 */
@DashboardElement
class AnnotationBuilder(val name: String) {

    /**
     * See [BasicAnnotation.enabled]
     */
    var enabled: Boolean = true

    /**
     * See [BasicAnnotation.hidden]
     */
    var hidden: Boolean = false

    /**
     * See [BasicAnnotation.color]
     */
    var color: Color = Color(255, 96, 96)
}
