package games.csc180.view;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainScreen extends Application {
	private Stage primaryStage;
	private Scene mainScene;
	
	@FXML
	private Button startWar, quitWar;

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
	private void startWar(ActionEvent e) throws IOException {
		Scene pScene = startWar.getScene();
		Parent war = FXMLLoader.load(getClass().getResource("War.fxml"));
		mainScene = pScene;
		mainScene.setRoot(war);
	}
	
	
	

}
