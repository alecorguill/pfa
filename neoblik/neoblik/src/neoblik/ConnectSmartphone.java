package neoblik;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import beans.Player;
import model.Players;
import form.FormPlayer;

public class ConnectSmartphone extends HttpServlet {

	public static final String VUE = "/WEB-INF/connect_smartphone.jsp";	
    public static final String CHAMP_PSEUDO = "pseudo";
	
	public void doGet( HttpServletRequest request, HttpServletResponse response )   throws ServletException, IOException {
		
		String message = "";
		request.setAttribute("message", message);
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}
	
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Traitement des données du formulaire */
    	String pseudo = request.getParameter( CHAMP_PSEUDO );
    	
    	//On instance les objets session et context
    	ServletContext context = this.getServletContext();
    	HttpSession session = request.getSession();
    	Players p = (Players) context.getAttribute("players");
    	
    	//On analyse le resultat du formulaire
    	//On pourrait d�placer ce code dans un objet qui se chargerai de traiter la
    	//requete (dans l'id�al)
    	String message;
    	boolean isCorrect;
    	if(p.canConnect(pseudo)) {
    		isCorrect = true;
    		message = "Votre smartphone est connect�";
    		Player link = p.getPlayer(pseudo);
    		link.setHasSmarphone(true);
    		session.setAttribute("player", link);
    	}
    	
    	else {
    		isCorrect = false;
    		if(!p.alreadyIn(pseudo)) {
    			message = "Votre pseudo n'existe pas";
    		}
    		else {
    			message = "Un smartphone a d�ja �t� connect� pour ce pseudo";
    		}
    	}
    	
    	//R�cup�ration du type de m�thode
    	String type = request.getMethod();
    	
    	//On set les attribut pour la jsp
    	request.setAttribute("type", type);
    	request.setAttribute("isCorrect", isCorrect);
		request.setAttribute("message", message);
    	
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    	
    }
    
}