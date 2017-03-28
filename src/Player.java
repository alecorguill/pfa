/**
 * An object of type player represents a player in the poker game.
 * It has a hand
 */

package poker;

import java.util.*;

public class Player {

    
    private Hand hand;  //Hand of the player
    private Value value;//player's hand value
    private int stack; //Stack of the player
    private boolean folded; //Indicates if the player is still alive in the round.
    private boolean played; //Indicated if the player played at least once this 
                            //round
    //private boolean lost; //Indicates if the player lost or not
    public Player(int stackValue){
	Card c1 = new Card(Card.SPADES, Card.ACE);
	Card c2 = new Card(Card.SPADES, Card.ACE);
	ArrayList<Card> array = new ArrayList<Card>();
	array.add(c1);
	array.add(c2);
	this.value = new Value(array);
	hand    = new Hand(c1,c2);
	stack   = stackValue;
	played  = false;
	folded   = false;
    }

    /**
     * Returns the stack of the player
     */
    public int getStack(){
	return stack;
    }

    /**
     * Returns the hand composed of the starting cards
     */
    public Card[] getHand(){
	return hand.getHand();
    }
    
    /**
     * Returns the hand's value of this player
     */
    public Value getHandValue(){
	return value;
    }

    /**
     * Change the hand (two first cards) of the player
     */
    public void setHand(Card c1, Card c2){
	hand.setHand(c1, c2);
    }

    /**
     * Compute the value hand when we need to compare
     * two hands of players
     */
    public void setValue(List<Card> board){
	board.add(hand.getHand()[0]);
	board.add(hand.getHand()[1]);
	value.setCards(board); 
    }

    /**
     * Add chips at the stack
     */
    public void addChips(int nbChips)
    {
	stack += nbChips;
    }

    /**
     * This method is called when a player decided to fold
     */
    public void fold(){
	folded = true;
	played = true;
    }
    
    /**
     * Method called to invest chips in the pot,
     * either to pay the blinds or to bet. The control to 
     * validate a bet is done in the GameServer class
     */
    public void bet(int nbChips){
	stack -= nbChips;
	played = true;
    }

    /** 
     * Method called when the player decided to check
     */
    public void check(){
	played = true;
    }

    /**
     * Method to initialize the state of the player
     * when a new round (flop, turn...) has begun
     */
    public void newRound(){
	played = false;
	folded = false;
    }
    
    /**
     * Indicates if the player is all in
     */
    public boolean isAllIn() {
	return (stack <= 0);
    }

    /**
     * Indicates if the player played at least once
     * during the current round
     */
    public boolean hasPlayed() {
	return played;
    }

    /**
     * Indicates if the player is folded
     */
    public boolean isFolded() {
	return folded;
    }

    /**
     * This method compare hand value of two players.
     * the prototype is public int compare(Player p);
     * It returns a positive number if the hand of the object
     * this is better than p
     * and a negative number if it is not
     * it returns 0 if the two players have the same hand value 
     */
    public int compare(Player p){
	return value.compare(p.getHandValue());
    }

    /** 
     * Returns a string representation of player object
     */
    public String toString(){
	String res = "";
	res += "Hand = " + hand.toString() + "\n";
	res += "Value = " + value.getValueAsString() + "\n";
	res += "Stack = " + stack + "\n";
	return res;
    }
}
    

    
