package pl.gda.pg.eti.kask.javaee.enterprise

import pl.gda.pg.eti.kask.javaee.enterprise.entities.Cave
import pl.gda.pg.eti.kask.javaee.enterprise.entities.Dragon
import java.io.Serializable
import javax.ejb.Stateless
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext


@Stateless
open class DragonService : Serializable {

    @PersistenceContext
    lateinit var em: EntityManager

    open fun findDragon(id: Int): Dragon? {
        return em.find(Dragon::class.java, id)
    }

    open fun removeDragon(dragon: Dragon) {
        em.remove(em.merge(dragon))
    }

    open fun saveDragon(dragon: Dragon) {
        if(dragon.id == null) {
            em.persist(dragon)
        } else {
            em.merge(dragon)
        }
    }

    open fun saveCave(cave: Cave) {
        if(cave.id == null) {
            em.persist(cave)
        } else {
            em.merge(cave)
        }

        cave.dragons.forEach { d ->
            saveDragon(d)
        }
    }

    open fun removeCave(cave: Cave) {
        em.remove(em.merge(cave))

        cave.dragons.forEach { d ->
            removeDragon(d)
        }
    }

    open fun findAllCaves(): List<Cave> {
        return em.createNamedQuery(Cave.FIND_ALL, Cave::class.java).resultList
    }

    open fun findCave(id: Int): Cave? {
        return em.find(Cave::class.java, id)
    }

    open fun findCavesWithDragons(): List<Cave> {
        return em.createNamedQuery(Cave.FIND_WITH_DRAGONS, Cave::class.java).resultList
    }
}
