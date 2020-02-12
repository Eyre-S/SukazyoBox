package cc.sukazyo.sukbox.fx;

import cc.sukazyo.sukbox.util.Logout;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HomeDesktop extends Application {
	
	/**
	 * 主页面单独启动入口
	 *
	 * @param args 启动参数
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * 系统调用的启动方法
	 *
	 * @param primaryStage 初始场景
	 */
	@Override
	public void start(Stage primaryStage) {
		
		ControllerDesktop fxml = new ControllerDesktop();
		fxml.mainStage = primaryStage;
		fxml.mainStage.setTitle("Sukazyo Box");
		
		fxml.load();
		
	}
}
