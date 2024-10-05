package fr.esigelec.jee;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServClub
 */
@WebServlet("/ServClub")
public class ServClub extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServClub() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RechercheClubDAO clubDAO = new RechercheClubDAO();
		String Fed = request.getParameter("Federation");
		String Reg = request.getParameter("Region");
		System.out.println(Fed);
		request.setAttribute("clubx", clubDAO.recupererListeReg());
		request.setAttribute("clubv", clubDAO.recupererListeFed());
		request.setAttribute("clubs", clubDAO.recupererClubs(Fed,Reg));
		this.getServletContext().getRequestDispatcher("/Clubweb.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
