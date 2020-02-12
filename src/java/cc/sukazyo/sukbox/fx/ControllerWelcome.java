package cc.sukazyo.sukbox.fx;

import cc.sukazyo.sukbox.SukazyoBox;
import cc.sukazyo.sukbox.util.Logout;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ControllerWelcome {
	
	public Stage welcomeStage;
	
	@FXML
	private Button butConfigure;
	
	@FXML
	private Button butDemoLogin;
	
	private AnchorPane root;
	
	/**
	 * welcomeStage 加载入口
	 *
	 * TODO 链接登录系统
	 *
	 */
	public void load () {
		
		/** 加载welcome窗体 */
		root = Util.getFxml("welcome.fxml");
		welcomeStage.setScene(new Scene(root));
//		welcomeStage.initStyle(StageStyle.TRANSPARENT);
		welcomeStage.show();
		
	}
	
	/**
	 * Configure按钮执行方法
	 *
	 * TODO 完成登陆系统
	 *
	 */
	@FXML private void actionButtonDemoLogin () {
		
		Logout.info("点击 试用模式 按钮");
//		Util.infoUndoThings("试用模式启动");
		/** 启动main */
		SukazyoBox.desktop = new HomeDesktop();
		SukazyoBox.desktop.show();
		Logout.info("退出welcome面板");
		Stage curSt = (Stage)butDemoLogin.getScene().getWindow();
		curSt.close();
	}
	
	/**
	 * Login 按钮执行方法
	 */
	@FXML private void actionButtonLogin () {
		Logout.info("点击 登录 按钮");
		Util.infoUndoThings("登陆面板");
	}
	
}
