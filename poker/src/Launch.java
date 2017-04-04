package model;

import java.util.*;

public class Launch{
    public static void main(String[] args){
	ArrayList<String> oui = new ArrayList<String>();
	oui.add("Jacques");
	oui.add("Bob");
	GameServer game = new GameServer(oui);
	game.run();
    } 
}
