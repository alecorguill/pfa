package model;
import java.util.*;
import beans.Player;

public class Players {
	private ArrayList<Player> players;
	
	public Players(){
		players = new ArrayList<Player>();
	}
	
	public ArrayList<Player> getPlayers() {
		return this.players;
	}
	
	public Player getPlayer(String pseudo) {
		for(Player p : this.players) {
			if(p.getPseudo().equals(pseudo))
				return p;
		}
		return null;
	}
	
	public void addPlayer(Player player){
		if(!alreadyIn(player))
			players.add(player);
	}
	
	public boolean alreadyIn(Player player){
		return players.contains(player);
	}
	
	public boolean alreadyIn(String pseudo){
		for(Player p : this.players) {
			if(p.getPseudo().equals(pseudo))
				return true;
		}
		return false;
	}
	
	/*
	 * Return true if the player with this pseudo exists and has no 
	 * smarphone connected
	 * false if not
	 */
	public boolean canConnect(String pseudo){
		for(Player p : this.players) {
			if(p.getPseudo().equals(pseudo))
				return !p.getHasSmartphone();
		}
		return false;
	}

	/*
	 * Return true if all players are ready to enter the game
	 * false if not
	 */
	public boolean ready(){
		for(Player p : this.players){
			if(!p.getHasSmartphone())
				return false;
		}
		return true;
	}
	public int nbPlayers(){
		return players.size();
	}
	
	@Override
	public String toString(){
		return players.toString();
	}
}
