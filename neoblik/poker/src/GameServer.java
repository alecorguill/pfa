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
    private boolean preflop;

    private static final List<Move.Type> VALUES =
	Collections.unmodifiableList(Arrays.asList(Move.Type.values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();
    
    /**
     * GameServer constructor. Initialize the pot, the deck (unshuffled), the dealer     
     * Position
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
	    //Position update
	    dealerPosition = (dealerPosition+1) % nbPlayers;
	    
	    System.out.println("Dealer : " + dealerPosition);
	    //Small and Big Blind Assignment
	    if (players.size() == 2){
		pSmallBlind = players.get(dealerPosition % nbPlayers);
	        pBigBlind = players.get((dealerPosition+1) % nbPlayers);
	    }
	    else{
		pSmallBlind = players.get((dealerPosition+1) % nbPlayers);
		pBigBlind   = players.get((dealerPosition+2) % nbPlayers);
	    }
	    //blinds payment
	    contribute(pSmallBlind, blind/2, true);
	    contribute(pBigBlind, blind, true);
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
	    preflop = true;
	    	System.out.println("equal : " + pot.contributionEqual());
	    System.out.println("Preflop");
	    turnLoop(indexToPlay);
	    preflop = false;
	    resetPlayers();
	    //Flop
	    	    System.out.println("Flop");
	    deck.burn();
	    board.add(deck.draw());
	    board.add(deck.draw());
	    board.add(deck.draw());
	    indexToPlay = nextPlayer(dealerPosition);
	    turnLoop(indexToPlay);
	    resetPlayers();
	    //Turn
	    System.out.println("Turn");
	    deck.burn();
	    board.add(deck.draw());
	    turnLoop(indexToPlay);
	    resetPlayers();
	    //River
	    	    System.out.println("River");
	    deck.burn();
	    board.add(deck.draw());
	    turnLoop(indexToPlay);
	    resetPlayers();
	    //find the winner of the turn
	    winner = winnerCalculate();
	    //Distribution of earnings
	    earningsSum = 0;
	    while (winner.isAllIn() && 
		   pot.getContribution(winner) < pot.maxHashValue())
	    {
		System.out.println("earn distrib");
		gain = gainCalculate(winner);
		winner.addChips(gain);
		winner.fold();
		earningsSum += gain;
		winner = winnerCalculate();
	    }
	    winner.addChips(pot.getPot() - earningsSum);
	    //reset of different entities
	    	    System.out.println("Reset");
	    resetGame();
	    	    System.out.println();
	} 
	System.out.println("Et cest fucking gagne, bien joue Jack");
    }

    /**
     * Reset players' status at the end of a 'little round' (flop, turn)
     */ 
    private void resetPlayers(){
	for (Player p : players)
	    p.newLittleRound();
    }

    /**
     * Reset different entities of the game to begin a new round
     */
    private void resetGame(){
	pot.reset();
	//We reset the state of the players that depend on
	//the round and delete those who lost
	for (int i = 0 ; i < nbPlayers ; ++i){
	    if (players.get(i).getStack() <= 0){
		players.remove(players.get(i));
		nbPlayers--;
	    }
	    else {
		players.get(i).newBigRound();
	    }
	}
	deck.init();
	board.clear();
    }
    
    /**
     * The two methods below are used to compute the number 
     * of chips the winner earned
     */
    private int gainCalculate(Player winner){
	int res = 0;
	for (Player p : players){
	    res += gainByContribution(p, pot.getContribution(winner));
	}
	return res;
    }

    private int gainByContribution(Player player, int contribution){
	int res;
	if (contribution > pot.getContribution(player))
	    res = pot.getContribution(player);
	else 
	    res = contribution;
	return res;
    }
    
    /**
     * Returns the winner's index of the turn
     */
    private Player winnerCalculate(){
        Player winner;
	int i = 0;
	/*while (players.get(i).isFolded())
	    System.out.println("isfolded");
	    i++;*/
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
     * and a boolean for the preflop case
     */
    private void turnLoop(int indexToPlay){
	Move playerMove;
	boolean validPlay;
	Player player;
	//Here we make the player play one by one
	while(!roundOver()){
	    System.out.println("roundover");
	    player = players.get(indexToPlay);
	    validPlay = false;
	    //we need this line for the moment to initialize playerMove
	    playerMove = new Move(Move.Type.CHECK, 0);
	    while(!validPlay){
		System.out.println("valideplay");
		//For the moment the move is choose randomly
		playerMove = randomIA(player);
		validPlay = checkValidity(playerMove, player);
	    }
	    
	    System.out.println("Coup : " + playerMove + ", Player : " + indexToPlay + ", Stack : " + players.get(indexToPlay).getStack());
	    System.out.println("Pot : Total = " + pot.getPot() + "\n" + pot);
	    
	    System.out.println();
	    updateGame(players.get(indexToPlay), playerMove);
	    indexToPlay = nextPlayer(indexToPlay);
	}
    }

    /**
     * Returns the number of non folded players
     */
    private int nbPlayerNFolded(){
	int res = 0;
	for (Player p : players){
	    if (!p.isFolded())
		res++;
	}
	return res;
    }

    /**
     * Returns the number of the players in game whose are all In
     * or folded only
     */
    private int nbFoldedOrAllIn(){
	int res = 0;
	for (Player p : players){
	    if (p.isFolded() || p.isAllIn())
		res++;
	}
	return res;
    }

    /**
     * This method call the bet function in the player object and 
     * add the bet to the pot (containing pot contribution)
     * It takes a boolean to know if it concerns blinds
     */
    private void contribute(Player player, int nbChips, boolean blind) {
	if (player.getStack() <= nbChips)
	    pot.addContribution(player.getStack(), player);
	else
	    pot.addContribution(nbChips, player);
	player.bet(nbChips, blind);
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
	System.out.println("equal : " + pot.contributionEqual());
	System.out.println("all played : " + allPlayersPlayed());

	Player pBigBlind;
	boolean b = allPlayersPlayed() && pot.contributionEqual();
	System.out.println("nbplayers : " + nbPlayers + " ; nbFoldedOrAllIn : " + nbFoldedOrAllIn());
	if (nbPlayers - nbFoldedOrAllIn() <= 1){
	    return true;
	}
	if (players.size() == 2){
	        pBigBlind = players.get((dealerPosition+1) % nbPlayers);
	    }
	    else{
		pBigBlind = players.get((dealerPosition+2) % nbPlayers);
	    }
	if (preflop){
	    return b && pBigBlind.hasPlayed();
	}
	return b;
    }

    /**
     * Returns true if all non all in players played
     */
    private boolean allPlayersPlayed(){
	for (Player p : players){
       	    if (!p.hasPlayed() && !p.isAllIn() && !p.isFolded())
	        return false;
	}
	return true;
    }

    /**
     *Returns true if the game is over
     *false if not
     */
    private boolean gameOver(){
	return nbPlayers == 1;
    }

    /**
     * Check if the move of the player p is correct
     */
    private boolean checkValidity(Move move, Player p) {
	//case when a player raises
	boolean bool = true;
	switch (move.getType()){
	case RAISE:
	    bool = move.getValue() + pot.getContribution(p) > pot.maxHashValue();
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
	    bool = pot.contributionEqual();
	    break;
	case CALL:
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
	    contribute(player, move.getValue(), false);
	    break;
	case FOLD:
	    player.fold();
	    break;
	case CHECK:
	    player.check();
	    break;
	case CALL:
	    int toCall = pot.maxHashValue() - pot.getContribution(player);
	    contribute(player, toCall, false);
	    break;
	default: break;
	}
    }

    private int nextPlayer(int index){
	int next = index;
	do {
	    next = (next+1) % nbPlayers;
	    System.out.println("nextPlayer");
	}
	while (nbFoldedOrAllIn() > 0 && 
	       (players.get(next).isFolded() || players.get(next).isAllIn()));
	return next;
    }

    /**
     * This method returns a random move. Used to test the game
     */
    private Move randomIA(Player p){
	Move.Type type;
	int value;
	if (pot.contributionEqual()){
	    do {
		type = VALUES.get(RANDOM.nextInt(SIZE));
		value = pot.maxHashValue() + RANDOM.nextInt(100);
		System.out.println("IA");
	    }
	    while (type != Move.Type.CHECK && type != Move.Type.RAISE);
	}
	else {
	    do {
		type = VALUES.get(RANDOM.nextInt(SIZE));
		value = pot.maxHashValue() + RANDOM.nextInt(100);
				System.out.println("IA");
	    }
	    while (type == Move.Type.CHECK);
	}
	/*Move.Type type;
	if (pot.maxHashValue() > pot.getContribution(p))
	    type = Move.Type.CALL;
	else type = Move.Type.CHECK;*/
	return new Move(type, value);
    }
}
