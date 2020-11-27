package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TiendaDao;
import modelo.Tienda;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
		HttpSession sesion = request.getSession();
        String action = request.getParameter("action");
		
		switch(action){
		
		case "ingresar":
			String email = request.getParameter("email");
			String clave = request.getParameter("clave");
			Tienda t = new Tienda();
			
			TiendaDao tdao = new TiendaDao();
			
			/*
			if (t!=null ) {
				sesion.setAttribute("tienda", t);
				request.getRequestDispatcher("tiendaView/servicios.jsp").forward(request, response);
				
			}else 
			if(t==null){
				
				request.getRequestDispatcher("tiendaView/login.jsp").forward(request, response);
				
				
			}
			*/
			try {
				 t = tdao.validar(email, clave);
				if (t != null) {
					
						request.getSession().setAttribute("tienda", t);
						request.getRequestDispatcher("tiendaView/servicios.jsp").forward(request, response);
					} else {
						response.sendRedirect(request.getContextPath() + "tiendaView/login.jsp");
					}
				}
			catch (Exception ex) {
				response.sendRedirect(request.getContextPath() + "tiendaView/login.jsp");
			}
			
			break;
	}

	}
}
