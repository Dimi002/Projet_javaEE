package com.Documents.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Document.bdd.Authentification;
import com.Document.bdd.Classe;
import com.Document.bdd.Utilisateur;
import com.Document.bdd.Cours;
import com.Document.bdd.Epreuve;
import com.Document.bdd.MatiereEtid;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		if(action==null || action.equals("index")) { 
			this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		}else if(action.equals("inscription")){
			String disconnect=request.getParameter("disconnect");
			if(disconnect.equals("end")) {
				HttpSession session = request.getSession();
				session.invalidate();
				this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
			}
			this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
		}else if(action.equals("cours")){
			Cours cour = new Cours();
			Epreuve epreuve = new Epreuve();
			Classe _classe = new Classe();
			String classe = request.getParameter("classe");
			String idClasse = _classe.getIdClasse(classe);
			List<MatiereEtid> matieres = cour.GetListCours();
			request.setAttribute("matieres",matieres );
			System.out.println("----->"+matieres);
			request.setAttribute("classe",classe);
			
			//------------------------ GESTION DES EPREUVES ----------------------
			String matiere = request.getParameter("matiere");
			List<Epreuve> epreuves = epreuve.getEpreuve(idClasse,matiere);
			request.setAttribute("epreuves",epreuves );
			this.getServletContext().getRequestDispatcher("/WEB-INF/cours.jsp").forward(request, response);
		}else if(action.equals("epreuves")){
			this.getServletContext().getRequestDispatcher("/WEB-INF/epreuves.jsp").forward(request, response);
		}else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/404.jsp").forward(request, response);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
		String action=request.getParameter("action");
		if(action==null || action.equals("index")) { 
			String userName = request.getParameter("username");
			String passWord = request.getParameter("password");
			
			Authentification authentification = new Authentification();
		Utilisateur user ;
		user=authentification.EffectuConnexion(userName,passWord);
//		String _nom =authentification.EffectuConnexion(userName,passWord).getNom();
//		String _prenom =authentification.EffectuConnexion(userName,passWord).getPrenom();
		if(user!=null ) {
			HttpSession Session = request.getSession();
			Session.setAttribute("nom", user.getNom());
			Session.setAttribute("prenom", user.getPrenom());
			this.getServletContext().getRequestDispatcher("/WEB-INF/cours.jsp").forward(request, response);
			}else {
//	    request.setAttribute("nom",_nom );
//		request.setAttribute("prenom",_prenom );
		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
			}
		}else if(action.equals("inscription")){
			this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
		}else if(action.equals("cours")){
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/cours.jsp").forward(request, response);
		}else if(action.equals("epreuves")){
			this.getServletContext().getRequestDispatcher("/WEB-INF/epreuves.jsp").forward(request, response);
		}else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/404.jsp").forward(request, response);
		}
		
		
		
	}

}
