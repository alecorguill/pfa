package poker;
import java.util.*;

public class TestValue{

   public void testIsHighcard(){
       List<Card> cards = new ArrayList<Card>();
       Card c1 = new Card(Card.SPADES, 2);
       Card c2 = new Card(Card.CLUBS, 9);
       Card c3 = new Card(Card.HEARTS, 4);
       Card c4 = new Card(Card.SPADES, Card.JACK);
       Card c5 = new Card(Card.HEARTS, Card.KING);
       Card c6 = new Card(Card.HEARTS, 7);
       Card c7 = new Card(Card.HEARTS, 3);
       cards.add(c1);
       cards.add(c2);
       cards.add(c3);
       cards.add(c4);
       cards.add(c5);
       cards.add(c6);
       cards.add(c7);
       Value v = new Value(cards);
       v.calculateValue();
       assert v.getValue() == Value.HIGHCARD;
       
    }

    public void testIsPair(){
	//TEST 1
	List<Card> cards = new ArrayList<Card>();
	Card c1 = new Card(Card.HEARTS, 2);
	Card c2 = new Card(Card.SPADES, 2);
	Card c3 = new Card(Card.CLUBS, 8);
	Card c4 = new Card(Card.SPADES, 6);
	Card c5 = new Card(Card.DIAMONDS, 10);
	Card c6 = new Card(Card.HEARTS, Card.QUEEN);
	Card c7 = new Card(Card.HEARTS, 3);
	cards.add(c1);
	cards.add(c2);
	cards.add(c3);
	cards.add(c4);
	cards.add(c5);
	cards.add(c6);
	cards.add(c7);
	Value v = new Value(cards);
	v.calculateValue();
	//System.out.println(v.toString());
	assert v.getValue() == Value.PAIR;
	//TEST 2
	Card c8 = new Card(Card.CLUBS,2);
	cards.set(2,c8);
	v.setCards(cards);
	//System.out.println(v.toString());
	assert !(v.getValue() == Value.PAIR);
	//TEST 3 
	Card c9 = new Card(Card.DIAMONDS,2);
	cards.set(3,c9);
	v.setCards(cards);
	//System.out.println(v.toString());
	assert !(v.getValue() == Value.PAIR);
    }
    public void testIsDoublePair(){
	//TEST 1
	List<Card> cards = new ArrayList<Card>();
	Card c1 = new Card(Card.HEARTS, 3);
	Card c2 = new Card(Card.SPADES, 2);
	Card c3 = new Card(Card.HEARTS, 5);
	Card c4 = new Card(Card.SPADES, 5);
	Card c5 = new Card(Card.DIAMONDS, 10);
	Card c6 = new Card(Card.HEARTS, 10);
	Card c7 = new Card(Card.HEARTS, 3);
	cards.add(c1);
	cards.add(c2);
	cards.add(c3);
	cards.add(c4);
	cards.add(c5);
	cards.add(c6);
	cards.add(c7);
	Value v = new Value(cards);
	v.calculateValue();
	//System.out.println(v.toString());
	assert v.getValue() == Value.DOUBLEPAIR;
	//TEST 2 
	Card c8 = new Card(Card.HEARTS, 10);
	cards.set(5,c8);
	v.setCards(cards);
	//System.out.println(v.toString());
	assert v.getValue() == Value.DOUBLEPAIR;
    }

public void testIsThree(){
       List<Card> cards = new ArrayList<Card>();
       Card c1 = new Card(Card.SPADES, 9);
       Card c2 = new Card(Card.CLUBS, 9);
       Card c3 = new Card(Card.HEARTS, 9);
       Card c4 = new Card(Card.SPADES, Card.JACK);
       Card c5 = new Card(Card.HEARTS, Card.KING);
       Card c6 = new Card(Card.SPADES, 7);
       Card c7 = new Card(Card.HEARTS, 3);
       cards.add(c1);
       cards.add(c2);
       cards.add(c3);
       cards.add(c4);
       cards.add(c5);
       cards.add(c6);
       cards.add(c7);
       Value v = new Value(cards);
       v.calculateValue();
       assert v.getValue() == Value.THREE;
       
    }

    public void testIsStraight(){
	//TEST 1
	List<Card> cards = new ArrayList<Card>();
	Card c1 = new Card(Card.HEARTS, 2);
	Card c2 = new Card(Card.SPADES, 3);
	Card c3 = new Card(Card.HEARTS, 4);
	Card c4 = new Card(Card.SPADES, 5);
	Card c5 = new Card(Card.DIAMONDS, 6);
	Card c6 = new Card(Card.HEARTS, 7);
	Card c7 = new Card(Card.HEARTS, 3);
	cards.add(c1);
	cards.add(c2);
	cards.add(c3);
	cards.add(c4);
	cards.add(c5);
	cards.add(c6);
	cards.add(c7);
	Value v = new Value(cards);
	v.calculateValue();
	//System.out.println(v.toString());
	assert v.getValue() == Value.STRAIGHT;
    }



    
    public void testIsFull(){
	//TEST 1
	List<Card> cards = new ArrayList<Card>();
	Card c1 = new Card(Card.HEARTS, 2);
	Card c2 = new Card(Card.SPADES, 2);
	Card c3 = new Card(Card.DIAMONDS, 2);
	Card c4 = new Card(Card.SPADES, 5);
	Card c5 = new Card(Card.HEARTS, 5);
	Card c6 = new Card(Card.HEARTS, 6);
	Card c7 = new Card(Card.HEARTS, 3);
	cards.add(c1);	
	cards.add(c2);
	cards.add(c3);
	cards.add(c4);
	cards.add(c5);
	cards.add(c6);
	cards.add(c7);
	Value v = new Value(cards);
	v.calculateValue();
	//System.out.println(v.toString());
	assert v.getValue() == Value.FULL;
    }

