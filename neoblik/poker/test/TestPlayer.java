package poker;
import java.util.*;

public class TestPlayer{

    public void testPlayer(){
	Player p = new Player(1500);
	assert p.getStack() == 1500;

	List<Card> cards = new ArrayList<Card>();
	Card c1 = new Card(Card.HEARTS, 2);
	Card c2 = new Card(Card.SPADES, 2);
	cards.add(c1);
	cards.add(c2);
	p.setHand(c1, c2);
	Card[] hand = p.getHand();
	assert hand[0].equals(c1);
	assert hand[1].equals(c2);

	List<Card> board = new ArrayList<Card>();
	Card c3 = new Card(Card.HEARTS, 5);
	Card c4 = new Card(Card.SPADES, 5);
	Card c5 = new Card(Card.DIAMONDS, 10);
	Card c6 = new Card(Card.HEARTS, Card.JACK);
	Card c7 = new Card(Card.HEARTS, 3);
	board.add(c3);
	board.add(c4);
	board.add(c5);
	board.add(c6);
	board.add(c7);
	p.setValue(board);
	assert p.getHandValue().getValue() == Value.DOUBLEPAIR;
    }

public void testCompare(){
	Player p = new Player(1500);
	Player q = new Player(1500);

	Card c1 = new Card(Card.HEARTS, 2);
	Card c2 = new Card(Card.SPADES, 2);
	p.setHand(c1, c2);
	Card d1 = new Card(Card.CLUBS, 5);
	Card d2 = new Card(Card.SPADES, 10);
	q.setHand(d1, d2);
	

	List<Card> board = new ArrayList<Card>();
	Card c3 = new Card(Card.HEARTS, 5);
	Card c4 = new Card(Card.SPADES, 5);
	Card c5 = new Card(Card.DIAMONDS, 10);
	Card c6 = new Card(Card.HEARTS, Card.JACK);
	Card c7 = new Card(Card.HEARTS, 3);
	board.add(c3);
	board.add(c4);
	board.add(c5);
	board.add(c6);
	board.add(c7);
	p.setValue(board);
	q.setValue(board);
	assert p.getHandValue().getValue() == Value.DOUBLEPAIR;
	assert q.getHandValue().getValue() == Value.FULL;
	assert p.compare(q) < 0;
    }

}
