package fr.esigelec.jee;
import fr.esigelec.model.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServPropCommune
 */
@WebServlet("/ServPropCommune")
public class ServPropCommune extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServPropCommune() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProportionDAO p= new ProportionDAO();
		RechercheClubDAO rec= new RechercheClubDAO();
		String b=request.getParameter("Region");
		
		request.setAttribute("clubx", p.recupererListeRegProp());
		request.setAttribute("licos", p.recupererPropCommune(b));
		this.getServletContext().getRequestDispatcher("/vis.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
