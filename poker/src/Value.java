/**
 * This class goal is to hundle the calculation of the 
 * hand value (pair, straight)
 * The number of cards could be anything between 1 and 
 * 7. In our first version, we will most likely only 
 * use this object with 7 card (at the end of the round)
 * but i think it might be usefull to be able to 
 * calculate the value of the hand at any moment during
 * the round.
 */

package poker;
import java.util.*;
import java.lang.*;

public class Value {
    private ArrayList<Card> cards;

    /**
     * Array that contains the number of occurrence of 
     * the Card i (see value in Card.java) at the index
     * i.
     */
    private ArrayList<Integer> occValue; 
    
    /**
     * Array that contains the number of occurrence of 
     * the suit i (see value in Card.java) at the index
     * i.
     */
    private ArrayList<Integer> occSuit; 

    /**
     * Definition of the size of both occurrence array
     */
    public static final int SIZEVALUE = 15;
    public static final int SIZESUIT  = 4;

    /**
     * Now I define the ranking of the hand with static
     * variables. 0 is high card, 1 is pair etc..
     */
    public static final int HIGHCARD   = 0;
    public static final int PAIR       = 1;
    public static final int DOUBLEPAIR = 2;
    public static final int THREE      = 3;
    public static final int STRAIGHT   = 4;
    public static final int FLUSH      = 5;
    public static final int FULL       = 6;
    public static final int FOUR       = 7;
    public static final int STRFLUSH   = 8;
	
    private int value; //Represent the value of the hand
                       //Check static variable above

    /**
     * This array represents the data (the cards)
     * associated with the value of the hand.
     * For example if the value is a four of a kind
     * (A,A,A,A,7) data will contain [A,7]
     */ 
    private ArrayList<Integer> data;

    /**
     * Initialize the object value with the cards given
     * it initialize the variable value to 0
     */
    public Value(List<Card> cards){
	this.cards    = new ArrayList<Card>();
	this.cards.addAll(cards);
	//We sort the cards
	Collections.sort(this.cards,new CardCompare());
	this.data     = new ArrayList<Integer>();
	initData();
	this.value    = 0;
	this.occValue = new ArrayList<Integer>();
	this.occSuit  = new ArrayList<Integer>();
	initOcc();
	calculateOcc();
    }

    /**
     * Returns the value of the cards
     */
    public int getValue(){
	return value;
    }

    /**
     *Returns the data array
     */
    public ArrayList<Integer> getData(){
	return this.data;
    }


    /**
     * This method change the cards and recalculate the
     * occ arrays and the value
     */
    public void setCards(List<Card> cards){
	this.cards.clear();
	this.cards.addAll(cards);
	Collections.sort(this.cards,new CardCompare());
	calculateOcc();
	calculateValue();
    }
    
    /**
     * This method initializes the data array with 0
     */
    private void initData(){
	int i;
	data.clear();
	for(i=0; i<5; ++i)
	    data.add(0);
    }
    
    /**
     * This method initializes all the integer in the 
     * occurrence arrays at 0.
     */
    private void initOcc(){
	int i;
	occValue.clear();
	occSuit.clear();
	for(i=0; i<SIZEVALUE; ++i)
	    occValue.add(0);
	for(i=0; i<SIZESUIT; ++i)
	    occSuit.add(0);
    }

    /**
     * This method fill the occurrence arrays using the
     * array cards
     */
    public void calculateOcc(){
	initOcc();
	Iterator<Card> cardsIterator = cards.iterator();
	Card currentCard = new Card(Card.SPADES,Card.ACE);
	int v;
	int s;
	while(cardsIterator.hasNext()){
	    currentCard = cardsIterator.next();
	    v           = currentCard.getValue();
	    s           = currentCard.getSuit(); 
	    occValue.set(v, occValue.get(v)+1);
	    occSuit.set(s, occSuit.get(s)+1);
	}
    }
    /**
     * This method calculates the value of the cards in
     * the array cards.
     */
    public void calculateValue(){
	if(isStrFlush()){
	    value = STRFLUSH;
	}
	else if(isFour()){
	    value = FOUR;
	}
	else if(isFull()){
	    value = FULL;
	}
	else if(isFlush()){
	    value = FLUSH;
	}
	else if(isStraight()){
	    value = STRAIGHT;
	}
	else if(isThree()){
	    value = THREE;
	}
	else if(isDoublePair()){
	    value = DOUBLEPAIR;
	}
	else if(isPair()){
	    value = PAIR;
	}
	else {
	    value = HIGHCARD;
	    //we must fill the data array
	    int i;
	    initData();
	    int index = 0;
	    for (i=SIZEVALUE-1; i>=0 && index<5; --i)
		{
		    if (occValue.get(i) == 1)
			{
			    data.set(index, i);
			    ++index;
			}
		}
	}
    }