    public void testIsFlush(){
	//TEST 1
	List<Card> cards = new ArrayList<Card>();
	Card c1 = new Card(Card.HEARTS, 2);
	Card c2 = new Card(Card.HEARTS, 3);
	Card c3 = new Card(Card.SPADES, 3);
	Card c4 = new Card(Card.SPADES, Card.JACK);
	Card c5 = new Card(Card.HEARTS, 6);
	Card c6 = new Card(Card.HEARTS, 7);
	Card c7 = new Card(Card.HEARTS, 4);
	cards.add(c1);
	cards.add(c2);
	cards.add(c3);
	cards.add(c4);
	cards.add(c5);
	cards.add(c6);
	cards.add(c7);
	Value v = new Value(cards);
	v.calculateValue();
	//System.out.println(v.toString());
	assert v.getValue() == Value.FLUSH;

    }

public void testIsFour(){
       List<Card> cards = new ArrayList<Card>();
       Card c1 = new Card(Card.SPADES, Card.KING);
       Card c2 = new Card(Card.CLUBS, Card.KING);
       Card c3 = new Card(Card.HEARTS, Card.KING);
       Card c4 = new Card(Card.SPADES, Card.JACK);
       Card c5 = new Card(Card.DIAMONDS, Card.KING);
       Card c6 = new Card(Card.SPADES, Card.JACK);
       Card c7 = new Card(Card.HEARTS, Card.JACK);
       cards.add(c1);
       cards.add(c2);
       cards.add(c3);
       cards.add(c4);
       cards.add(c5);
       cards.add(c6);
       cards.add(c7);
       Value v = new Value(cards);
       v.calculateValue();
       //System.out.println(v.toString());
       assert v.getValue() == Value.FOUR;
       
    }
    
