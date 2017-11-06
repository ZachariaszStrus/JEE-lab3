package pl.gda.pg.eti.kask.javaee.enterprise.view.converters

import pl.gda.pg.eti.kask.javaee.enterprise.entities.DragonColor
import javax.faces.bean.ManagedBean
import javax.faces.bean.RequestScoped
import javax.faces.convert.EnumConverter


@ManagedBean
@RequestScoped
class DragonColorConverter : EnumConverter(DragonColor::class.java)