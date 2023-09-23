package blackjack.blackjack_group;

/**
 * Dealer class - does everything a dealer would do
 * @author Justin Kadyrov
 * @version 1.0
 * @since 2023-04-02
 */

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class Dealer {

    private Hand hand;
    private Deck deck;
    private HBox dealerHandDisplay;
    
//constructor to define deck, display and hand
public Dealer(Deck deck, HBox dealerHandDisplay, Label lblDealer) {
    this.deck = deck;
    this.dealerHandDisplay = dealerHandDisplay;
    hand = new Hand(deck);
}


/*
dealInitialCards requires player to be passed,
calls hit method, adds 2 cards
 */
    public void dealInitialCards(Player player) {
        player.hit();
        hand.addCard(deck.dealCard());
        player.hit();
        hand.addCard(deck.dealCard());
            System.out.println("dealInital method");
    }

/*
hit method adds cards (removes from deck), and gets the image and returns it (displays)
 */
public void hit() {
  
    hand.addCard(deck.dealCard());

    // display the new card in the dealer's hand
    ImageView cardImage = hand.getHandArr().get(hand.getHandArr().size() - 1).getCardImageView();
    dealerHandDisplay.getChildren().add(cardImage);
    System.out.println("dealer hit method");
}

//resets users hand
    public void reset() {
        hand.reset();
    }

//calculates the numeric value of the players hand
    public int getHandValue() {
        return hand.calculateHandValue();
    }
//returns first card
    public Card getUpCard() {
        return hand.getCard(0);
    }
//tells hit to go when value is less than 17
    public void play() {
        while (getHandValue() < 17) {
            hit();
        }
    }

    public String toString() {
        return hand.toString();
    }
        public Hand getHand() {
        return hand;
    }
}
