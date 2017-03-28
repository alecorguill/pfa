package poker;

public class Launch{
    public static void main(String[] args){
	GameServer game = new GameServer(4);
	game.start();
    } 
}
