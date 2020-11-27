package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ServicioDao;
import dao.TiendaDao;
import modelo.Servicio;
import modelo.Tienda;

/**
 * Servlet implementation class ServicioController
 */
@WebServlet("/ServicioController")
public class ServicioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServicioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TiendaDao tDao = new TiendaDao();
		Tienda t = new Tienda();
		
		ServicioDao sDao = new ServicioDao();
		
		String action = request.getParameter("action");
		switch (action) {
		case "registro":
			String nombre = request.getParameter("nombre");
			String descripcion = request.getParameter("descripcion");
			Tienda tienda = tDao.find(Integer.parseInt(request.getParameter("idtienda")));
		
			Servicio s = new Servicio();
			s.setNombre(nombre);
			s.setDescripcion(descripcion);
			s.setTiendaBean(tienda);
			sDao.insert(s);
			request.getSession().setAttribute("tienda", t);
			request.getRequestDispatcher("tiendaView/servicios.jsp").forward(request, response);
			break;
		}
	}

}
