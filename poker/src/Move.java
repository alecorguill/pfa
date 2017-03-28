package poker;

import java.util.*;

/**
 * This class is intended to reprensent a move from a player. So it should include
 * the check, fold, raise moves. 
 */

public class Move {
    
    public enum Type {
	RAISE,
	CHECK,
	FOLD,
	CALL;
    }
    
    Type type;   
    //the number of chips here is added to the existing contribution
    int value;

    public Move(Type type, int value) {
	this.type = type;
	this.value = value;
    }

    public Type getType() {
	return type;
    }
    
    public int getValue() {
	return value;
    }

    public String toString(){
	return Integer.toString(value) + " " + type;
    }
}