    /**
     * The next methods are all of the form public boolean isX().
     * for example public boolean isPair()
     * It returns true if the hand containing the cards in this 
     * object is a pair
     * false if not
     * Each function reinitializes the array data and fill it 
     * again with the appropriate card, for example if
     * cards = {2 of heart, 2 of clubs, 7 of diamond, 8 of spades,
                jack of heart, 3 of hearts, ACE of clubs}
     * isPair should return true and data={2,ACE,JACK,8}
     * Each function also browse the array from the end to the 
     * beginning to catch the highest card first 
     */
    public boolean isPair(){
	int i;
	initData();
	for(i=SIZEVALUE-1; i>=0; --i){
	    if(occValue.get(i) == 2){
		//We had the pair we just found
		data.set(0,i);
		int index = 1;
		//Here we had the 3 remaining cards to the hand
		for(i=SIZEVALUE-1; i>=0; --i){
		    if(occValue.get(i) == 1 &&
		       index < 4){
			data.set(index, i);
			++index;
		    }				
		}
		return true;
	    }
	}
	return false;
    }

    public boolean isDoublePair(){
	int i, count;
	count = 0;
	//We reinitialize the data array
	initData();
	for(i=SIZEVALUE-1; i>=0; --i){
	    //We had the pairs until we found 2 of them
	    if(occValue.get(i) == 2 && count<2){
		    data.set(count,i);
		    ++count;
		}
		
	}
	if(count == 2){
	    for(i=SIZEVALUE-1; i>=0 ; --i)
		//We had the remaining card to the hand
		//This card should not be part of the 
		// existing pair
		if(occValue.get(i)>0              &&
		   i != data.get(0) &&
		   i != data.get(1)){
		    data.add(count, i);
		    return true;
		}
	}
	return false;
    }

    public boolean isThree(){
	int i;
	initData();
	//We look for the occurence 3
	for(i=SIZEVALUE-1; i>=0; --i){
	    if(occValue.get(i) == 3){
		//We had the triple we just found
		data.set(0,i);
		//Now we had the remaining cards 
		//to the hand
		int index = 1;
		for(i=SIZEVALUE-1; i>=0; --i){
		    if(occValue.get(i) == 1 && index <= 2){
			data.set(index,i);
			++index;
		    }
		}
		return true;
	    }
	}
	return false;
    }
    
    public boolean isStraight(){
	int i, count, head;
	initData();
	count    = 0;
	head     = 0;
	//Case of the straight ACE,2,3,4,5
	if(occValue.get(Card.ACE) > 0 &&
	   occValue.get(2) > 0        &&
	   occValue.get(3) > 0        &&
	   occValue.get(4) > 0        &&
	   occValue.get(5) > 0        &&
	   occValue.get(6) == 0){
	    data.set(0,5);
	    return true;
	}
	//General case
	for(i=SIZEVALUE-1; i>=0; --i){
	    if(occValue.get(i) > 0){
		//We had the highest element 
		//of the straight
		if(count == 0)
		    head = i;
		++count;
	    }
	    else{
		if(count >=5){
		    data.set(0,head);
		    return true;
		}
		count = 0;
	    }
	}
	return false;
    }

    public boolean isFlush(){
	int i, j;
	boolean bool = false;
	initData();
	//We look for the occurence 5
	//in the suit array
	for(i=0; i<SIZESUIT; ++i){
	    if(occSuit.get(i) >= 5){
		//Now that we found the suit
		//We had the highest card of 
		//this suit
		int index = 0;
		int size = cards.size();
		for(j=size-1; j>=0; --j){
		    if(cards.get(j).getSuit() == i && index < 5){
			data.set(index, cards.get(j).getValue());
			++index;
		    }
		    
		}
		bool = true;
	    }
	}
	return bool;
    }

    public boolean isFull(){
	int i;
	boolean bool  = false;
	boolean found = false;
	if(isPair() && isThree()){
	    initData();
	    for(i=SIZEVALUE-1; i>=0; --i){
		//We look for the triple, no need to
		//check if its the first one because
		//there could only be one
		if(occValue.get(i) == 3)
		    data.set(0, i);
		//We look for the pair and only had
		//the first one
		if(occValue.get(i) == 2 && !found){
		    data.set(1, i);
		    found = true;
		}
	    }
	    bool = true;
	}
	else {
	    if (doubleThree())
		bool = true;
	}
	return bool;
    }

