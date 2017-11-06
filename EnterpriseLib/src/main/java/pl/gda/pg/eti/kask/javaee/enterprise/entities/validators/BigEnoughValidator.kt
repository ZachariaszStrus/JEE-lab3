package pl.gda.pg.eti.kask.javaee.enterprise.entities.validators

import pl.gda.pg.eti.kask.javaee.enterprise.entities.Cave
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext


class BigEnoughValidator : ConstraintValidator<BigEnough, Cave?> {
    private var size = 0

    override fun isValid(cave: Cave?, context: ConstraintValidatorContext): Boolean {
        return cave != null && cave.area >= size
    }

    override fun initialize(p0: BigEnough) {
        size = p0.size
    }

}