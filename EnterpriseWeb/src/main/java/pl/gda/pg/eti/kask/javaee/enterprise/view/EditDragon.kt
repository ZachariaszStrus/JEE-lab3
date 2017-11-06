package pl.gda.pg.eti.kask.javaee.enterprise.view

import pl.gda.pg.eti.kask.javaee.enterprise.DragonService
import pl.gda.pg.eti.kask.javaee.enterprise.entities.Dragon
import pl.gda.pg.eti.kask.javaee.enterprise.entities.DragonColor
import java.io.Serializable
import javax.ejb.EJB
import javax.faces.bean.ManagedBean
import javax.faces.bean.ViewScoped
import javax.faces.model.SelectItem


@ViewScoped
@ManagedBean
class EditDragon : Serializable {

    @EJB
    lateinit var dragonService: DragonService

    var dragonId: Int = 0
    lateinit var dragon: Dragon
    lateinit var cavesAsSelectItems: List<SelectItem>
    lateinit var colorsAsSelectItems: List<SelectItem>

    fun init() {
        dragon = dragonService.findDragon(dragonId) ?: Dragon()

        cavesAsSelectItems = dragonService.findAllCaves().map {
            cave -> SelectItem(cave, cave.toString())
        }

        colorsAsSelectItems = DragonColor.values()
                .map { v -> SelectItem(v, v.name) }
    }

    fun saveDragon(): String {
        dragonService.saveDragon(dragon)
        return "list_dragons?faces-redirect=true"
    }
}