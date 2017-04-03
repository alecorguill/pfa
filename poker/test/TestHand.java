package model;

public class TestHand{
    
    /**
     * Verify that the hand given is correct
     */
    public void testGetHand(){
	Card c1 = new Card(Card.DIAMONDS, 10);
	Card c2 = new Card(Card.CLUBS, Card.JACK);
	Hand h = new Hand(c1, c2);
	Card[] hValue = h.getHand();
	assert hValue[0].equals(c1);
	assert hValue[1].equals(c2);
    }

    /**
     * Test when the hand is changed
     */
    public void testSetHand(){
	Card c1 = new Card(Card.SPADES, 2);
	Card c2 = new Card(Card.CLUBS, 8);
	Card c3 = new Card(Card.HEARTS, Card.QUEEN);
	Hand h = new Hand(c1, c2);
	h.setHand(c2, c3);
	Card[] hValue = h.getHand();
	assert hValue[0].equals(c2);
	assert hValue[1].equals(c3);
    }
}
