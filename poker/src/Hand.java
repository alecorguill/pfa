/**
 * An object of the Hand reprensents a set of 2 cards of type Card
 */

package model;



public class Hand{

    private Card hand[];
    
    
    /**
     * Creates a hand with 2 cards
     */
    public Hand(Card c1, Card c2){
	hand = new Card[2];
	hand[0] = c1;
	hand[1] = c2;
    }

    /**
     * Returns the hand
     */ 
    public Card[] getHand(){
	return hand;
    }
    
    /**
     * Change the hand with the given cards
     */
    public void setHand(Card c1, Card c2){
	hand[0] = c1;
	hand[1] = c2;
    }

    /**
     * Returns a string representation of the Hand, essentially using
     * the toString function of the object Card
     */
    public String toString(){
	return this.hand[0].toString() + this.hand[1].toString();
    }

}

//end class Hand
