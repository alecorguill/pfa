package poker;
import java.util.*;

public class TestPot {
    
    public void testContributionEqual() {
	Player p = new Player(1500);
	Player q = new Player(1500);
	Player r = new Player(1500);
	ArrayList<Player> players = new ArrayList<Player>();
	players.add(p);
	players.add(q);
	players.add(r);
	Pot pot = new Pot(players);
	p.bet(200, false);
	pot.addContribution(200,p);
	q.bet(200, false);
	pot.addContribution(200,q);
	r.fold();
	assert pot.contributionEqual();
	pot.reset();
	r.bet(100, false);
	pot.addContribution(100,r);
	q.bet(200, false);
	pot.addContribution(200,q);
	assert !pot.contributionEqual();
	p.fold();
	r.fold();
	assert pot.contributionEqual();
    }
}