    public void testIsNotStrflush(){
       List<Card> cards = new ArrayList<Card>();
       Card c1 = new Card(Card.HEARTS, 2);
       Card c2 = new Card(Card.CLUBS, 9);
       Card c3 = new Card(Card.HEARTS, 4);
       Card c4 = new Card(Card.HEARTS, Card.JACK);
       Card c5 = new Card(Card.HEARTS, 5);
       Card c6 = new Card(Card.SPADES, Card.ACE);
       Card c7 = new Card(Card.HEARTS, 3);
       cards.add(c1);
       cards.add(c2);
       cards.add(c3);
       cards.add(c4);
       cards.add(c5);
       cards.add(c6);
       cards.add(c7);
       Value v = new Value(cards);
       v.calculateValue();
       assert v.getValue() != Value.STRFLUSH;
       
    }
 

public void testCompareHighcard(){
	//TEST 1
	List<Card> cards1 = new ArrayList<Card>();
	Card c1 = new Card(Card.HEARTS, 3);
	Card c2 = new Card(Card.SPADES, 9);
	Card c3 = new Card(Card.DIAMONDS, 2);
	Card c4 = new Card(Card.SPADES, 6);
	Card c5 = new Card(Card.HEARTS, 10);
	Card c6 = new Card(Card.CLUBS, 8);
	Card c7 = new Card(Card.HEARTS, 5);
	cards1.add(c1);
	cards1.add(c2);
	cards1.add(c3);
	cards1.add(c4);
	cards1.add(c5);
	cards1.add(c6);
	cards1.add(c7);
	List<Card> cards2 = new ArrayList<Card>();
	Card d1 = new Card(Card.HEARTS, 9);
	Card d2 = new Card(Card.SPADES, 4);
	Card d3 = new Card(Card.DIAMONDS, 6);
	Card d4 = new Card(Card.SPADES, 2);
	Card d5 = new Card(Card.HEARTS, 7);
	Card d6 = new Card(Card.CLUBS, 10);
	Card d7 = new Card(Card.CLUBS, 5);
	cards2.add(d1);
	cards2.add(d2);
	cards2.add(d3);
	cards2.add(d4);
	cards2.add(d5);
	cards2.add(d6);
	cards2.add(d7);
	Value v1 = new Value(cards1);
	Value v2 = new Value(cards2);
	v1.calculateValue();
	v2.calculateValue();
	//System.out.println(v1.toString());
	//System.out.println(v2.toString());
	assert v1.compare(v2) > 0;
    }
    
  
 public void testCompareEqualHighcard(){

	List<Card> cards1 = new ArrayList<Card>();
	Card c1 = new Card(Card.HEARTS, 3);
	Card c2 = new Card(Card.SPADES, 9);
 	Card c3 = new Card(Card.DIAMONDS, 4);
	Card c4 = new Card(Card.SPADES, 6);
	Card c5 = new Card(Card.HEARTS, 10);
	Card c6 = new Card(Card.CLUBS, 8);
	Card c7 = new Card(Card.HEARTS, 5);
	cards1.add(c1);
	cards1.add(c2);
	cards1.add(c3);
	cards1.add(c4);
	cards1.add(c5);
	cards1.add(c6);
 	cards1.add(c7);
	List<Card> cards2 = new ArrayList<Card>();
	Card d1 = new Card(Card.HEARTS, 3);
	Card d2 = new Card(Card.SPADES, 9);
	Card d3 = new Card(Card.DIAMONDS, 2);
	Card d4 = new Card(Card.SPADES, 6);
	Card d5 = new Card(Card.HEARTS, 10);
	Card d6 = new Card(Card.CLUBS, 8);
 	Card d7 = new Card(Card.CLUBS, 5);
	cards2.add(d1);
	cards2.add(d2);
	cards2.add(d3);
 	cards2.add(d4);
	cards2.add(d5);
	cards2.add(d6);
	cards2.add(d7);
	Value v1 = new Value(cards1);
	Value v2 = new Value(cards2);
 	v1.calculateValue();
	v2.calculateValue();
 	//System.out.println(v1.toString());
	//System.out.println(v2.toString());
	assert v1.compare(v2) == 0;
	}

public void testComparePair(){
	//TEST 1
	List<Card> cards1 = new ArrayList<Card>();
	Card c1 = new Card(Card.HEARTS, 3);
	Card c2 = new Card(Card.SPADES, 9);
	Card c3 = new Card(Card.DIAMONDS, 3);
	Card c4 = new Card(Card.SPADES, 6);
	Card c5 = new Card(Card.HEARTS, 10);
	Card c6 = new Card(Card.CLUBS, 8);
	Card c7 = new Card(Card.HEARTS, 5);
	cards1.add(c1);
	cards1.add(c2);
	cards1.add(c3);
	cards1.add(c4);
	cards1.add(c5);
	cards1.add(c6);
	cards1.add(c7);
	List<Card> cards2 = new ArrayList<Card>();
	Card d1 = new Card(Card.HEARTS, 9);
	Card d2 = new Card(Card.SPADES, 3);
	Card d3 = new Card(Card.DIAMONDS, 6);
	Card d4 = new Card(Card.SPADES, 3);
	Card d5 = new Card(Card.HEARTS, 7);
	Card d6 = new Card(Card.CLUBS, 10);
	Card d7 = new Card(Card.CLUBS, 5);
	cards2.add(d1);
	cards2.add(d2);
	cards2.add(d3);
	cards2.add(d4);
	cards2.add(d5);
	cards2.add(d6);
	cards2.add(d7);
	Value v1 = new Value(cards1);
	Value v2 = new Value(cards2);
	v1.calculateValue();
	v2.calculateValue();
	//System.out.println(v1.toString());
	//System.out.println(v2.toString());
	assert v1.compare(v2) > 0;
    }

public void testCompareEqualPair(){
	//TEST 1
	List<Card> cards1 = new ArrayList<Card>();
	Card c1 = new Card(Card.HEARTS, 3);
	Card c2 = new Card(Card.SPADES, 9);
	Card c3 = new Card(Card.DIAMONDS, 3);
	Card c4 = new Card(Card.SPADES, 6);
	Card c5 = new Card(Card.HEARTS, 10);
	Card c6 = new Card(Card.CLUBS, 8);
	Card c7 = new Card(Card.HEARTS, 5);
	cards1.add(c1);
	cards1.add(c2);
	cards1.add(c3);
	cards1.add(c4);
	cards1.add(c5);
	cards1.add(c6);
	cards1.add(c7);
	List<Card> cards2 = new ArrayList<Card>();
	Card d1 = new Card(Card.HEARTS, 9);
	Card d2 = new Card(Card.SPADES, 3);
	Card d3 = new Card(Card.DIAMONDS, 4);
	Card d4 = new Card(Card.SPADES, 3);
	Card d5 = new Card(Card.HEARTS, 8);
	Card d6 = new Card(Card.CLUBS, 10);
	Card d7 = new Card(Card.CLUBS, 5);
	cards2.add(d1);
	cards2.add(d2);
	cards2.add(d3);
	cards2.add(d4);
	cards2.add(d5);
	cards2.add(d6);
	cards2.add(d7);
	Value v1 = new Value(cards1);
	Value v2 = new Value(cards2);
	v1.calculateValue();
	v2.calculateValue();
	//System.out.println(v1.toString());
	//System.out.println(v2.toString());
	assert v1.compare(v2) == 0;
    }

public void testCompareDoublePair(){
	//TEST 1
	List<Card> cards1 = new ArrayList<Card>();
	Card c1 = new Card(Card.HEARTS, 3);
	Card c2 = new Card(Card.SPADES, 6);
	Card c3 = new Card(Card.DIAMONDS, 3);
	Card c4 = new Card(Card.SPADES, 6);
	Card c5 = new Card(Card.HEARTS, 10);
	Card c6 = new Card(Card.CLUBS, 8);
	Card c7 = new Card(Card.HEARTS, 5);
	cards1.add(c1);
	cards1.add(c2);
	cards1.add(c3);
	cards1.add(c4);
	cards1.add(c5);
	cards1.add(c6);
	cards1.add(c7);
	List<Card> cards2 = new ArrayList<Card>();
	Card d1 = new Card(Card.HEARTS, 9);
	Card d2 = new Card(Card.SPADES, 2);
	Card d3 = new Card(Card.DIAMONDS, 6);
	Card d4 = new Card(Card.SPADES, 2);
	Card d5 = new Card(Card.HEARTS, 6);
	Card d6 = new Card(Card.CLUBS, 10);
	Card d7 = new Card(Card.CLUBS, 5);
	cards2.add(d1);
	cards2.add(d2);
	cards2.add(d3);
	cards2.add(d4);
	cards2.add(d5);
	cards2.add(d6);
	cards2.add(d7);
	Value v1 = new Value(cards1);
	Value v2 = new Value(cards2);
	v1.calculateValue();
	v2.calculateValue();
	//System.out.println(v1.toString());
	//System.out.println(v2.toString());
	assert v1.compare(v2) > 0;
    }

public void testCompareEqualDoublePair(){
	//TEST 1
	List<Card> cards1 = new ArrayList<Card>();
	Card c1 = new Card(Card.HEARTS, 7);
	Card c2 = new Card(Card.SPADES, 6);
	Card c3 = new Card(Card.DIAMONDS, 7);
	Card c4 = new Card(Card.SPADES, 6);
	Card c5 = new Card(Card.HEARTS, 5);
	Card c6 = new Card(Card.CLUBS, 4);
	Card c7 = new Card(Card.HEARTS, 2);
	cards1.add(c1);
	cards1.add(c2);
	cards1.add(c3);
	cards1.add(c4);
	cards1.add(c5);
	cards1.add(c6);
	cards1.add(c7);
	List<Card> cards2 = new ArrayList<Card>();
	Card d1 = new Card(Card.HEARTS, 5);
	Card d2 = new Card(Card.SPADES, 5);
	Card d3 = new Card(Card.DIAMONDS, 6);
	Card d4 = new Card(Card.SPADES, 7);
	Card d5 = new Card(Card.HEARTS, 6);
	Card d6 = new Card(Card.CLUBS, 4);
	Card d7 = new Card(Card.CLUBS, 7);
	cards2.add(d1);
	cards2.add(d2);
	cards2.add(d3);
	cards2.add(d4);
	cards2.add(d5);
	cards2.add(d6);
	cards2.add(d7);
	Value v1 = new Value(cards1);
	Value v2 = new Value(cards2);
	v1.calculateValue();
	v2.calculateValue();
	//System.out.println(v1.toString());
	//System.out.println(v2.toString());
	assert v1.compare(v2) == 0;
    }

public void testCompareThree(){
	//TEST 1
	List<Card> cards1 = new ArrayList<Card>();
	Card c1 = new Card(Card.HEARTS, 4);
	Card c2 = new Card(Card.SPADES, 6);
	Card c3 = new Card(Card.DIAMONDS, 3);
	Card c4 = new Card(Card.SPADES, 6);
	Card c5 = new Card(Card.HEARTS, 10);
	Card c6 = new Card(Card.CLUBS, 6);
	Card c7 = new Card(Card.HEARTS, 7);
	cards1.add(c1);
	cards1.add(c2);
	cards1.add(c3);
	cards1.add(c4);
	cards1.add(c5);
	cards1.add(c6);
	cards1.add(c7);
	List<Card> cards2 = new ArrayList<Card>();
	Card d1 = new Card(Card.HEARTS, 10);
	Card d2 = new Card(Card.SPADES, 3);
	Card d3 = new Card(Card.DIAMONDS, 6);
	Card d4 = new Card(Card.SPADES, 4);
	Card d5 = new Card(Card.HEARTS, 6);
	Card d6 = new Card(Card.CLUBS, 6);
	Card d7 = new Card(Card.CLUBS, 5);
	cards2.add(d1);
	cards2.add(d2);
	cards2.add(d3);
	cards2.add(d4);
	cards2.add(d5);
	cards2.add(d6);
	cards2.add(d7);
	Value v1 = new Value(cards1);
	Value v2 = new Value(cards2);
	v1.calculateValue();
	v2.calculateValue();
	//System.out.println(v1.toString());
	//System.out.println(v2.toString());
	assert v1.compare(v2) > 0;
    }


public void testCompareEqualThree(){
	//TEST 1
	List<Card> cards1 = new ArrayList<Card>();
	Card c1 = new Card(Card.HEARTS, 2);
	Card c2 = new Card(Card.SPADES, 6);
	Card c3 = new Card(Card.DIAMONDS, 3);
	Card c4 = new Card(Card.SPADES, 6);
	Card c5 = new Card(Card.HEARTS, 10);
	Card c6 = new Card(Card.CLUBS, 6);
	Card c7 = new Card(Card.HEARTS, 5);
	cards1.add(c1);
	cards1.add(c2);
	cards1.add(c3);
	cards1.add(c4);
	cards1.add(c5);
	cards1.add(c6);
	cards1.add(c7);
	List<Card> cards2 = new ArrayList<Card>();
	Card d1 = new Card(Card.HEARTS, 10);
	Card d2 = new Card(Card.SPADES, 3);
	Card d3 = new Card(Card.DIAMONDS, 6);
	Card d4 = new Card(Card.SPADES, 4);
	Card d5 = new Card(Card.HEARTS, 6);
	Card d6 = new Card(Card.CLUBS, 6);
	Card d7 = new Card(Card.CLUBS, 5);
	cards2.add(d1);
	cards2.add(d2);
	cards2.add(d3);
	cards2.add(d4);
	cards2.add(d5);
	cards2.add(d6);
	cards2.add(d7);
	Value v1 = new Value(cards1);
	Value v2 = new Value(cards2);
	v1.calculateValue();
	v2.calculateValue();
	//System.out.println(v1.toString());
	//System.out.println(v2.toString());
	assert v1.compare(v2) == 0;
    }

public void testCompareStraight(){
	//TEST 1
	List<Card> cards1 = new ArrayList<Card>();
	Card c1 = new Card(Card.HEARTS, 2);
	Card c2 = new Card(Card.SPADES, 5);
	Card c3 = new Card(Card.DIAMONDS, 3);
	Card c4 = new Card(Card.SPADES, 4);
	Card c5 = new Card(Card.HEARTS, 10);
	Card c6 = new Card(Card.CLUBS, 6);
	Card c7 = new Card(Card.HEARTS, 7);
	cards1.add(c1);
	cards1.add(c2);
	cards1.add(c3);
	cards1.add(c4);
	cards1.add(c5);
	cards1.add(c6);
	cards1.add(c7);
	List<Card> cards2 = new ArrayList<Card>();
	Card d1 = new Card(Card.HEARTS, 2);
	Card d2 = new Card(Card.SPADES, 3);
	Card d3 = new Card(Card.DIAMONDS, 6);
	Card d4 = new Card(Card.SPADES, 4);
	Card d5 = new Card(Card.HEARTS, Card.ACE);
	Card d6 = new Card(Card.CLUBS, 6);
	Card d7 = new Card(Card.CLUBS, 5);
	cards2.add(d1);
	cards2.add(d2);
	cards2.add(d3);
	cards2.add(d4);
	cards2.add(d5);
	cards2.add(d6);
	cards2.add(d7);
	Value v1 = new Value(cards1);
	Value v2 = new Value(cards2);
	v1.calculateValue();
	v2.calculateValue();
	//System.out.println(v1.toString());
	//System.out.println(v2.toString());
	assert v1.compare(v2) > 0;
    }

    
   
