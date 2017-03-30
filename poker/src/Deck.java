/**
 * Object of type Deck represents a set of cards
 */

package model;

import java.util.*;


public class Deck{


    private ArrayList<Card> deck; //The deck of cards 
    


    /**
     * Constructor of a Deck, 
     */

    public Deck(){
	deck = new ArrayList<Card>(); 
        init();
    }

    /**
     * Return the card on the top of the deck and removes it from the deck
     */
    public Card draw(){
	Card tmp = deck.get(0);
	deck.remove(0);
	return tmp;
    }
	
    /**
     * Remove the card on the top without returning it
     * Corresponds to the card you burn before the flop and turn and river
     */
    public void burn(){
	deck.remove(0);
    }


    /**
     * Shuffle the deck using java library method
     */
    public void shuffle(){
	Collections.shuffle(deck);
    }

    //Maybe implement a size method that return the number of cards in the deck

    /**
     * Return the number of cards in the deck
     */
    public int size(){
	return deck.size();
    }

    /**
     * Initialize the deck
     */
    public void init(){
	deck.clear();
	int i,j;
	for(i=0; i<4; ++i){
	    for(j=2; j<15; ++j){
		Card c = new Card(i,j);
		deck.add(c);
	    }
	}
    }

    /**
     * Prints the list of all card in the deck
     */
    public String toString(){
	Iterator<Card> deckIterator = deck.iterator();
	String res = "";
	while(deckIterator.hasNext())
	    res += (deckIterator.next()).toString() + "\n";
	
	return res;
	
    }
    
}
