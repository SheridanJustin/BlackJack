package blackjack.blackjack_group;
/**
 * hand class makes a hand using the Card class and Deck class
 * @author Justin Kadyrov
 * @version 1.0
 * @since 2023-04-02
 */

import blackjack.blackjack_group.Card.Value;
import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand = new ArrayList<>();
    private Deck deck;
    private int handValue;
//constructor for the Hand (adds cards (2))
    public Hand(Deck deck) {
        this.deck = deck;
        addCard(deck.dealCard());
        addCard(deck.dealCard());
    }

    public void addCard(Card card) {
        hand.add(card);
    }
//calculates value and returns to user (numeric value of each card player has)
public int calculateHandValue() {
    int value = 0;
    int numAces = 0;

    for (Card card : hand) {
        if (card.getValue() == Value.ACE) {
            numAces++;
        }
        value += card.getCardValue();
    }

    while (numAces > 0 && value > 21) {
        value -= 10;
        numAces--;
    }

    return value;
}


//gets the array of hand (card)
    public ArrayList<Card> getHandArr() {
        return hand;
    }
//gets individual card by index
    public Card getCard(int index) {
        return hand.get(index);
    }
//resets hand
    public void reset() {
        hand.clear();
        handValue = 0;
    }
    //returns value of hand
    public int getHandValue() {
        return handValue;
    }
    //removes card from hand based on index
    public Card removeCard(int index) {
        return hand.remove(index);
    }
}
