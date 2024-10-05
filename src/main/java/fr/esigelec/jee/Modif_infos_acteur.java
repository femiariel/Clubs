package fr.esigelec.jee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.esigelec.model.ActeurInfos;



/**
 * Servlet implementation class Modif_infos_acteur
 */
@WebServlet("/Modif_infos_acteur")
public class Modif_infos_acteur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InfosActeurDAO infosActeurDAO = new InfosActeurDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modif_infos_acteur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int id = Integer.parseInt(request.getParameter("id"));
		String titre = request.getParameter("txtTitre");
		String infos = request.getParameter("txtContenu");
		
		HttpSession session = request.getSession(true);
		session.setAttribute("id", id);
		session.setAttribute("titreModification", titre);
		session.setAttribute("infosModification", infos);
		
		request.getRequestDispatcher("/page_acteur_modifier.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String titre = request.getParameter("txtTitre");
		String infos = request.getParameter("txtContenu");
		
		HttpSession session = request.getSession(true);
		session.setAttribute("id", id);
		session.setAttribute("titreModification", titre);
		session.setAttribute("infosModification", infos);
		
		ActeurInfos newInfos = new ActeurInfos();
		newInfos.setId(id);
		newInfos.setTitre(titre);
		newInfos.setInformations(infos);
		
		infosActeurDAO.modifier_infos(newInfos);
		
		request.getRequestDispatcher("/page_acteur_monde_sportif.jsp").forward(request, response);
	}

}
