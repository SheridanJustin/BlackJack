package blackjack.blackjack_group;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Gabriel Pooranachandran
 * This class is the driver class for the Login screen, it contains the start() method, and the main method.
 */
public class Main_Login extends Application {

	/**
	 * The Stage object used to display the game screen.
	 */
	public static Stage newStage;

	/**
	 * This method is called when the application is launched and displays the Login screen.
	 *
	 * @param loginStage the Stage object used to display the Login screen.
	 * @throws IOException if there is an error loading the FXML file.
	 */
	@Override
	public void start(Stage loginStage) throws IOException {

		FXMLLoader fxmlloader = new FXMLLoader(Main_Login.class.getResource("blacknyack.fxml"));
		Scene scene = new Scene(fxmlloader.load(), 600, 400);
		loginStage.setTitle("Login Screen");

		loginStage.setScene(scene);
		loginStage.show();

	}

	/**
	 * The main method of the application which launches the JavaFX application.
	 *
	 * @param args the command line args.
	 */

	public static void main(String[] args) {
		launch(args);
	}
}