package fr.esigelec.jee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.esigelec.model.*;
/**
 * Servlet implementation class ServClubRegion
 */
@WebServlet("/ServClubRegion")
public class ServClubRegion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServClubRegion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RechercheRegionDAO regionDAO = new RechercheRegionDAO();
		String Reg=request.getParameter("Region");
		request.setAttribute("clubx", regionDAO.recupererListeReg());
		request.setAttribute("clubs", regionDAO.recupererClubsRegion(Reg));
		this.getServletContext().getRequestDispatcher("/Cartefede.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
