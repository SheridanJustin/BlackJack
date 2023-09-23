package blackjack.blackjack_group;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
/**
 * Represents a player in the game of blackjack.
 *
 * The player has a hand, a score, and can hit to draw additional cards.
 *
 * @author Justin Kadyrov
 */
public class Player {

    /**
     * The player's current hand.
     */
    private Hand hand;

    /**
     * The player's current score.
     */
    private int score;

    /**
     * The deck of cards used in the game.
     */
    private Deck deck;

    /**
     * The HBox container for displaying the player's hand of cards.
     */
    private HBox playerHandDisplay;

    /**
     * The betting controller used for handling player bets.
     */
    private bettingController controller;

    /**
     * Creates a new player with the specified deck, hand display, and betting controller.
     *
     * @param deck              the deck of cards to use in the game
     * @param playerHandDisplay the container for displaying the player's hand of cards
     * @param controller        the betting controller used for handling player bets
     * @param lblPlayer
     */
    public Player(Deck deck, HBox playerHandDisplay, bettingController controller, Label lblPlayer) {
        this.deck = deck;
        this.playerHandDisplay = playerHandDisplay;
        this.controller = controller;
        hand = new Hand(deck);
        score = 0;
    }

    /**
     * Draws a new card from the deck and adds it to the player's hand.
     *
     * <p>Also updates the player's score and displays the new card in the hand display.</p>
     */
    public void hit() {
        hand.addCard(deck.dealCard());

        // display the new card in the player's hand
        ImageView cardImage = hand.getHandArr().get(hand.getHandArr().size() - 1).getCardImageView();
        playerHandDisplay.getChildren().add(cardImage);

        score = calculateScore();
        System.out.println("Player hit method");
    }

    /**
     * Resets the player's hand and score to their initial values.
     */
    public void resetHand() {
        hand.reset();
        score = 0;
    }

    /**
     * Calculates the player's current score based on the value of their hand.
     *
     * @return the player's score
     */
    public int calculateScore() {
        int score = hand.calculateHandValue();
        return score;
    }

    /**
     * Returns the player's current hand.
     *
     * @return the player's hand
     */
    public Hand getHand() {
        return hand;
    }

    /**
     * Returns the player's current score.
     *
     * @return the player's score
     */
    public int getScore() {
        return score;
    }
}