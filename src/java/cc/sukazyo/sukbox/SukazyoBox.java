package cc.sukazyo.sukbox;

import cc.sukazyo.sukbox.fx.ControllerDesktop;
import cc.sukazyo.sukbox.fx.ControllerWelcome;
import cc.sukazyo.sukbox.fx.HomeDesktop;
import cc.sukazyo.sukbox.util.Logout;
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
	public static HomeDesktop desktop;
	
	/**
	 * 程序入口，调用FX运行
	 *
	 * @param args 入口选项，用于命令行特殊调用
	 */
	public static void main(String[] args) {
		Logout.info("系统调用，开始初始化与加载欢迎窗口");
		launch(args);
	}
	
	/**
	 * 窗口主程序加载
	 * 加载 welcomeStage
	 *
	 * @param primaryStage 初级场景
	 */
	@Override
	public void start(Stage primaryStage) {
		
		/* 初始化welcomeStage */
		ControllerWelcome welcome = new ControllerWelcome();
		welcome.welcomeStage = primaryStage;
		welcome.welcomeStage.setTitle("Start");

		/* 加载welcomeStage */
//		load();
		welcome.load();
		
	}
	
}
