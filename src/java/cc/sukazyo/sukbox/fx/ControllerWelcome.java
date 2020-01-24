package cc.sukazyo.sukbox.fx;

import cc.sukazyo.sukbox.SukazyoBox;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ControllerWelcome {
	
	public Stage welcomeStage;
	
	private AnchorPane root;
	
	public void load () {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(SukazyoBox.class.getResource("/fxml/welcome.fxml"));
		
		try {
			root = loader.load();
		} catch (IOException e) {
			System.out.println("[LOAD]FXML File not found!");
			e.printStackTrace();
		}
		
		
		welcomeStage.setScene(new Scene(root));
		welcomeStage.initStyle(StageStyle.TRANSPARENT);
		welcomeStage.show();
		
	}
	
	@FXML
	private void handleConfigureButton () {
		util.infoUndoThings("试用模式启动");
	}
	
	@FXML
	private void handleLogin () {
		util.infoUndoThings("验证模式启动");
	}
	
}
