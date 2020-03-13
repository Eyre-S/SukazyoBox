package cc.sukazyo.sukbox.fx;

import cc.sukazyo.sukbox.SukazyoBox;
import cc.sukazyo.sukbox.util.Logout;
import javafx.application.Application;
import javafx.stage.Stage;

public class HomeLaple extends Application {
	
	Stage stage = new Stage();
	
	/**
	 * 主页面单独启动入口
	 *
	 * @param args 启动参数
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
	public void show() {
		Logout.info("正在启动桌面面板");
		start(stage);
	}
	
	/**
	 * 系统调用的启动方法
	 *
	 * @param primaryStage 初始场景
	 */
	@Override
	public void start(Stage primaryStage) {
		
		ControllerLaple fxml = new ControllerLaple();
		fxml.mainStage = primaryStage;
		fxml.mainStage.setTitle("Kill Lapis_Apple! ~ Sukazyo Box");
		
		fxml.load();
		
	}
	
	/**
	 * 桌面启动任务
	 */
	public static void start() {
		SukazyoBox.laple = new HomeLaple();
		SukazyoBox.laple.show();
	}
}
