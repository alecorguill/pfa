/**
 * This class represents a player contribution to the pot. An object of the class 
 * contains objects of this class
 */

package model;

public class PotContribution{

    private int contribution;
    
    public PotContribution() {
	contribution = 0;
    }

    /**
     * Reset contribution to 0
     */
    public void reset() {
	contribution = 0;
    }
    /**
     * Add nbChips to the contribution of the player in the 
     * current round (when he raises)
     */
    public void add(int nbChips) {
	//When a player bet for example 30 chips and wants to 
	//equalize at 100, the player will add '70' and not 100
	contribution += nbChips;
    }

    /**
     * Returns the contribution
     */
    public int getContribution() {
	return contribution;
    }

}
