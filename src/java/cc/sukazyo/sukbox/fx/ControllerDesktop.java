package cc.sukazyo.sukbox.fx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ControllerDesktop {
	
	public Stage mainStage;
	private AnchorPane root;
	
	public void load () {
		
		/** 加载fxml */
		root = Util.getFxml("desktop.fxml");
		mainStage.setScene(new Scene(root));
		mainStage.initStyle(StageStyle.TRANSPARENT);
		mainStage.show();
		
	}
	
}
