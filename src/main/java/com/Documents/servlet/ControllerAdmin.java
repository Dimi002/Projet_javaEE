package com.Documents.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.Document.bdd.Classe; 
import com.Document.bdd.ClasseEtId; 
import com.Document.bdd.Cours;
import com.Document.bdd.Epreuve;
import com.Document.bdd.MatiereEtid;



   
@WebServlet("/Controlleradmin")
@MultipartConfig(
		location = "C:\\JAVA EE\\Projet_javaEE\\src\\main\\webapp\\documents",  
		fileSizeThreshold=1024*1024, //1MO
		maxFileSize= 1024*1024*10,   //10MO
		maxRequestSize = 1024*1024*11  //11Mo
		)
public class ControllerAdmin extends HttpServlet { 
	private static final long serialVersionUID = 1L;
	
	   // public static final int TAILLE_TAMPON = 10240; 
	   // public static final String CHEMIN_FICHIERS = "/src/main/webapp/WEB-INF/documents/"; // A changer
	 
    
    public ControllerAdmin() {
        super(); 
        // TODO Auto-generated constructor stub 
    }
 
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action=request.getParameter("action");

		if(action==null || action.equals("index")) { 
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/admin/admin.jsp").forward(request, response);		
			}else if(action.equals("inscription")){
		
			}else if(action.equals("ajout")){
				System.out.println("--------------------------------------------- Je suis passer! -----------------------------------------");
			String message2 = "Epreuve non ajouter!";
			
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
			this.getServletContext().getRequestDispatcher("/WEB-INF/admin/admin.jsp").forward(request, response);	
			}else if(action.equals("inscription")){
		}
			else if(action.equals("ajout")){
				
				Cours cour = new Cours();
				List<MatiereEtid> matieres = cour.GetListCours();
				request.setAttribute("matieres",matieres );
				Classe classe = new Classe();
				List<ClasseEtId> listclassesetid = new ArrayList<ClasseEtId>();  
			    listclassesetid = classe.listIdClasse();
			    request.setAttribute("listclassesetid",listclassesetid );	
			    
			//----------------------------------------------------------------------------------------------	
				String classes = request.getParameter("idclasses");
				String matiere = request.getParameter("idmatieres");
				String message = "";
				String nomFichier = "";
				try {
				Part part = request.getPart("fichier");
				part.write(getFileName(part));
				message="your file has been uploaded successfully!";
			    nomFichier = getFileName(part);
				}catch(Exception ex){
					message = "Error Uploading file"+ex.getMessage(); 
				}
				//request.setAttribute("classes",classes);
				//request.setAttribute("matieres",matiere);
				//request.setAttribute("nomFichier",nomFichier);
				
				Epreuve epreuve = new Epreuve();
			    
			    boolean res = epreuve.ajoutEpreuve(nomFichier, classes, matiere);
			   if (res) message = "Epreuve Ajouter Avec succes !!";
			   System.out.println("--------------------------------------------- Je suis la"+res);
			   System.out.println("--------------------------------------------- Je suis la"+message);
			   request.setAttribute("message",message);
				
			this.getServletContext().getRequestDispatcher("/WEB-INF/admin/ajout.jsp").forward(request, response);
		}
		
          else if(action.equals("ajout2")){
        	  
				
				Cours cour = new Cours();
				List<MatiereEtid> matieres = cour.GetListCours();
				request.setAttribute("matieres",matieres );
				Classe classe = new Classe();
				List<ClasseEtId> listclassesetid = new ArrayList<ClasseEtId>();  
			    listclassesetid = classe.listIdClasse();
			    request.setAttribute("listclassesetid",listclassesetid );	
			    
			//----------------------------------------------------------------------------------------------	
				String classes = request.getParameter("idclasses");
				String matiere = request.getParameter("idmatieres");
				String message = "";
				String nomFichier = "";
				try {
				Part part = request.getPart("fichier");
				part.write(getFileName(part));
				message="your file has been uploaded successfully!";
			    nomFichier = getFileName(part);
				}catch(Exception ex){
					message = "Error Uploading file"+ex.getMessage(); 
				}
				//request.setAttribute("classes",classes);
				//request.setAttribute("matieres",matiere);
				//request.setAttribute("nomFichier",nomFichier);
				
			    
			    
			    boolean res = cour.ajoutCour(nomFichier, classes, matiere);
			   if (res) message = "Epreuve Ajouter Avec succes !!";
			   System.out.println("--------------------------------------------- Je suis la"+res);
			   System.out.println("--------------------------------------------- Je suis la"+message);
			   request.setAttribute("message",message);
				
			this.getServletContext().getRequestDispatcher("/WEB-INF/admin/ajout.jsp").forward(request, response);
		}
		
		
          else if(action.equals("ajout3")){
        	  
        	  Cours cour = new Cours();
				List<MatiereEtid> matieres = cour.GetListCours();
				request.setAttribute("matieres",matieres );
				Classe classe = new Classe();
				List<ClasseEtId> listclassesetid = new ArrayList<ClasseEtId>();  
			    listclassesetid = classe.listIdClasse();
			    request.setAttribute("listclassesetid",listclassesetid );	
			    
			//----------------------------------------------------------------------------------------------	
        	  String message="Ajout non effectuer!";
        	  String nomMatiere = request.getParameter("nom");
			  MatiereEtid matiere = new MatiereEtid();
			  boolean res =matiere.ajoutMatiere(nomMatiere);
			  if (res) message = "Ajout effectuer! !!";
			  request.setAttribute("message",message);
			this.getServletContext().getRequestDispatcher("/WEB-INF/admin/ajout.jsp").forward(request, response);
		}
			
			else if(action.equals("profil")){
			this.getServletContext().getRequestDispatcher("/WEB-INF/admin/profil.jsp").forward(request, response);
		}else if(action.equals("supression")){
			this.getServletContext().getRequestDispatcher("/WEB-INF/admin/suppression.jsp").forward(request, response);
		}else if(action.equals("membre")){
			this.getServletContext().getRequestDispatcher("/WEB-INF/admin/membre.jsp").forward(request, response);
		}else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/404.jsp").forward(request, response);
		}		
	}
	
	
	
	 
	  private static String getFileName( Part part ) {
	         String contentDisposition = part.getHeader( "content-disposition" ); 
	            if ( !contentDisposition.contains( "filename=" ) ) {
	                 return null; 
	            }
	            int beginIndex = contentDisposition.indexOf("filename=" )+10;
	            int endIndex = contentDisposition.length() -1;
	            return contentDisposition.substring(beginIndex, endIndex); 
	        }
	      
	       

}
