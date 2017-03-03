package neoblik;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.ServletContext;
import beans.Player;
import form.FormPlayer;
import model.Players;

public class Accueil extends HttpServlet {
    public static final String VUE = "/WEB-INF/accueil.jsp";


    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Affichage de la page d'inscription */
    	ServletContext context = this.getServletContext();
    	
    	if(context.getAttribute("players") == null){
    		context.setAttribute("players", new Players());
    	}
    	
    	String nextPath = "lobby";
    	//Redirection page choix des jeu si c'est le premier joueur
    	if( ( (Players)(context.getAttribute("players")) ).nbPlayers() < 1 ){
    		nextPath = "choix_jeu";
    	}
    	
    	request.setAttribute("path", nextPath);
    	
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
    
}