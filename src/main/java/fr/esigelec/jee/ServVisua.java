package fr.esigelec.jee;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServVisua
 */
@WebServlet("/ServVisua")
public class ServVisua extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServVisua() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 Rechercheinfos tablerechercheinfos= new Rechercheinfos();
		 RechercheClubDAO club = new RechercheClubDAO();
		    String Cod=request.getParameter("Commune");
		    String Fed=request.getParameter("Nomfederation");
		    
		    request.setAttribute("clubos", club.recupererListeCommune());
			request.setAttribute("clubx", club.recupererListeReg());
			request.setAttribute("clubv", club.recupererListeFed());
			request.setAttribute("infosclub", tablerechercheinfos.recupererCode_communelicen(Cod,Fed));
			this.getServletContext().getRequestDispatcher("/visualisation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