    //function for particular case of a full house
    public boolean doubleThree(){
	int i, count;
	count = 0;
	initData();
	for(i=SIZEVALUE-1; i>=0; --i){
	    if(occValue.get(i) == 3 && count<2){
		data.set(count, i);
		++count;
	    }
	}
	return count == 2;
    }

    public boolean isFour(){
	int i;
	initData();
	//We look for the occurence 4
	for(i=SIZEVALUE-1; i>=0; --i){
	    if(occValue.get(i) == 4){
		//We had the four we just found
		data.set(0,i);
		//Now we had the remaining card 
		//to the hand
		int index = 1;
		for(i=SIZEVALUE-1; i>=0; --i){
		    if(occValue.get(i) == 1 && index <= 1){
			data.set(index,i);
			++index;
		    }
		}
		return true;
	    }
	}
	return false;
    }

    public boolean isStrFlush(){
	if (isFlush()){
	    int i;
	    int suit = 0; //this variable will be set to the good value
	                  //because we surely have a flush
	    for(i=0; i<SIZESUIT; ++i){
		if(occSuit.get(i) >= 5)
		    suit = i;
	    }
	    ArrayList<Integer> occStrFlush = new ArrayList<Integer>();
	    for (i = 0 ; i < SIZEVALUE ; ++i)
		occStrFlush.add(0);
	    Iterator<Card> cardsIterator = cards.iterator();
	    Card currentCard = new Card(Card.SPADES,Card.ACE);
	    int v;
	    while(cardsIterator.hasNext()){
		currentCard = cardsIterator.next();
		if (currentCard.getSuit() == suit){
		    v = currentCard.getValue();
		    occStrFlush.set(v, occStrFlush.get(v)+1);
		}
	    }
	    int count, head;
	    initData();
	    count    = 0;
	    head     = 0;
	    //Case of the straight ACE,2,3,4,5
	    if(occStrFlush.get(Card.ACE) > 0 &&
	       occStrFlush.get(2) > 0        &&
	       occStrFlush.get(3) > 0        &&
	       occStrFlush.get(4) > 0        &&
	       occStrFlush.get(5) > 0        &&
	       occStrFlush.get(6) == 0){
		data.set(0,5);
		return true;
	    }
	    //General case
	    for(i=SIZEVALUE-1; i>=0; --i){
		if(occStrFlush.get(i) > 0){
		    //We had the highest element 
		    //of the straight
		    if(count == 0)
			head = i;
		    ++count;
		}
		else{
		    if(count >=5){
			data.set(0,head);
			return true;
		    }
		    count = 0;
		}
	    }
	}
	return false;
    }

    /**
     * This method compare two hands.
     * the prototype is public int compare(Value v);
     * It returns a positive number if the hand of the object
     * this is better than v
     * and a negative number if it is not
     * it returns 0 if the hand have the same value
     */
    public int compare(Value v){
	if(this.value != v.getValue())
	    return this.value - v.getValue();
	else {
	    return compareArray(this.data,v.getData());
	}
    }

    /**
     * This method compare two arrayList Lexicographically of
     * same size
     */
    private int compareArray(ArrayList<Integer> a1, ArrayList<Integer> a2){
	int i = 0;
	int size = a1.size();
	int value1, value2;
	while(i < size){
	    value1 = a1.get(i);
	    value2 = a2.get(i);
	    if(value1 != value2)
		return value1 - value2;
	    else {
		++i;
	    }
	}
	return 0;
    }


    public String getValueAsString(){
	    switch ( value ) {
	    case 0:   return "High Card";
	    case 1:   return "Pair";
	    case 2:   return "Double Pair";
	    case 3:   return "Three of a kind";
	    case 4:   return "Straight";
	    case 5:   return "Flush";
	    case 6:   return "Full house";
	    case 7:   return "Four of a kind";
	    case 8:   return "Straight flush";
	    default:  return "Error";
	    }
    }


    /**
     * This method return a string representation of the value
     * object*/

    public String toString(){
	String res = "";
	res += cards + "\n";
	res += "Value = " + getValueAsString() + "\n";
	res += "Occurrence Value = " + occValue + "\n";
	res += "Occurrence Suit = " + occSuit + "\n";
	res += "Data = " + data + "\n";
	return res;
    }
}
