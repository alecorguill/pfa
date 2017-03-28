/**
 * This class the game server. It hundles game's functioning.
 * It has a list of players, the deck, the pot and the dealer position
 */

package poker;

import java.util.*;

public class GameServer {

    private static int stackValue = 1500; //value of the stack of each player

    private ArrayList<Player> players; //List of the players
                                  //Playing the game
    private ArrayList<Card> board; //cards of the board

    private Deck deck; //Deck of the game
    private Pot pot;
    private int dealerPosition; //Index in players of dealer's position
    private int nbPlayers; //Number of players (avoid calculating it over and over)
    private int blind; //Big blind's value

    /**
     * GameServer constructor. Initialize the pot, the deck (unshuffled), the dealer     * Position
     */
    public GameServer(int nbPlayer){
	players = new ArrayList<Player>();
	int i;
	for(i=0; i<nbPlayer; ++i)
	    players.add(new Player(stackValue));
	board = new ArrayList<Card>();
	deck = new Deck(); //Initialisation of the UNSHUFFLED !
	Random rand = new Random();
	dealerPosition = rand.nextInt(nbPlayer);
	this.nbPlayers = nbPlayer;
	blind = 20;
	pot = new Pot(players);
    }

    /**
     * Function to be called when the game starts, it then execute the game loop
     */
    public void start(){
	//Initialisation
	int indexToPlay;
	int gain;
	int earningsSum;
	Player pSmallBlind;
	Player pBigBlind;
	Player winner;
	while(!this.gameOver()){
	    //We reset the state of the players that depend on
	    //the round
	    for(Player p : players)
		p.newRound();
	    //Position update
	    dealerPosition = (dealerPosition+1) % nbPlayers;
	    //Small and Big Blind Assignment
	    pSmallBlind = players.get((dealerPosition+1) % nbPlayers);
	    pBigBlind   = players.get((dealerPosition+2) % nbPlayers);
	    if (players.size() == 2){
		pSmallBlind = players.get(dealerPosition % nbPlayers);
	        pBigBlind = players.get((dealerPosition+1) % nbPlayers);
	    }
	    //blinds payment
	    contribute(pSmallBlind, blind/2);
	    contribute(pBigBlind, blind);
	    //Shuffle deck
	    deck.shuffle();
	    //Card distribution
	    for(Player p : players) {
		p.setHand(deck.draw(), deck.draw());
	    }
	    //Designation of the first player to play
	    if (players.size() == 2)
		indexToPlay = dealerPosition;
	    else
		indexToPlay = (dealerPosition+3) % nbPlayers;
	    //Preflop
	    turnLoop(indexToPlay);
	    //Flop
	    deck.burn();
	    board.add(deck.draw());
	    board.add(deck.draw());
	    board.add(deck.draw());
	    indexToPlay = nextPlayer(dealerPosition);
	    turnLoop(indexToPlay);
	    //Turn
	    deck.burn();
	    board.add(deck.draw());
	    turnLoop(indexToPlay);
	    //River
	    deck.burn();
	    board.add(deck.draw());
	    turnLoop(indexToPlay);
	    //find the winner of the turn
	    winner = winnerCalculate();
	    //Distribution of earnings
	    earningsSum = 0;
	    while (winner.isAllIn() && 
		   pot.getContribution(winner) < pot.maxHashValue()))
	    {
		gain = gainCalculate(winner);
		winner.addChips(gain);
		winner.fold();
		earningsSum += gain;
		winner = winnerCalculate();
	    }
	    //winner.addChips(pot - earningsSum);
	    
    }
    
    /**
     * Returns the total of chips earn by the winner
     */
    private int gainCalculate(Player winner){
	int res = 0;
	for (Player p : players){
	    res += gainByContribution(p, pot.getContribution(winner));
	}
    }

    private int gainByContribution(Player player, int contribution){
	int res;
	if (contribution > pot.getContribution(player))
	    res = pot.getContribution(player);
	else 
	    res = contribution;
    }
    
    /**
     * Returns the winner's index of the turn
     */
    private Player winnerCalculate(){
        Player winner;
	int i = 0;
	while (players.get(i).isFolded())
	    i++;
	winner = players.get(i);
	for (int j = i ; j < players.size() ; ++j)
	    {
		if (!players.get(j).isFolded())
		    {
			players.get(j).setValue(board);
			if (winner.compare(players.get(j)) < 0)
			    winner = players.get(j);
		    }
	    }
	return winner;
    }
    
    /**
     * This method produce the loop of a turn (flop, turn, river)
     * with as arguement the first player who must play this turn
     */
    private void turnLoop(int indexToPlay){
	Move playerMove;
	boolean validPlay;
	//Here we make the player play one by one
	while(!roundOver()){
	    validPlay = false;
	    //we need this line for the moment to initialize playerMove
	    playerMove = new Move(Move.Type.CHECK, 0);
	    while(!validPlay){
		//playerMove = Controller.answerPlayer();
		validPlay = checkValidity(playerMove);
	    }
	    updateGame(players.get(indexToPlay), playerMove);
	    indexToPlay = nextPlayer(indexToPlay);
	}
    }
    
    /**
     * This method call the bet function in the player object and 
     * add the bet to the pot (containing pot contribution)
     */
    private void contribute(Player player, int nbChips) {
	player.bet(nbChips);
	if (player.getStack() <= nbChips)
	    pot.addContribution(player.getStack(), player);
	else
	    pot.addContribution(nbChips, player);
    }

    
    /**
     * Returns true if the round is over
     * false if not
     */
    private boolean roundOver(){
	/**
	 * All contribution of non folded and non allin players are 
	 * equal and everyone played at least once.
	 */
	return pot.contributionEqual(); 
    }

    /**
     *Returns true if the game is over
     *false if not
     */
    private boolean gameOver(){
	return true;
    }

    /*private int nbPlayerAlive() {
	int count = 0;
	for(Player p : players) {
	    if(!p.isFolded())
		++count;
	}
	return count;
    }*/

    /**
     * Check if a move is correct
     */
    private boolean checkValidity(Move move) {
	//case when a player raises
	boolean bool = true;
	switch (move.getType()){
	case RAISE:
	    bool = move.getValue() > pot.maxHashValue();
	    /*if (move.getType() == RAISE) {
	    if () {
	    move.setRaiser(false);
	    return (pot.maxHashValue() >= 2*blind);
	    }
	    else {
	    return (pot.maxHashValue() >= ());
	    }*/
	    break;
	case CHECK:
	    //case when check is impossible
	    bool = pot.maxHashValue() == 0;
	    break;
	case CALL:
	    bool = pot.maxHashValue() == 0;
	    break;
	default: break;
	}
	return bool;
    }
    
    /**
     * This method makes the necessary modifications to the move
     * played by the player
     */
    private void updateGame(Player player, Move move){
	switch (move.getType()){
	case RAISE:
	    contribute(player, move.getValue());
	    break;
	case FOLD:
	    player.fold();
	    break;
	case CHECK:
	    player.check();
	    break;
	case CALL:
	    int toCall = pot.maxHashValue() - pot.getContribution(player);
	    player.bet(toCall);
	    contribute(player, toCall);
	    break;
	default: break;
	}
    }
    
    private int nextPlayer(int index){
	int next;
	do {
	    next = (index+1) % nbPlayers;
	}
	while (players.get(next).isFolded() || players.get(next).isAllIn());
	return next;
    }
    
}