     public void testCompareEqualStraight(){
	//TEST 1
	List<Card> cards1 = new ArrayList<Card>();
	Card c1 = new Card(Card.HEARTS, 2);
	Card c2 = new Card(Card.SPADES, 5);
	Card c3 = new Card(Card.DIAMONDS, 3);
	Card c4 = new Card(Card.SPADES, 4);
	Card c5 = new Card(Card.HEARTS, 10);
	Card c6 = new Card(Card.CLUBS, 6);
	Card c7 = new Card(Card.HEARTS, 10);
	cards1.add(c1);
	cards1.add(c2);
	cards1.add(c3);
	cards1.add(c4);
	cards1.add(c5);
	cards1.add(c6);
	cards1.add(c7);
	List<Card> cards2 = new ArrayList<Card>();
	Card d1 = new Card(Card.HEARTS, 2);
	Card d2 = new Card(Card.SPADES, 3);
	Card d3 = new Card(Card.DIAMONDS, 6);
	Card d4 = new Card(Card.SPADES, 4);
	Card d5 = new Card(Card.HEARTS, Card.ACE);
	Card d6 = new Card(Card.CLUBS, 10);
	Card d7 = new Card(Card.CLUBS, 5);
	cards2.add(d1);
	cards2.add(d2);
	cards2.add(d3);
	cards2.add(d4);
	cards2.add(d5);
	cards2.add(d6);
	cards2.add(d7);
	Value v1 = new Value(cards1);
	Value v2 = new Value(cards2);
	v1.calculateValue();
	v2.calculateValue();
	//System.out.println(v1.toString());
	//System.out.println(v2.toString());
	assert v1.compare(v2) == 0;
	}
    
    

public void testCompareFlush(){
	//TEST 1
	List<Card> cards1 = new ArrayList<Card>();
	Card c1 = new Card(Card.HEARTS, 2);
	Card c2 = new Card(Card.SPADES, 5);
	Card c3 = new Card(Card.HEARTS, 3);
	Card c4 = new Card(Card.SPADES, 8);
	Card c5 = new Card(Card.HEARTS, 10);
	Card c6 = new Card(Card.HEARTS, 6);
	Card c7 = new Card(Card.HEARTS, Card.ACE);
	cards1.add(c1);
	cards1.add(c2);
	cards1.add(c3);
	cards1.add(c4);
	cards1.add(c5);
	cards1.add(c6);
	cards1.add(c7);
	List<Card> cards2 = new ArrayList<Card>();
	Card d1 = new Card(Card.HEARTS, 2);
	Card d2 = new Card(Card.HEARTS, 3);
	Card d3 = new Card(Card.HEARTS, 6);
	Card d4 = new Card(Card.SPADES, 8);
	Card d5 = new Card(Card.HEARTS, Card.ACE);
	Card d6 = new Card(Card.HEARTS, 9);
	Card d7 = new Card(Card.CLUBS, 5);
	cards2.add(d1);
	cards2.add(d2);
	cards2.add(d3);
	cards2.add(d4);
	cards2.add(d5);
	cards2.add(d6);
	cards2.add(d7);
	Value v1 = new Value(cards1);
	Value v2 = new Value(cards2);
	v1.calculateValue();
	v2.calculateValue();
	//System.out.println(v1.toString());
	//System.out.println(v2.toString());
	assert v1.compare(v2) > 0;
    }


public void testCompareEqualFlush(){
	//TEST 1
	List<Card> cards1 = new ArrayList<Card>();
	Card c1 = new Card(Card.HEARTS, 2);
	Card c2 = new Card(Card.SPADES, 5);
	Card c3 = new Card(Card.HEARTS, 5);
	Card c4 = new Card(Card.HEARTS, 8);
	Card c5 = new Card(Card.HEARTS, 10);
	Card c6 = new Card(Card.HEARTS, 6);
	Card c7 = new Card(Card.HEARTS, Card.ACE);
	cards1.add(c1);
	cards1.add(c2);
	cards1.add(c3);
	cards1.add(c4);
	cards1.add(c5);
	cards1.add(c6);
	cards1.add(c7);
	List<Card> cards2 = new ArrayList<Card>();
	Card d1 = new Card(Card.HEARTS, 4);
	Card d2 = new Card(Card.HEARTS, 5);
	Card d3 = new Card(Card.HEARTS, 6);
	Card d4 = new Card(Card.HEARTS, 8);
	Card d5 = new Card(Card.HEARTS, Card.ACE);
	Card d6 = new Card(Card.HEARTS, 10);
	Card d7 = new Card(Card.CLUBS, Card.ACE);
	cards2.add(d1);
	cards2.add(d2);
	cards2.add(d3);
	cards2.add(d4);
	cards2.add(d5);
	cards2.add(d6);
	cards2.add(d7);
	Value v1 = new Value(cards1);
	Value v2 = new Value(cards2);
	v1.calculateValue();
	v2.calculateValue();
	//System.out.println(v1.toString());
	//System.out.println(v2.toString());
	assert v1.compare(v2) == 0;
    }


public void testCompareFull(){
	//TEST 1
	List<Card> cards1 = new ArrayList<Card>();
	Card c1 = new Card(Card.HEARTS, 4);
	Card c2 = new Card(Card.SPADES, 4);
	Card c3 = new Card(Card.HEARTS, 2);
	Card c4 = new Card(Card.SPADES, 6);
	Card c5 = new Card(Card.CLUBS, 10);
	Card c6 = new Card(Card.HEARTS, 6);
	Card c7 = new Card(Card.DIAMONDS, 6);
	cards1.add(c1);
	cards1.add(c2);
	cards1.add(c3);
	cards1.add(c4);
	cards1.add(c5);
	cards1.add(c6);
	cards1.add(c7);
	List<Card> cards2 = new ArrayList<Card>();
	Card d1 = new Card(Card.HEARTS, 3);
	Card d2 = new Card(Card.DIAMONDS, 3);
	Card d3 = new Card(Card.HEARTS, 6);
	Card d4 = new Card(Card.SPADES, 6);
	Card d5 = new Card(Card.HEARTS, Card.ACE);
	Card d6 = new Card(Card.CLUBS, 9);
	Card d7 = new Card(Card.CLUBS, 6);
	cards2.add(d1);
	cards2.add(d2);
	cards2.add(d3);
	cards2.add(d4);
	cards2.add(d5);
	cards2.add(d6);
	cards2.add(d7);
	Value v1 = new Value(cards1);
	Value v2 = new Value(cards2);
	v1.calculateValue();
	v2.calculateValue();
	//System.out.println(v1.toString());
	//System.out.println(v2.toString());
	assert v1.compare(v2) > 0;
    }
    

