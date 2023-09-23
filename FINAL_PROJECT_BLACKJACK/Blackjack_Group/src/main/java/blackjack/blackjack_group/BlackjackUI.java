package blackjack.blackjack_group;
/**
 * javafx application for the main GUI
 * @author Justin Kadyrov
 * @version 1.0
 * @since 2023-04-02
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;


import java.io.IOException;

public class BlackjackUI extends Application {

    private Deck deck;
    private Player player;
    private Dealer dealer;
    private boolean gameOver;
    bettingController controller = new bettingController();
    static Label playerBet = new Label("Your bet is $: ");

    private Label resultLabel;
    private VBox root;

    /**
     * This method starts the application and initializes the stage and scene for the GUI
     * @param stage1 The primary stage for this application
     * @throws Exception Throws an exception if there is an error in loading the FXML file or initializing the scene
     */
    @Override
    public void start(Stage stage1) throws Exception {
        Label title = new Label("Blackjack");
        title.setAlignment(Pos.TOP_CENTER);
        playerBet.setFont(Font.font("Arial", FontWeight.BOLD, 23));

        title.setAlignment(Pos.TOP_CENTER);
        title.setFont(Font.font("Arial", FontWeight.BOLD, 48));
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(2.0);
        dropShadow.setOffsetY(2.0);
        dropShadow.setColor(Color.BLACK);
        title.setEffect(dropShadow);
        title.setStyle("-fx-text-fill: linear-gradient(from 0% 0% to 0% 100%, #4c4cff 0%, #00ffaa 100%);");



        root = new VBox(1);
        resultLabel = new Label();
        resultLabel.setStyle("-fx-font-size: 24;");
        resultLabel.setMaxHeight(50);
        resultLabel.setAlignment(Pos.CENTER);

        playerBet.setVisible(false);
        deck = new Deck();
        deck.shuffle();
        gameOver = false;


        Button deal = new Button("Deal");
        Button hit = new Button("Hit");
        Button stand = new Button("Stand");
        Button bet = new Button("Betting");
        hit.setVisible(false);
        stand.setVisible(false);


        HBox buttonBox = new HBox(10,deal,hit,stand,bet);
        buttonBox.setMaxHeight(100);





        buttonBox.setAlignment(Pos.CENTER);

        HBox playerHandDisplay = new HBox(10);
        playerHandDisplay.setPrefWidth(500);
        playerHandDisplay.setPrefHeight(200);
        playerHandDisplay.setAlignment(Pos.CENTER);

        HBox dealerHandDisplay = new HBox(10);
        dealerHandDisplay.setPrefWidth(500);
        dealerHandDisplay.setPrefHeight(200);
        dealerHandDisplay.setAlignment(Pos.CENTER);





        dealerHandDisplay.setVisible(true);

        Label lblPlayer = new Label("Player's Hand:");
        lblPlayer.setFont(Font.font ("Verdana", 20));
        lblPlayer.setTextFill(Color.WHITE);
        lblPlayer.setPrefWidth(500);
        lblPlayer.setAlignment(Pos.CENTER);


        Label lblDealer = new Label("Dealer's Hand:");
        lblDealer.setFont(Font.font ("Verdana", 20));


        lblDealer.setTextFill(Color.WHITE);
        lblDealer.setPrefWidth(500);
        lblDealer.setAlignment(Pos.CENTER);


        player = new Player(deck, playerHandDisplay, controller, lblPlayer);
        dealer = new Dealer(deck, dealerHandDisplay, lblDealer);


        /**
         * @param actionEvent
         * @param bettingScreen
         * This method calls the bettingApp class, and runs it's betting fxml page
         * this sets the scene the exact same way it does in said betting application
         * (if user clicks button, application appears)
         */
        EventHandler<ActionEvent> bettingScreen = (ActionEvent actionEvent) -> {
            Stage stage2 = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(bettingApp.class.getResource("betting.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 320, 240);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage2.setTitle("Betting!");
            stage2.setScene(scene);
            stage2.show();
        };

        bet.setOnAction(bettingScreen);
        /**
         * @param actionEvent
         * @param dealCards
         * this event deals cards to users and manipulates the screen
         */
        EventHandler<ActionEvent> dealCards = (ActionEvent actionEvent) -> {
            stand.setVisible(true);
            bet.setVisible(false);
            playerBet.setVisible(false);
            if (gameOver) {
                // Remove the result label
                resultLabel.setText("");
                gameOver = false;

                // Ensure hit and stand buttons are visible for the new round
                hit.setVisible(false);
                stand.setVisible(true);
            }

            // Reset hands
            player.resetHand();
            dealer.reset();

            // Deal two cards to player and dealer
            dealer.dealInitialCards(player);

            // Clear previous hand displays
            playerHandDisplay.getChildren().clear();
            dealerHandDisplay.getChildren().clear();

            // Display player's hand
            for (Card c : player.getHand().getHandArr()) {
                playerHandDisplay.getChildren().add(c.getCardImageView());
            }
            playerHandDisplay.setVisible(true);

            // Display dealer's first card
            dealerHandDisplay.getChildren().add(dealer.getHand().getHandArr().get(0).getCardImageView());
            dealerHandDisplay.setVisible(true);

            // Hide "Deal" button if it's the first deal
            if (player.getHand().getHandArr().size() == 2) {

                deal.setVisible(false);
            }

            // Check if player has blackjack or bust
            if (player.getScore() == 21) {
                gameOver = true;
                showResult("Blackjack! You win $" + controller.getUserBet());
                bet.setVisible(true);
                stand.setVisible(false);
                deal.setVisible(true);
            } else if (player.getScore() > 21) {
                gameOver = true;
                showResult("Bust! You lose. $" + controller.getUserBet());
                bet.setVisible(true);
                deal.setVisible(true);
                stand.setVisible(false);
            } else {
                hit.setVisible(true);
            }
        };


        deal.setOnAction(dealCards);
        /**
         * @param actionEvent
         * @param hitAction
         * called when user clicks "hit"
         * adds cards to screen, checks your hands value
         */
        EventHandler<ActionEvent> hitAction = (ActionEvent actionEvent) -> {
            if (!gameOver) {
                player.hit();
                playerHandDisplay.getChildren().clear();
                for (Card c : player.getHand().getHandArr()) {
                    playerHandDisplay.getChildren().add(c.getCardImageView());
                }

                if (player.getScore() > 21) {
                    gameOver = true;
                    showResult("Bust! You lose. $" + controller.getUserBet());
                    hit.setVisible(false);
                    deal.setVisible(true);
                    stand.setVisible(false);
                }

            }
        };

        hit.setOnAction(hitAction);
        /**
         * @param ActionEvent
         * @param checkDealerHand
         * this event checks the dealers hand's value and calls according methods
         */
        EventHandler<ActionEvent> checkDealerHand = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                hit.setVisible(false);
                updateDealerHandDisplay();

                dealer.play();

                standOutcome();

                deal.setVisible(true);
                stand.setVisible(false);
            }

            /**
             * updates the dealers hand with card images
             */
            private void updateDealerHandDisplay() {
                // Display dealer's hand
                dealerHandDisplay.getChildren().clear();
                for (Card c : dealer.getHand().getHandArr()) {
                    dealerHandDisplay.getChildren().add(c.getCardImageView());
                }
                dealerHandDisplay.setVisible(true);
            }

            /**
             * when user clicks "stand" this function is used to validate who wins
             */
            private void standOutcome() {
                // Check if dealer has blackjack or bust
                if (dealer.getHandValue() == 21) {
                    gameOver = true;
                    showResult("Dealer has blackjack!");
                    bet.setVisible(true);
                    stand.setVisible(false);
                    deal.setVisible(true);
                } else if (dealer.getHandValue() > 21) {
                    gameOver = true;
                    showResult("Dealer busts!");
                    bet.setVisible(true);
                    hit.setVisible(false);
                    bet.setVisible(true);
                } else {
                    determineWinner();
                }
            }

            /**
             * another method to determine winner (without stand)
             */
            private void determineWinner() {
                if (player.getScore() > dealer.getHandValue()) {
                    gameOver = true;
                    showResult("You won.");
                    bet.setVisible(true);
                    deal.setVisible(true);
                    hit.setVisible(false);
                } else if (dealer.getHandValue() > player.getScore()) {
                    gameOver = true;
                    showResult("You lost.");
                    bet.setVisible(true);
                    deal.setVisible(true);
                    hit.setVisible(false);
                } else {
                    gameOver = true;
                    showResult("It's a tie!");
                    bet.setVisible(true);
                    deal.setVisible(true);
                    hit.setVisible(false);
                }
            }
        };


        stand.setOnAction(checkDealerHand);

        //this all changes and moves things around
        VBox playerBox = new VBox(5, lblPlayer, playerHandDisplay);
        playerBox.setAlignment(Pos.TOP_CENTER);






        VBox dealerBox = new VBox(5, lblDealer, dealerHandDisplay,title);
        dealerBox.setAlignment(Pos.TOP_CENTER);

        VBox boxes = new VBox(5, playerBox, dealerBox);


        deal.setStyle("-fx-background-color: #3E3C35;");
        deal.setFont(Font.font ("Verdana", 20));
        deal.setTextFill(Color.WHITE);
        bet.setStyle("-fx-background-color: #3E3C35;");
        bet.setFont(Font.font ("Verdana", 20));
        bet.setTextFill(Color.WHITE);
        hit.setStyle("-fx-background-color: #3E3C35;");
        hit.setFont(Font.font ("Verdana", 20));
        hit.setTextFill(Color.WHITE);
        stand.setStyle("-fx-background-color: #3E3C35;");
        stand.setFont(Font.font ("Verdana", 20));
        stand.setTextFill(Color.WHITE);


        HBox betInfo = new HBox(1, playerBet);
        root.getChildren().addAll(boxes, betInfo);
        boxes.setAlignment(Pos.TOP_CENTER);


        betInfo.setAlignment(Pos.CENTER);



        root.getChildren().addAll(title,dealerBox, playerBox, playerBet, buttonBox, resultLabel);

        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #05630b;");

        VBox.setMargin(betInfo, new Insets(1, 1, 1, 1)); // Change top margin to 20 pixels
        betInfo.setMaxHeight(50); // Set max height to 50 pixels
        title.setPrefHeight(100);
        buttonBox.setPrefHeight(400);




        Scene scene = new Scene(root, 700, 700);

        stage1.setTitle("Blackjack");
        stage1.setScene(scene);
        stage1.show();
    }

    /**
     *
     * @param result
     * this method gets called in all output statements for winning / losing
     * result is passed to the method, checked for certain words, passes response
     * response depends on what string is passed, and changes your bet to output winnings / losings
     */
    private void showResult(String result) {
        double winnings = 0;

        if (result.contains("Blackjack")) {
            winnings = controller.getUserBet() + controller.getUserBet() * 1.5;
            result += String.format(" You win $%.2f!", winnings);
        } else if (result.contains("Dealer busts") || result.contains("You won")) {
            winnings = controller.getUserBet() * 2;
            result += String.format(" You win $%.2f!", winnings);
        } else if (result.contains("You lost") || result.contains("Dealer has blackjack")) {
            winnings = -controller.getUserBet();
            result += String.format(" You lose $%.2f.", Math.abs(winnings));
        } else if (result.contains("It's a tie")) {
            winnings = 0;
            result += " No money exchanged.";
        }

        // Update the player's balance here
        // player.updateBalance(winnings);

        resultLabel.setText(result);


    }



}


