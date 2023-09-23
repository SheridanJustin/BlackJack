module blackjack.blackjack_group {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;


    opens blackjack.blackjack_group to javafx.fxml;
    exports blackjack.blackjack_group;
}