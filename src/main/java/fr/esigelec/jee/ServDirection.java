package fr.esigelec.jee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServDirection
 */
@WebServlet("/ServDirection")
public class ServDirection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServDirection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ConnexionDAO connexion = new ConnexionDAO();
		HttpSession session = request.getSession();
		
		String r = (String) session.getAttribute("role");
		
		
		if (r != null) {
		    switch(r) {
		       
		        case "1" :
		            request.getRequestDispatcher("Page_elu.jsp").forward(request, response);
		            break;
		        case "2" :
		            request.getRequestDispatcher("page_acteur_monde_sportif.jsp").forward(request, response);
		            break;
		    }
		} else {
		    // faire quelque chose si la variable de session est nulle
			 request.getRequestDispatcher("page_grand_public.jsp").forward(request, response);
		}
		
		
		

} 
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
