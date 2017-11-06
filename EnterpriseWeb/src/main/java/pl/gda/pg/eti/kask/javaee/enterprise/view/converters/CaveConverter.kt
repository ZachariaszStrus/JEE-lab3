package pl.gda.pg.eti.kask.javaee.enterprise.view.converters;

import pl.gda.pg.eti.kask.javaee.enterprise.DragonService
import pl.gda.pg.eti.kask.javaee.enterprise.entities.Cave
import javax.faces.bean.ManagedBean
import javax.faces.bean.RequestScoped
import javax.faces.component.UIComponent
import javax.faces.context.FacesContext
import javax.ejb.EJB
import javax.faces.convert.Converter

/**
 *
 * @author psysiu
 */
@ManagedBean
@RequestScoped
class CaveConverter : Converter {

    @EJB
    lateinit var dragonService: DragonService

    override fun getAsObject(context: FacesContext?, component: UIComponent?, value: String?): Any? {
        if("---" == value) {
            return null
        }
        val cave = dragonService.findCave(value!!.toInt())
        return cave
    }

    override fun getAsString(context: FacesContext?, component: UIComponent?, value: Any?): String {
        if(value == null) {
            return "---"
        }
        return (value as Cave).id.toString()
    }
}