     public void testCompareEqualFull(){
	//TEST 1
	List<Card> cards1 = new ArrayList<Card>();
	Card c1 = new Card(Card.HEARTS, 4);
	Card c2 = new Card(Card.SPADES, 4);
	Card c3 = new Card(Card.CLUBS, 4);
	Card c4 = new Card(Card.SPADES, 6);
	Card c5 = new Card(Card.CLUBS, 10);
	Card c6 = new Card(Card.HEARTS, 6);
	Card c7 = new Card(Card.DIAMONDS, 6);
	cards1.add(c1);
	cards1.add(c2);
	cards1.add(c3);
	cards1.add(c4);
	cards1.add(c5);
	cards1.add(c6);
	cards1.add(c7);
	List<Card> cards2 = new ArrayList<Card>();
	Card d1 = new Card(Card.HEARTS, 4);
	Card d2 = new Card(Card.DIAMONDS, 4);
	Card d3 = new Card(Card.HEARTS, 6);
	Card d4 = new Card(Card.SPADES, 6);
	Card d5 = new Card(Card.HEARTS, 10);
	Card d6 = new Card(Card.CLUBS, 3);
	Card d7 = new Card(Card.CLUBS, 6);
	cards2.add(d1);
	cards2.add(d2);
	cards2.add(d3);
	cards2.add(d4);
	cards2.add(d5);
	cards2.add(d6);
	cards2.add(d7);
	Value v1 = new Value(cards1);
	Value v2 = new Value(cards2);
	v1.calculateValue();
	v2.calculateValue();
	//System.out.println(v1.toString());
	//System.out.println(v2.toString());
	assert v1.compare(v2) == 0;
     }
    
public void testCompareFour(){
	//TEST 1
	List<Card> cards1 = new ArrayList<Card>();
	Card c1 = new Card(Card.HEARTS, 4);
	Card c2 = new Card(Card.SPADES, 4);
	Card c3 = new Card(Card.HEARTS, 2);
	Card c4 = new Card(Card.SPADES, 6);
	Card c5 = new Card(Card.CLUBS, 4);
	Card c6 = new Card(Card.HEARTS, 6);
	Card c7 = new Card(Card.DIAMONDS, 4);
	cards1.add(c1);
	cards1.add(c2);
	cards1.add(c3);
	cards1.add(c4);
	cards1.add(c5);
	cards1.add(c6);
	cards1.add(c7);
	List<Card> cards2 = new ArrayList<Card>();
	Card d1 = new Card(Card.HEARTS, 2);
	Card d2 = new Card(Card.DIAMONDS, 3);
	Card d3 = new Card(Card.HEARTS, 3);
	Card d4 = new Card(Card.SPADES, 3);
	Card d5 = new Card(Card.HEARTS, Card.ACE);
	Card d6 = new Card(Card.CLUBS, 3);
	Card d7 = new Card(Card.CLUBS, 6);
	cards2.add(d1);
	cards2.add(d2);
	cards2.add(d3);
	cards2.add(d4);
	cards2.add(d5);
	cards2.add(d6);
	cards2.add(d7);
	Value v1 = new Value(cards1);
	Value v2 = new Value(cards2);
	v1.calculateValue();
	v2.calculateValue();
	//System.out.println(v1.toString());
	//System.out.println(v2.toString());
	assert v1.compare(v2) > 0;
    }




