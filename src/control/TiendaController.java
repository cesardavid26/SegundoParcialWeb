package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TiendaDao;
import modelo.Tienda;

/**
 * Servlet implementation class TiendaController
 */
@WebServlet("/TiendaController")
public class TiendaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TiendaController() {
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
		String action = request.getParameter("action");

		switch(action) {
		case "registro":
			String nombre = request.getParameter("nombre");
			String lema = request.getParameter("lema");
			String descripcion = request.getParameter("descipcion");
			String email = request.getParameter("email");
			String clave = request.getParameter("clave");
			String propietario = request.getParameter("propietario");
			String facebook = request.getParameter("facebook");
			String web = request.getParameter("web");
			String imagen = request.getParameter("imagen");

			Tienda t = new Tienda();
			t.setNombre(nombre);
			t.setLema(lema);
			t.setDescripcion(descripcion);
			t.setEmail(email);
			t.setClave(clave);
			t.setPropietario(propietario);
			t.setFacebook(facebook);
			t.setWeb(web);
			t.setImagen(imagen);
			TiendaDao tDao= new TiendaDao();
			
			
			tDao.insert(t);
			request.getRequestDispatcher("index.jsp").forward(request, response);

			break;
	}

}
}
