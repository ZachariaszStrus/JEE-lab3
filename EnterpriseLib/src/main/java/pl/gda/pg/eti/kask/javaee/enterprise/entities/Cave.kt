package pl.gda.pg.eti.kask.javaee.enterprise.entities

import javax.persistence.*


@Entity
@NamedQueries(
        NamedQuery(name = Cave.FIND_ALL, query = "SELECT c FROM Cave c"),
        NamedQuery(name = Cave.FIND_WITH_DRAGONS,
                query = "SELECT c FROM Cave c LEFT JOIN FETCH c.dragons")
)
data class Cave (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int? = null,

        var area: Int = 0,

        @OneToMany(mappedBy = "cave")
        var dragons: MutableList<Dragon> = mutableListOf()
) {
    companion object {
        const val FIND_ALL = "Cave.findAll"
        const val FIND_WITH_DRAGONS = "Cave.findAllWithDragons"
    }

    override fun toString(): String {
        return "Cave $id, area: $area"
    }

    override fun equals(other: Any?): Boolean {
        return (other as Cave).id == id
    }

    override fun hashCode(): Int {
        return id ?: 0
    }
}