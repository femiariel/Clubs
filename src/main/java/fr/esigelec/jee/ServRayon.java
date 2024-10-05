package fr.esigelec.jee;
import fr.esigelec.model.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServRayon
 */
@WebServlet("/ServRayon")
public class ServRayon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServRayon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RechercheRayon rechercheRayon = new RechercheRayon();
		RechercheClubDAO cl= new RechercheClubDAO();
		String com = request.getParameter("Commune");
		String Regi= request.getParameter("Region");
		String Ray= request.getParameter("Rayon");
		
		String Fede= request.getParameter("Federation");
		request.setAttribute("clubos", cl.recupererListeCommune());
		request.setAttribute("clubv", rechercheRayon.recupererListeFed());
		request.setAttribute("clubx", rechercheRayon.recupererListeReg());
		request.setAttribute("club", rechercheRayon.recupererClubRay(com));
		request.setAttribute("clubs", rechercheRayon.recupererClubsRayon(Regi, Ray,Fede));
		this.getServletContext().getRequestDispatcher("/CarteRay.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
