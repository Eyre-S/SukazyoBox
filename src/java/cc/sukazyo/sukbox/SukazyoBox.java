package cc.sukazyo.sukbox;

import cc.sukazyo.sukbox.fx.ControllerWelcome;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SukazyoBox extends Application {
	
//	private Stage welcomeStage;
//	private AnchorPane root;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		ControllerWelcome welcome = new ControllerWelcome();
		welcome.welcomeStage = primaryStage;
		welcome.welcomeStage.setTitle("Start");
		
//		load();
		welcome.load();
	}
	
//	private void load() throws IOException {
//		FXMLLoader loader = new FXMLLoader();
//		loader.setLocation(SukazyoBox.class.getResource("/fxml/welcome.fxml"));
//		root = loader.load();
//
//		welcomeStage.setScene(new Scene(root));
//		welcomeStage.show();
//	}
}
