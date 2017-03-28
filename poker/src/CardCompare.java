   

package poker;
import java.util.*;
class CardCompare implements Comparator<Card> {
 /**
     * This method compare two cards based on their 
     * value, it is used to sort an array of cards
     * for instance in the class Value.
     */
    @Override
    public int compare(Card c1, Card c2) {
        return c1.getValue()-c2.getValue();
    }
}
