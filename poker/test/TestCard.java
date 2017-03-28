package poker;


public class TestCard{

    /**
     * Check is the card given is correct
     */
    public void testVerifCard(){
	Card c = new Card(Card.SPADES, 5);
	assert c.getSuit() == Card.SPADES;
	assert c.getValue() == 5;
    }

    public void testEquals(){
	Card c1 = new Card(Card.DIAMONDS, 6);
	Card c2 = new Card(Card.SPADES, Card.ACE);
	assert !(c1.equals(c2));
	Card c3 = new Card(Card.DIAMONDS, 6);
	Card c4 = new Card(Card.DIAMONDS, 5);
	Card c5 = new Card(Card.HEARTS, 6);
	assert !c3.equals(c4);
	assert !c3.equals(c5);
	assert c1.equals(c3);

    }

    /**
     * Check the string version of the card given
     */
    public void testVerifCardString(){
	Card c = new Card(Card.HEARTS, Card.KING);
	assert c.getSuitAsString() == "Hearts";
	assert c.getValueAsString() == "K";
    }

    public void testNewCard(){
	boolean thrown = false;
	try{
	    Card c = new Card(4,Card.QUEEN);
	}catch(IllegalArgumentException e){
	    thrown = true;
	}
	assert (thrown == true);
	thrown = false;

	try{
	    Card c = new Card(2,15);
	}catch(IllegalArgumentException e){
	    thrown =true;
	}
	
	assert (thrown == true);
	thrown = false;
    }

}
