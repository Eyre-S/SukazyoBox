package cc.sukazyo.sukbox.fx;

import cc.sukazyo.sukbox.util.Logout;
import javafx.application.Platform;
import javafx.fxml.FXML;
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
	
	@FXML
	private void actionButtonExit () {
		Logout.info("退出应用程序");
		Platform.exit();
	}
	
}
