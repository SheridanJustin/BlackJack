package blackjack.blackjack_group;

/**
javafx application for the betting GUI
this is called by the main blackjack GUI when the user presses the betting button

@author Jacob Metcalfe
@version 1.0
@since 2023-04-02

 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
this tells the application to call the betting fxml document, and set the scene size
 */
public class bettingApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(bettingApp.class.getResource("betting.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Betting!");
        stage.setScene(scene);
        stage.show();
    }

}
