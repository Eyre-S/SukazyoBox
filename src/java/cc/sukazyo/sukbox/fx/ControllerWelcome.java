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
	
	/**
	 * welcomeStage 加载入口
	 */
	public void load () {
		
		/** 加载welcome窗体 */
		root = Util.getFxml("welcome.fxml");
		welcomeStage.setScene(new Scene(root));
		welcomeStage.initStyle(StageStyle.TRANSPARENT);
		welcomeStage.show();
		
	}
	
	/**
	 * Configure按钮执行方法
	 */
	@FXML private void handleConfigureButton () {
	
//		Util.infoUndoThings("试用模式启动");
		/** 启动main */
		SukazyoBox.desktop = new ControllerDesktop();
		SukazyoBox.desktop.init();
		
	}
	
	/**
	 * Login 按钮执行方法
	 */
	@FXML private void handleLogin () {
		System.exit(0);
	}
	
}
