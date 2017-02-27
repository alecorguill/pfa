package beans;

public class Player {
	
	private String pseudo;
	private boolean isAdmin;
	private boolean hasSmartphone;
	
	
	public Player() {
		this.isAdmin       = false;
		this.hasSmartphone = false;
	}
	
	public String getPseudo(){
		return this.pseudo;
	}
	
	public void setPseudo(String pseudo){
		this.pseudo = pseudo;
	}
	
	public boolean getIsAdmin(){
		return this.isAdmin;
	}
	
	public boolean getHasSmartphone() {
		return this.hasSmartphone;
	}
	
	public void setHasSmarphone(boolean b) {
		this.hasSmartphone = b;
	}
	public void setIsAdmin(boolean isAdmin){
		this.isAdmin = isAdmin;
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
