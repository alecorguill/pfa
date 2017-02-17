package beans;

public class Player {
	
	private String pseudo;
	
	public String getPseudo(){
		return this.pseudo;
	}
	
	public void setPseudo(String pseudo){
		this.pseudo = pseudo;
	}
	
	@Override
	public boolean equals(Object obj){
		
		if (this == obj) {
			return true;
		}
		
		if (obj == null) {
			return false;
		}
		
		if (getClass() != obj.getClass()) {
			return false;
		}
		
		Player p = (Player) obj;
		return pseudo.equals(p.getPseudo());
	}
	
	@Override
	public String toString(){
		return pseudo;
	}
}
