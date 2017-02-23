package model;
import java.util.*;
import beans.Player;

public class Players {
	private ArrayList<Player> players;
	
	public Players(){
		players = new ArrayList<Player>();
	}
	
	public void addPlayer(Player player){
		if(!alreadyIn(player))
			players.add(player);
	}
	
	public boolean alreadyIn(Player player){
		return players.contains(player);
	}
	
	public int nbPlayers(){
		return players.size();
	}
	
	@Override
	public String toString(){
		return players.toString();
	}
}
