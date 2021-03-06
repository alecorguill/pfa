/**
 * An object of type Card represents a playing card from a
 * standard Poker deck.  The card has a suit, which
 * can be spades, hearts, diamonds, clubs.  A spade, heart,
 * diamond, or club has one of the 13 values: ace, 2, 3, 4, 5, 6, 7,
 * 8, 9, 10, jack, queen, or king. 
 */

package model;
import java.util.*;

public class Card {
   
    public final static int SPADES = 0;   // Codes for the 4 suits.
    public final static int HEARTS = 1;
    public final static int DIAMONDS = 2;
    public final static int CLUBS = 3;
   
    
    public final static int JACK = 11;   // Codes for the non-numeric cards. 
    public final static int QUEEN = 12;  //   Cards 2 through 10 have their  
    public final static int KING = 13;   //   numerical values for their codes.
    public final static int ACE = 14;    //Still hesitating on whether i should give
                                        //the lowest or highest to ace
   
    /**
     * This card's suit, one of the constants SPADES, HEARTS, DIAMONDS,
     * CLUBS.  The suit cannot be changed after the card is
     * constructed.
     */
    private final int suit; 
   
    /**
     * The card's value.  For a normal card, this is one of the values
     * 1 through 14, with 14 representing ACE. The value cannot be changed
     * after the card is constructed.
     */
    private final int value;
   
    /**
     * Creates a card with a specified suit and value.
     * @param theValue the value of the new card. The value must be in the range 
     * 1 through 14, with 14 representing an Ace.
     * You can use the constants Card.ACE, Card.JACK, Card.QUEEN, and Card.KING.  
     * @param theSuit the suit of the new card.  This must be one of the values
     * Card.SPADES, Card.HEARTS, Card.DIAMONDS, Card.CLUBS.
     * @throws IllegalArgumentException if the parameter values are not in the
     * permissible ranges
     */
    public Card(int theSuit, int theValue){
	if (theSuit != SPADES && theSuit != HEARTS && theSuit != DIAMONDS && 
            theSuit != CLUBS)
	    throw new IllegalArgumentException("Illegal playing card suit");
	if (theValue < 1 || theValue > 14)
	    throw new IllegalArgumentException("Illegal playing card value");
	value = theValue;
	suit = theSuit;
    }

    /**
     * Returns the suit of this card.
     * @returns the suit, which is one of the constants Card.SPADES, 
     * Card.HEARTS, Card.DIAMONDS, Card.CLUBS
     */
    public int getSuit(){
	return suit;
    }
   
    /**
     * Returns the value of this card.
     * @return the value, which is one of the numbers 1 through 14.
     */
    public int getValue(){
	return value;
    }
   
    /**
     * Returns a String representation of the card's suit.
     * @return one of the strings "Spades", "Hearts", "Diamonds", "Clubs".
     */
    public String getSuitAsString(){
	switch ( suit ) {
	case SPADES:   return "Spades";
	case HEARTS:   return "Hearts";
	case DIAMONDS: return "Diams";
	case CLUBS:    return "Clubs";
	default:       return "Spades";
	}
    }
   
    /**
     * Returns a String representation of the card's value.
     * @return for a regular card, one of the strings "Ace", "2",
     * "3", ..., "10", "Jack", "Queen", or "King".
     */
    public String getValueAsString(){
	    switch ( value ) {
	    case 14:   return "A";
	    case 2:   return "2";
	    case 3:   return "3";
	    case 4:   return "4";
	    case 5:   return "5";
	    case 6:   return "6";
	    case 7:   return "7";
	    case 8:   return "8";
	    case 9:   return "9";
	    case 10:  return "10";
	    case 11:  return "J";
	    case 12:  return "Q";
	    default:  return "K";
	    }
    }
   
    /**
     * Return a boolean if the two cards are the same value
     */
    public boolean equals(Card c){
	return suit == c.getSuit() && value == c.getValue();
    }

    /**
     * Returns a string representation of this card, including both
     * its suit and its value.  Sample return values
     * are: "Queen of Hearts", "10 of Diamonds", "Ace of Spades",
     */
    public String toString(){
	return getValueAsString() + " of " + getSuitAsString();
    }

} // end class Card

