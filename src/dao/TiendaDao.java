package dao;

import modelo.Tienda;
import util.Conexion;

public class TiendaDao extends Conexion<Tienda>
	implements GenericDao<Tienda>{
	public TiendaDao() {
		super(Tienda.class);
	}
}
