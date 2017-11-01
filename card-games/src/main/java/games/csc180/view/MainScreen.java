package games.csc180.view;

import java.io.IOException;
import java.util.ArrayList;

import games.csc180.model.Card;
import games.csc180.model.Player;
import games.csc180.model.games.Poker;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainScreen extends Application {
	private Stage primaryStage, popupStage;
	private Scene mainScene;
	private Parent popup;

	@FXML
	private Button initWar, startWar, quitWar, startPoker, quitPoker;

	@Override
	public void start(Stage stage) throws Exception {
		primaryStage = stage;
		mainScreen(primaryStage);
	}

	private void mainScreen(Stage stage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("SelectGame.fxml"));
		mainScene = new Scene(root);
		primaryStage.setTitle("Card Games");
		primaryStage.setScene(mainScene);
		primaryStage.setResizable(false);
		primaryStage.setMaximized(true);
		primaryStage.show();
	}

	@FXML
	private void initWar(ActionEvent e) throws IOException {
		popupStage = new Stage();
		popup = FXMLLoader.load(getClass().getResource("WarPopup.fxml"));
		popupStage.setScene(new Scene(popup));
		popupStage.setTitle("War Options");
		popupStage.initModality(Modality.NONE);
		popupStage.initOwner(initWar.getScene().getWindow());
		popupStage.showAndWait();

	}

	@FXML
	private void startWar(ActionEvent e) throws IOException {
		Scene wScene = startWar.getScene();
		Parent war = FXMLLoader.load(getClass().getResource("War.fxml"));
		mainScene = wScene;
		mainScene.setRoot(war);
	}


	@FXML // good
	private void startPoker(ActionEvent e) throws IOException {
		Scene pScene = startPoker.getScene();
		Parent poker = FXMLLoader.load(getClass().getResource("Poker.fxml"));
		mainScene = pScene;
		mainScene.setRoot(poker);
	}

	@FXML
	private void quitPoker(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("SelectGame.fxml"));
		mainScene = new Scene(root);
		mainScene.setRoot(root);
	}

}