    public void testCompareStrFlush(){
	//TEST 1
	List<Card> cards1 = new ArrayList<Card>();
	Card c1 = new Card(Card.HEARTS, 5);
	Card c2 = new Card(Card.SPADES, 4);
	Card c3 = new Card(Card.HEARTS, 2);
	Card c4 = new Card(Card.SPADES, 6);
	Card c5 = new Card(Card.HEARTS, 3);
	Card c6 = new Card(Card.HEARTS, 6);
	Card c7 = new Card(Card.HEARTS, 4);
	cards1.add(c1);
	cards1.add(c2);
	cards1.add(c3);
	cards1.add(c4);
	cards1.add(c5);
	cards1.add(c6);
	cards1.add(c7);
	List<Card> cards2 = new ArrayList<Card>();
	Card d1 = new Card(Card.HEARTS, 2);
	Card d2 = new Card(Card.DIAMONDS, 3);
	Card d3 = new Card(Card.HEARTS, 3);
	Card d4 = new Card(Card.SPADES, 3);
	Card d5 = new Card(Card.HEARTS, Card.ACE);
	Card d6 = new Card(Card.HEARTS, 5);
	Card d7 = new Card(Card.HEARTS, 4);
	cards2.add(d1);
	cards2.add(d2);
	cards2.add(d3);
	cards2.add(d4);
	cards2.add(d5);
	cards2.add(d6);
	cards2.add(d7);
	Value v1 = new Value(cards1);
	Value v2 = new Value(cards2);
	v1.calculateValue();
	v2.calculateValue();
	//System.out.println(v1.toString());
	//System.out.println(v2.toString());
	assert v1.compare(v2) > 0;
    }

 public void testCompareEqualStrFlush(){
	//TEST 1
	List<Card> cards1 = new ArrayList<Card>();
	Card c1 = new Card(Card.HEARTS, 5);
	Card c2 = new Card(Card.SPADES, 4);
	Card c3 = new Card(Card.HEARTS, 2);
	Card c4 = new Card(Card.SPADES, 9);
	Card c5 = new Card(Card.HEARTS, 3);
	Card c6 = new Card(Card.HEARTS, 6);
	Card c7 = new Card(Card.HEARTS, 4);
	cards1.add(c1);
	cards1.add(c2);
	cards1.add(c3);
	cards1.add(c4);
	cards1.add(c5);
	cards1.add(c6);
	cards1.add(c7);
	List<Card> cards2 = new ArrayList<Card>();
	Card d1 = new Card(Card.HEARTS, 5);
	Card d2 = new Card(Card.DIAMONDS, 8);
	Card d3 = new Card(Card.HEARTS, 2);
	Card d4 = new Card(Card.HEARTS, Card.ACE);
	Card d5 = new Card(Card.HEARTS, 3);
	Card d6 = new Card(Card.HEARTS, 6);
	Card d7 = new Card(Card.HEARTS, 4);
	cards2.add(d1);
	cards2.add(d2);
	cards2.add(d3);
	cards2.add(d4);
	cards2.add(d5);
	cards2.add(d6);
	cards2.add(d7);
	Value v1 = new Value(cards1);
	Value v2 = new Value(cards2);
	v1.calculateValue();
	v2.calculateValue();
	//System.out.println(v1.toString());
	//System.out.println(v2.toString());
	assert v1.compare(v2) == 0;
	}

