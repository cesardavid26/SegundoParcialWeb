package util;

import java.util.List;

import dao.ClienteDao;
import dao.ServicioDao;
import dao.TiendaDao;
import modelo.Cliente;
import modelo.Servicio;
import modelo.Tienda;

public class Prueba {

	public static void main(String[] args) {
		/*
		Cliente cl1 = new Cliente();
		cl1.setNombre("Cesar");
		cl1.setEmail("cesardavidcp@ufps.edu.co");
		cl1.setClave("12345");
		ClienteDao cdao = new ClienteDao();
		cdao.insert(cl1);
		
		
		Tienda t1 = new Tienda();
		t1.setNombre("Wolves");
		t1.setLema("Este es el lema de Wolves");
		t1.setDescripcion("Esta es una descripcion");
		t1.setEmail("tienda@gmail.com");
		t1.setClave("2345");
		t1.setPropietario("el señor pepe");
		t1.setFacebook("https://web.facebook.com/cesar.karvajal");
		t1.setWeb("www.nadie.com");
		t1.setImagen("https://image.freepik.com/vector-gratis/concepto-tienda-supermercado-gente-supermercado_40816-713.jpg");
		TiendaDao tdao= new TiendaDao();
		tdao.insert(t1);
		
		Servicio s1 = new Servicio();
		s1.setNombre("Regalo de puños");
		s1.setDescripcion("Regalamos puños xddd");
		s1.setTiendaBean(t1);
		ServicioDao sdao= new ServicioDao(); 
		sdao.insert(s1);
		
		*/
		
		/*
		 * ClienteDao cldao = new ClienteDao();
		 
		TiendaDao tidao = new TiendaDao();
		
		Cliente cl2 = cldao.find(3);
		Tienda t2 = tidao.find(5);
		
		List <Tienda> tiendas = cl2.getTiendas();
		tiendas.add(t2);
		cl2.setTiendas(tiendas);
		
		List <Cliente> clientes = t2.getClientes();
		clientes.add(cl2);
		t2.setClientes(clientes);
		
		cldao.update(cl2);
		*/
		
		TiendaDao actualizarTienda = new TiendaDao();
		Tienda actualizar = actualizarTienda.find(3);
		actualizar.setEmail("editado@mail.com");
		actualizarTienda.update(actualizar);
	}

}
