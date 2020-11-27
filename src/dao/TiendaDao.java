package dao;

import modelo.Tienda;
import util.Conexion;

public class TiendaDao extends Conexion<Tienda>
	implements GenericDao<Tienda>{
	public TiendaDao() {
		super(Tienda.class);
	}
public Tienda validar(String email, String clave) {
		
		Tienda t = (Tienda)this.getEm().createQuery("SELECT e FROM Tienda e where email=:email and clave=:clave")
				.setParameter("email", email)
				.setParameter("clave", clave)
				.getSingleResult();
		
		return t;
	}
}
