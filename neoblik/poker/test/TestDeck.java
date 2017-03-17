package poker;

import java.util.*;

public class TestDeck{
    
    /**
     * Test the instantiation of the class deck
     */
    public void testInstantiation(){
	Deck d = new Deck();
	assert d.size() == 52;
	d.shuffle();
	assert d.size() == 52;
    }

    /**
     * Test if the draw and burn of a card works
     */
    public void testDraw(){
	Deck d = new Deck();
	Card c1 = d.draw();
	Card c2 = new Card(Card.SPADES, 2);
	assert c1.equals(c2);
	assert d.size() == 51;
	d.burn();
	assert d.size() == 50;
    }


}
