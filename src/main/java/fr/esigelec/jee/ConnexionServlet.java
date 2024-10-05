package fr.esigelec.jee;

import fr.esigelec.model.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
* Servlet implementation class ConnexionServlet
*/
@WebServlet("/connexionServlet")
public class ConnexionServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
public ConnexionServlet() {
	super();
	// TODO Auto-generated constructor stub
}

/**
 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
 */

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	
}
/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String mail = request.getParameter("l_mail");
	String motdp = request.getParameter("le_pass");

	HttpSession session = request.getSession();
	ConnexionDAO connexion = new ConnexionDAO();
	User u= connexion.Sess(mail, motdp);
	String n=u.getNom();
	String m= u.getPrenom();
	String f= u.getFederation();
	String c= u.getCommune();
	String ro=u.getRole();
	session.setAttribute("nom", n);
	session.setAttribute("prenom", m);
	session.setAttribute("commune", c);
	session.setAttribute("federation", f);
	session.setAttribute("role", ro);
	
	if(connexion.check_connexion(mail, motdp, session)==true) {
		switch(connexion.get_role(mail)) {
			case "0" :
				request.getRequestDispatcher("page_grand_public.jsp").forward(request, response);
				break;
			case "1" :
				request.getRequestDispatcher("Page_elu.jsp").forward(request, response);
				break;
			case "2" :
				request.getRequestDispatcher("page_acteur_monde_sportif.jsp").forward(request, response);
				break;
		}
	} else {
		System.err.println("Identifiant ou mot de passe incorrect.");
		request.setAttribute("error", "Identifiant ou mot de passe incorrect.");
		RequestDispatcher rd = request.getRequestDispatcher("connexion.jsp");
		rd.forward(request, response);
	}
}

}