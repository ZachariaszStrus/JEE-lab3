package pl.gda.pg.eti.kask.javaee.enterprise.view

import pl.gda.pg.eti.kask.javaee.enterprise.DragonService
import pl.gda.pg.eti.kask.javaee.enterprise.entities.Cave
import pl.gda.pg.eti.kask.javaee.enterprise.entities.Dragon
import java.io.Serializable
import javax.faces.bean.ManagedBean
import javax.faces.bean.ViewScoped

import javax.annotation.PostConstruct
import javax.ejb.EJB

/**
 *
 * @author psysiu
 */
@ViewScoped
@ManagedBean
class ListDragons : Serializable {

    @EJB
    lateinit var dragonService: DragonService

    lateinit var caves: List<Cave>


    @PostConstruct
    fun init() {
        caves = dragonService.findCavesWithDragons()
    }

    fun removeDragon(dragon: Dragon): String {
        dragonService.removeDragon(dragon)
        caves.first { it == dragon.cave }.dragons.remove(dragon)
        return "list_dragons?faces-redirect=true"
    }

    fun removeCave(cave: Cave): String {
        dragonService.removeCave(cave)
        caves = dragonService.findAllCaves()
        return "list_dragons?faces-redirect=true"
    }
}
