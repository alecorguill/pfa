/**
 * This class represents the round pot
 */

package poker;
import java.util.*;

public class Pot {
    
    /**
     * We associate player with their pot contribution
     * to get the potContribution of a player faster 
     * if we used an array, we would have had to browse
     * the array to find the potContribution associated to the
     * player.
     */
    private HashMap<Player, PotContribution> potContributions;

    //Maybe a boolean sidePot with indicates whether this pot is a side pot
    //not 100% sure of the use

    public Pot(ArrayList<Player> players) {
	int size = players.size();
	potContributions = new HashMap<Player, PotContribution>(size);
	for(Player p : players) {
	    potContributions.put(p, new PotContribution());
	}
    }

    /**
     * Returns the contribution of a player
     */
    public int getContribution(Player p){
	return potContributions.get(p).getContribution();
    }

    /**
     * Returns the total pot of the round 
     */
    public int getPot(){
	int pot = 0;
	for (Map.Entry<Player, PotContribution> pair : potContributions.entrySet())
	    pot += pair.getValue().getContribution();
	return pot;
    }

    /**
     * Reset all the contributions to 0
     */
    public void reset() {
	for(Map.Entry<Player, PotContribution> pair : potContributions.entrySet())
	    pair.getValue().reset();
    }

    /**
     * Add nbChips to the contribution associated with the player
     */
    public void addContribution(int nbChips, Player p){
	potContributions.get(p).add(nbChips);
    }

    /**
     * Returns the maximum value in the HashMap
     */
    public int maxHashValue() {
	Map.Entry<Player, PotContribution> maxEntry = null;      
	PotContributionCompare comparator = new PotContributionCompare();
	for (Map.Entry<Player, PotContribution> pair : potContributions.entrySet())
	    {
		if (maxEntry == null ||
		    comparator.compare(pair.getValue(),maxEntry.getValue()) > 0)
		    {
			maxEntry = pair;
		    }
	    }
	return maxEntry.getValue().getContribution();
    }

    /**
     * Returns true if all the non folded and non allin player's 
     * contribution are equal false if not
     */
    public boolean contributionEqual() {
	Player current;
	PotContribution pc;
	boolean bool = true;
	int value = maxHashValue();
	for(Map.Entry<Player, PotContribution> pair : potContributions.entrySet()) {
	    current = pair.getKey();
	    pc = pair.getValue();
	    if(!current.isFolded() && !current.isAllIn()) {
		if(pc.getContribution() != value)
		    bool = false;
	    }
	}
	return bool;
    }

    /**
     * This method returns a boolean if a player 
     * get into a blow
     */
    public boolean alreadyRaised() {
	return true;
    }

    public String toString(){
	String res = "";
	int k = 0;
	for (Map.Entry<Player, PotContribution> pair : potContributions.entrySet()){
	    res += /*"Player = " + k +
		    */"\nContribution = " + pair.getValue().getContribution() + " "/*+ " ; hasPlayed : " + pair.getKey().hasPlayed() + " ; isFolded : " + pair.getKey().isFolded() + " ; Stack : " + pair.getKey().getStack();*/;
	    res += "Player : " + pair.getKey();
	    res += "\n";
	    k++;
	}
	return res;
    }
}
