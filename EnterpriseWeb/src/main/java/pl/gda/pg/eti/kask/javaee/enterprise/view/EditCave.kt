package pl.gda.pg.eti.kask.javaee.enterprise.view

import pl.gda.pg.eti.kask.javaee.enterprise.DragonService
import pl.gda.pg.eti.kask.javaee.enterprise.entities.Cave
import java.io.Serializable
import javax.ejb.EJB
import javax.faces.bean.ManagedBean
import javax.faces.bean.ViewScoped


@ViewScoped
@ManagedBean
class EditCave : Serializable {

    @EJB
    lateinit var dragonService: DragonService

    var caveId: Int = 0
    lateinit var cave: Cave

    fun init() {
        cave = dragonService.findCave(caveId) ?: Cave()
    }

    fun saveCave(): String {
        dragonService.saveCave(cave)
        return "list_dragons?faces-redirect=true"
    }

    fun getTitle(): String {
        return if(caveId == 0) {
            "Nowa jaskinia"
        } else {
            "Jaskinia nr $caveId"
        }
    }
}