package com.Documents.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.Document.bdd.Classe;
import com.Document.bdd.ClasseEtId;
import com.Document.bdd.Cours;
import com.Document.bdd.MatiereEtid;


@WebServlet("/Controlleradmin")
public class ControllerAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	    public static final int TAILLE_TAMPON = 10240;
	    public static final String CHEMIN_FICHIERS = "/Tp_javaEE/src/main/webapp/WEB-INF/documents/"; // A changer
	 
    
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
			
			Cours cour = new Cours();
			List<MatiereEtid> matieres = cour.GetListCours();
			request.setAttribute("matieres",matieres );
			Classe classe = new Classe();
			List<ClasseEtId> listclassesetid = new ArrayList<ClasseEtId>();
		    listclassesetid = classe.listIdClasse();
		    request.setAttribute("listclassesetid",listclassesetid );
		    
		    
			
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
		String action=request.getParameter("action");

		if(action==null || action.equals("index")) { 
			this.getServletContext().getRequestDispatcher("/WEB-INF/admin/admin.jsp").forward(request, response);		}else if(action.equals("inscription")){
		}else if(action.equals("ajout")){
			
			String classes = request.getParameter("classes");
			String matieres = request.getParameter("matieres");
			Part part = request.getPart("fichier");
			String nomFichier = getNomFichier(part);
			
			// Si on a bien un fichier
	        if (nomFichier != null && !nomFichier.isEmpty()) {
	            String nomChamp = part.getName();
	            // Corrige un bug du fonctionnement d'Internet Explorer
	             nomFichier = nomFichier.substring(nomFichier.lastIndexOf('/') + 1)
	                    .substring(nomFichier.lastIndexOf('\\') + 1);

	            // On écrit définitivement le fichier sur le disque
	            ecrireFichier(part, nomFichier, CHEMIN_FICHIERS);

	            request.setAttribute(nomChamp, nomFichier);
	        }
	        
			request.setAttribute("classes",classes);
			request.setAttribute("matieres",matieres );
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
	
	
	 private void ecrireFichier( Part part, String nomFichier, String chemin ) throws IOException {
	        BufferedInputStream entree = null;
	        BufferedOutputStream sortie = null;
	        try {
	            entree = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON);
	            sortie = new BufferedOutputStream(new FileOutputStream(new File(chemin + nomFichier)), TAILLE_TAMPON);

	            byte[] tampon = new byte[TAILLE_TAMPON];
	            int longueur;
	            while ((longueur = entree.read(tampon)) > 0) {
	                sortie.write(tampon, 0, longueur);
	            }
	        } finally {
	            try {
	                sortie.close();
	            } catch (IOException ignore) {
	            }
	            try {
	                entree.close();
	            } catch (IOException ignore) {
	            }
	        }
	    }
	 
	  private static String getNomFichier( Part part ) {
	        for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
	            if ( contentDisposition.trim().startsWith( "filename" ) ) {
	                return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
	            }
	        }
	        return null;
	    }   

}
