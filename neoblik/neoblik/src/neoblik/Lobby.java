package neoblik;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Players;
import beans.Player;
import form.FormPlayer;


public class Lobby extends HttpServlet {

	public static final String VUE = "/WEB-INF/lobby.jsp";	
    public static final String CHAMP_PSEUDO = "pseudo";
	
	public void doGet( HttpServletRequest request, HttpServletResponse response )   throws ServletException, IOException {
		
		String game = (String) request.getParameter("game");
    	request.setAttribute("game", game);
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}
	
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Traitement des données du formulaire */
    	String pseudo = request.getParameter( CHAMP_PSEUDO );

    	FormPlayer form = new FormPlayer();
    	
    	Player player = form.signPlayer(request);
    	player.setIsAdmin(false);
    	HttpSession session = request.getSession();
    	session.setAttribute("player", player);
    	ServletContext context = this.getServletContext();
    	Players p = (Players) context.getAttribute("players");
    	p.addPlayer(player);
    	
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    	
    }
    
}
