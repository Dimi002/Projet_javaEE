package com.Documents.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Controlleradmin")
public class ControllerAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    
    public ControllerAdmin() {
        super();
        // TODO Auto-generated constructor stub 
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action=request.getParameter("action");

		if(action==null || action.equals("index")) { 
			this.getServletContext().getRequestDispatcher("/WEB-INF/admin/admin.jsp").forward(request, response);		}else if(action.equals("inscription")){
		}else if(action.equals("ajout")){
			this.getServletContext().getRequestDispatcher("/WEB-INF/admin/ajout.jsp").forward(request, response);
		}else if(action.equals("profil")){
			this.getServletContext().getRequestDispatcher("/WEB-INF/admin/profil.jsp").forward(request, response);
		}else if(action.equals("supression")){
			this.getServletContext().getRequestDispatcher("/WEB-INF/admin/suppression.jsp").forward(request, response);
		}else if(action.equals("membre")){
			this.getServletContext().getRequestDispatcher("/WEB-INF/admin/membre.jsp").forward(request, response);
		}else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/404.jsp").forward(request, response);
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
