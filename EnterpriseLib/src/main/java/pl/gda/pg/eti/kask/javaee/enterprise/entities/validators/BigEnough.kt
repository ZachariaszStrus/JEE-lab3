package pl.gda.pg.eti.kask.javaee.enterprise.entities.validators

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass


@MustBeDocumented
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = arrayOf(BigEnoughValidator::class))
annotation class BigEnough (
        val message: String = "{pl.gda.pg.eti.kask.javaee.enterprise.entities.validators.BigEnough.BIG_ENOUGH}",

        val groups: Array<KClass<Any>> = emptyArray(),

        val payload: Array<KClass<out Payload>> = emptyArray(),

        val size: Int = 0
)
