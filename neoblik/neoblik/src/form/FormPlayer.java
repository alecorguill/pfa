package form;

import beans.Player;

import javax.servlet.http.HttpServletRequest;

public class FormPlayer {
	private static final String CHAMP_PSEUDO = "pseudo";
	
	public Player signPlayer(HttpServletRequest request){
		String pseudo = getValue(request, CHAMP_PSEUDO);
		
		Player player = new Player();
		
		player.setPseudo(pseudo);
		
		return player;
		
	}
	
	private static String getValue(HttpServletRequest request, String champ){
	    String value = request.getParameter( champ );
	    if ( value == null || value.trim().length() == 0 ) {
	        return null;
	    } else {
	        return value.trim();
	    }
	}
}
