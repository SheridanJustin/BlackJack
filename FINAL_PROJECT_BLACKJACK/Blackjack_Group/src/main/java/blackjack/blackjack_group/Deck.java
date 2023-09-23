package blackjack.blackjack_group;

/**
 *Deck class - makes a dynamic array of the Card class
 * @author Jacob Metcalfe
 * @version 1.0
 * @since 2023-04-02
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {
    private static final int NUM_OF_CARDS = 52;
    private ArrayList<Card> deck = new ArrayList<>();
    private int numOfDecks;

    //allows the game to only use one deck
    public Deck() {
        this(1);
    }

    //creates one deck (constructor)
    public Deck(int numOfDecks) {
        this.numOfDecks = numOfDecks;
        createDeck();
    }

    /*
    this method sets the suit to 0 initially and value to 1 (value 0 is defined as null)
    adds cards from the Card class based off how many decks / cards are needed ( 52 )
    if the value is 14, changes it back to beginning, same thing for suit ( less repeated cards )
     */
    private void createDeck() {
        int suitVal = 0;
        int valueVal = 1;
        for (int i = 0; i < numOfDecks * NUM_OF_CARDS; i++) {
            deck.add(new Card(Card.Suit.values()[suitVal], Card.Value.values()[valueVal]));
            valueVal++;

            if (valueVal == 14) {
                valueVal = 1;
                suitVal++;
                if (suitVal == 4) {
                    suitVal = 0;
                }
            }
        }
    }

    //returns how many decks are being used
    public int getNumOfDecks() {
        return numOfDecks;
    }

    /*
    changes the array of cards to a list, to shuffle it, and changes this to be the new array returned
     */
    public void shuffle() {
        Card[] deckArr = new Card[numOfDecks * NUM_OF_CARDS];
        deck.toArray(deckArr);
        List<Card> cardList = Arrays.asList(deckArr);
        Collections.shuffle(cardList);
        this.deck = new ArrayList<>(cardList);
    }

    /*
    tostring to return every single card as a string
     */
    public String toString() {
        String toReturn = "";
        for (int i = 0; i < deck.size(); i++) {
            toReturn += deck.get(i).toString() + "\n";
        }
        return toReturn;
    }
    //allows user to access and see what index their card is
    public Card getCard(int index) {
        return deck.get(index);
    }
    //removes card based on index
    public void removeCard(int index) {
        deck.remove(index);
    }
    //returns created arraylist (deck)
    public ArrayList<Card> getDeck() {
        return deck;
    }
    /*
    as long as the deck is greater than 0, deals (removes) cards
    once the deck is fully used up, makes a new deck and shuffles and deals again
     */
    public Card dealCard() {
        if (deck.size() > 0) {
            return deck.remove(0);
        } else {
            System.out.println("No cards left in the deck. Reshuffling...");
            createDeck();
            shuffle();
            return deck.remove(0);
        }
    }
}
