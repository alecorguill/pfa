package neoblik;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import beans.Player;
import model.Players;
import form.FormPlayer;

public class ChoixJeu extends HttpServlet {

	public static final String VUE = "/WEB-INF/choix_jeu.jsp";	
    public static final String CHAMP_PSEUDO = "pseudo";
	
	public void doGet( HttpServletRequest request, HttpServletResponse response )   throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}
	
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Traitement des données du formulaire */
    	String pseudo = request.getParameter( CHAMP_PSEUDO );

    	FormPlayer form = new FormPlayer();
    	
    	Player player = form.signPlayer(request);
    	player.setIsAdmin(true);
    	HttpSession session = request.getSession();
    	session.setAttribute("player", player);
    	ServletContext context = this.getServletContext();
    	Players p = (Players) context.getAttribute("players");
    	p.addPlayer(player);
    	
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    	
    }
    
}