 public void testCompareHighcardVSPair(){
	//TEST 1
	List<Card> cards1 = new ArrayList<Card>();
	Card c1 = new Card(Card.HEARTS, 3);
	Card c2 = new Card(Card.SPADES, 9);
	Card c3 = new Card(Card.DIAMONDS, 2);
	Card c4 = new Card(Card.SPADES, 6);
	Card c5 = new Card(Card.HEARTS, 10);
	Card c6 = new Card(Card.CLUBS, 8);
	Card c7 = new Card(Card.HEARTS, 5);
	cards1.add(c1);
	cards1.add(c2);
	cards1.add(c3);
	cards1.add(c4);
	cards1.add(c5);
	cards1.add(c6);
	cards1.add(c7);
	List<Card> cards2 = new ArrayList<Card>();
	Card d1 = new Card(Card.HEARTS, 9);
	Card d2 = new Card(Card.SPADES, 4);
	Card d3 = new Card(Card.DIAMONDS, 6);
	Card d4 = new Card(Card.SPADES, 2);
	Card d5 = new Card(Card.HEARTS, 6);
	Card d6 = new Card(Card.CLUBS, 10);
	Card d7 = new Card(Card.CLUBS, 5);
	cards2.add(d1);
	cards2.add(d2);
	cards2.add(d3);
	cards2.add(d4);
	cards2.add(d5);
	cards2.add(d6);
	cards2.add(d7);
	Value v1 = new Value(cards1);
	Value v2 = new Value(cards2);
	v1.calculateValue();
	v2.calculateValue();
	//System.out.println(v1.toString());
	//System.out.println(v2.toString());
	assert v1.compare(v2) < 0;

 }

