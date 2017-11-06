package pl.gda.pg.eti.kask.javaee.enterprise.entities

import pl.gda.pg.eti.kask.javaee.enterprise.entities.validators.BigEnough
import javax.persistence.*

@Entity
@NamedQuery(name = Dragon.FIND_ALL, query = "SELECT d FROM Dragon d")
data class Dragon (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int? = null,

        var name: String = "",

        var gold: Int = 0,

        @Enumerated(value = EnumType.STRING)
        var color: DragonColor = DragonColor.GOLD,

        @ManyToOne
        @BigEnough(size = 100)
        var cave: Cave? = null
) {
    companion object {
        const val FIND_ALL = "Dragon.findAll"
    }

    override fun equals(other: Any?): Boolean {
        return (other as Dragon).id == id
    }

    override fun hashCode(): Int {
        return id ?: 0
    }
}

