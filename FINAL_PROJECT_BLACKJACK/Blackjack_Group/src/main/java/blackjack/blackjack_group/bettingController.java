package blackjack.blackjack_group;

/**
 * this class controls how the betting gui works
 * works together with the betting.fxml file (in resources)
 * @author Jacob Metcalfe
 * @version 1.0
 * @since 2023-04-01
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Optional;

public class bettingController {

        @FXML
        private Slider bet;

        @FXML
        private Button confirm;

        @FXML
        private GridPane root;

        @FXML
        private HBox title;
        static double userBet;


        /**
         * @param event
         * the fxml file tells the placeBet method to be called on button press
         * this function makes alerts, starting with a confirmation to make sure you actually want to place bet
         * if they click OK, it alerts saying their bet was placed, if not, it tells them their bet was not placed
         */
        @FXML
        void placeBet(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("CONFIRMATION");
                alert.setContentText("Are you sure you want to place this bet of $" + Math.round(bet.getValue()));
                Optional<ButtonType> result = alert.showAndWait();

                if (result.isPresent() && result.get() == ButtonType.OK) {
                //if they hit ok
                        setUserBet(Math.round(bet.getValue()));
                        BlackjackUI.playerBet.setText("Your bet is $" + getUserBet());
                        BlackjackUI.playerBet.setVisible(true);
                        Alert alertTwo = new Alert(Alert.AlertType.INFORMATION);
                        alertTwo.setTitle("INFO");
                        alertTwo.setContentText("You have placed a bet of $" + getUserBet());
                        alertTwo.show();
                        System.out.println(getUserBet());
                        closeWindow();
                } else {
                //if they don't hit ok
                        Alert alertThree = new Alert(Alert.AlertType.INFORMATION);
                        alertThree.setTitle("INFO");
                        alertThree.setContentText("You have NOT placed a bet.");
                        alertThree.show();
                        closeWindow();

                }
        }

        /**
         *
         * @param userBet
         * sets the users bet
         */
        public void setUserBet(double userBet) {
                this.userBet = userBet;
        }

        /**
         *
         * @return users bet
         */
        public double getUserBet() {
                return userBet;
        }

        /**
         * closes the window
         */
        private void closeWindow() {
                // get a handle to the stage
                Stage stage = (Stage) root.getScene().getWindow();
                // do what you have to do
                stage.close();
        }
}