 public void testComparePairVSDoublePair(){
	//TEST 1
	List<Card> cards1 = new ArrayList<Card>();
	Card c1 = new Card(Card.HEARTS, 7);
	Card c2 = new Card(Card.SPADES, 9);
	Card c3 = new Card(Card.DIAMONDS, 2);
	Card c4 = new Card(Card.SPADES, 6);
	Card c5 = new Card(Card.HEARTS, 10);
	Card c6 = new Card(Card.CLUBS, 6);
	Card c7 = new Card(Card.HEARTS, 5);
	cards1.add(c1);
	cards1.add(c2);
	cards1.add(c3);
	cards1.add(c4);
	cards1.add(c5);
	cards1.add(c6);
	cards1.add(c7);
	List<Card> cards2 = new ArrayList<Card>();
	Card d1 = new Card(Card.HEARTS, 9);
	Card d2 = new Card(Card.SPADES, 4);
	Card d3 = new Card(Card.DIAMONDS, 6);
	Card d4 = new Card(Card.SPADES, 4);
	Card d5 = new Card(Card.HEARTS, 5);
	Card d6 = new Card(Card.CLUBS, 10);
	Card d7 = new Card(Card.CLUBS, 5);
	cards2.add(d1);
	cards2.add(d2);
	cards2.add(d3);
	cards2.add(d4);
	cards2.add(d5);
	cards2.add(d6);
	cards2.add(d7);
	Value v1 = new Value(cards1);
	Value v2 = new Value(cards2);
	v1.calculateValue();
	v2.calculateValue();
	//System.out.println(v1.toString());
	//System.out.println(v2.toString());
	assert v1.compare(v2) < 0;

 }


public void testCompareDoublePairVSThree(){
	//TEST 1
	List<Card> cards1 = new ArrayList<Card>();
	Card c1 = new Card(Card.HEARTS, 7);
	Card c2 = new Card(Card.SPADES, 9);
	Card c3 = new Card(Card.DIAMONDS, 5);
	Card c4 = new Card(Card.SPADES, 6);
	Card c5 = new Card(Card.HEARTS, 10);
	Card c6 = new Card(Card.CLUBS, 6);
	Card c7 = new Card(Card.HEARTS, 5);
	cards1.add(c1);
	cards1.add(c2);
	cards1.add(c3);
	cards1.add(c4);
	cards1.add(c5);
	cards1.add(c6);
	cards1.add(c7);
	List<Card> cards2 = new ArrayList<Card>();
	Card d1 = new Card(Card.HEARTS, 9);
	Card d2 = new Card(Card.SPADES, 4);
	Card d3 = new Card(Card.DIAMONDS, 6);
	Card d4 = new Card(Card.SPADES, 4);
	Card d5 = new Card(Card.HEARTS, 5);
	Card d6 = new Card(Card.CLUBS, 10);
	Card d7 = new Card(Card.CLUBS, 4);
	cards2.add(d1);
	cards2.add(d2);
	cards2.add(d3);
	cards2.add(d4);
	cards2.add(d5);
	cards2.add(d6);
	cards2.add(d7);
	Value v1 = new Value(cards1);
	Value v2 = new Value(cards2);
	v1.calculateValue();
	v2.calculateValue();
	//System.out.println(v1.toString());
	//System.out.println(v2.toString());
	assert v1.compare(v2) < 0;

 }

public void testCompareThreeVSStraight(){
	//TEST 1
	List<Card> cards1 = new ArrayList<Card>();
	Card c1 = new Card(Card.HEARTS, 7);
	Card c2 = new Card(Card.SPADES, 9);
	Card c3 = new Card(Card.DIAMONDS, 5);
	Card c4 = new Card(Card.SPADES, 10);
	Card c5 = new Card(Card.HEARTS, 10);
	Card c6 = new Card(Card.CLUBS, 10);
	Card c7 = new Card(Card.HEARTS, 6);
	cards1.add(c1);
	cards1.add(c2);
	cards1.add(c3);
	cards1.add(c4);
	cards1.add(c5);
	cards1.add(c6);
	cards1.add(c7);
	List<Card> cards2 = new ArrayList<Card>();
	Card d1 = new Card(Card.HEARTS, 4);
	Card d2 = new Card(Card.SPADES, 7);
	Card d3 = new Card(Card.DIAMONDS, 6);
	Card d4 = new Card(Card.SPADES, 8);
	Card d5 = new Card(Card.HEARTS, 5);
	Card d6 = new Card(Card.CLUBS, 2);
	Card d7 = new Card(Card.CLUBS, 9);
	cards2.add(d1);
	cards2.add(d2);
	cards2.add(d3);
	cards2.add(d4);
	cards2.add(d5);
	cards2.add(d6);
	cards2.add(d7);
	Value v1 = new Value(cards1);
	Value v2 = new Value(cards2);
	v1.calculateValue();
	v2.calculateValue();
	//System.out.println(v1.toString());
	//System.out.println(v2.toString());
	assert v1.compare(v2) < 0;

 }


public void testCompareStraightVSFlush(){
	//TEST 1
	List<Card> cards1 = new ArrayList<Card>();
	Card c1 = new Card(Card.HEARTS, 7);
	Card c2 = new Card(Card.SPADES, 9);
	Card c3 = new Card(Card.DIAMONDS, 5);
	Card c4 = new Card(Card.SPADES, 8);
	Card c5 = new Card(Card.HEARTS, 10);
	Card c6 = new Card(Card.CLUBS, 10);
	Card c7 = new Card(Card.HEARTS, 6);
	cards1.add(c1);
	cards1.add(c2);
	cards1.add(c3);
	cards1.add(c4);
	cards1.add(c5);
	cards1.add(c6);
	cards1.add(c7);
	List<Card> cards2 = new ArrayList<Card>();
	Card d1 = new Card(Card.HEARTS, 4);
	Card d2 = new Card(Card.HEARTS, 7);
	Card d3 = new Card(Card.HEARTS, 6);
	Card d4 = new Card(Card.DIAMONDS, 9);
	Card d5 = new Card(Card.HEARTS, 5);
	Card d6 = new Card(Card.HEARTS, 9);
	Card d7 = new Card(Card.CLUBS, 9);
	cards2.add(d1);
	cards2.add(d2);
	cards2.add(d3);
	cards2.add(d4);
	cards2.add(d5);
	cards2.add(d6);
	cards2.add(d7);
	Value v1 = new Value(cards1);
	Value v2 = new Value(cards2);
	v1.calculateValue();
	v2.calculateValue();
	//System.out.println(v1.toString());
	//System.out.println(v2.toString());
	assert v1.compare(v2) < 0;

 }


public void testCompareFullVSFlush(){
	//TEST 1
	List<Card> cards1 = new ArrayList<Card>();
	Card c1 = new Card(Card.HEARTS, 8);
	Card c2 = new Card(Card.SPADES, 9);
	Card c3 = new Card(Card.DIAMONDS, 8);
	Card c4 = new Card(Card.SPADES, 8);
	Card c5 = new Card(Card.HEARTS, 10);
	Card c6 = new Card(Card.CLUBS, 10);
	Card c7 = new Card(Card.HEARTS, 6);
	cards1.add(c1);
	cards1.add(c2);
	cards1.add(c3);
	cards1.add(c4);
	cards1.add(c5);
	cards1.add(c6);
	cards1.add(c7);
	List<Card> cards2 = new ArrayList<Card>();
	Card d1 = new Card(Card.HEARTS, 4);
	Card d2 = new Card(Card.HEARTS, 7);
	Card d3 = new Card(Card.HEARTS, 6);
	Card d4 = new Card(Card.DIAMONDS, 9);
	Card d5 = new Card(Card.HEARTS, 5);
	Card d6 = new Card(Card.HEARTS, 9);
	Card d7 = new Card(Card.CLUBS, 9);
	cards2.add(d1);
	cards2.add(d2);
	cards2.add(d3);
	cards2.add(d4);
	cards2.add(d5);
	cards2.add(d6);
	cards2.add(d7);
	Value v1 = new Value(cards1);
	Value v2 = new Value(cards2);
	v1.calculateValue();
	v2.calculateValue();
	//System.out.println(v1.toString());
	//System.out.println(v2.toString());
	assert v1.compare(v2) > 0;

 }


public void testCompareFullVSFour(){
	//TEST 1
	List<Card> cards1 = new ArrayList<Card>();
	Card c1 = new Card(Card.HEARTS, 8);
	Card c2 = new Card(Card.SPADES, 9);
	Card c3 = new Card(Card.DIAMONDS, 8);
	Card c4 = new Card(Card.SPADES, 8);
	Card c5 = new Card(Card.HEARTS, 10);
	Card c6 = new Card(Card.CLUBS, 10);
	Card c7 = new Card(Card.HEARTS, 6);
	cards1.add(c1);
	cards1.add(c2);
	cards1.add(c3);
	cards1.add(c4);
	cards1.add(c5);
	cards1.add(c6);
	cards1.add(c7);
	List<Card> cards2 = new ArrayList<Card>();
	Card d1 = new Card(Card.HEARTS, 4);
	Card d2 = new Card(Card.SPADES, 9);
	Card d3 = new Card(Card.HEARTS, 6);
	Card d4 = new Card(Card.DIAMONDS, 9);
	Card d5 = new Card(Card.HEARTS, 5);
	Card d6 = new Card(Card.HEARTS, 9);
	Card d7 = new Card(Card.CLUBS, 9);
	cards2.add(d1);
	cards2.add(d2);
	cards2.add(d3);
	cards2.add(d4);
	cards2.add(d5);
	cards2.add(d6);
	cards2.add(d7);
	Value v1 = new Value(cards1);
	Value v2 = new Value(cards2);
	v1.calculateValue();
	v2.calculateValue();
	//System.out.println(v1.toString());
	//System.out.println(v2.toString());
	assert v1.compare(v2) < 0;

 }

public void testCompareStrFlushVSFour(){
	//TEST 1
	List<Card> cards1 = new ArrayList<Card>();
	Card c1 = new Card(Card.HEARTS, 7);
	Card c2 = new Card(Card.HEARTS, 9);
	Card c3 = new Card(Card.HEARTS, 8);
	Card c4 = new Card(Card.SPADES, 8);
	Card c5 = new Card(Card.HEARTS, 10);
	Card c6 = new Card(Card.CLUBS, 10);
	Card c7 = new Card(Card.HEARTS, 6);
	cards1.add(c1);
	cards1.add(c2);
	cards1.add(c3);
	cards1.add(c4);
	cards1.add(c5);
	cards1.add(c6);
	cards1.add(c7);
	List<Card> cards2 = new ArrayList<Card>();
	Card d1 = new Card(Card.HEARTS, 4);
	Card d2 = new Card(Card.SPADES, 9);
	Card d3 = new Card(Card.HEARTS, 6);
	Card d4 = new Card(Card.DIAMONDS, 9);
	Card d5 = new Card(Card.HEARTS, 5);
	Card d6 = new Card(Card.HEARTS, 9);
	Card d7 = new Card(Card.CLUBS, 9);
	cards2.add(d1);
	cards2.add(d2);
	cards2.add(d3);
	cards2.add(d4);
	cards2.add(d5);
	cards2.add(d6);
	cards2.add(d7);
	Value v1 = new Value(cards1);
	Value v2 = new Value(cards2);
	v1.calculateValue();
	v2.calculateValue();
	//System.out.println(v1.toString());
	//System.out.println(v2.toString());
	assert v1.compare(v2) > 0;

 }

}
