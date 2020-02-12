package cc.sukazyo.sukbox.fx;

import cc.sukazyo.sukbox.SukazyoBox;
import cc.sukazyo.sukbox.util.Logout;
import com.sun.javafx.robot.impl.FXRobotHelper;
import javafx.collections.ObservableList;
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
	private AnchorPane root;
	
	@FXML
	private Button butConfigure;
	
	@FXML
	private Button butDemoLogin;
	
	/**
	 * welcomeStage 加载入口
	 *
	 * TODO 链接登录系统
	 *
	 */
	public void load () {
		
		/* 加载welcome窗体 */
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
		
		Logout.info("通过试用模式开启主面板");
		/* 启动main */
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
		Logout.info("打开登录面板");
		ObservableList<Stage> stage = FXRobotHelper.getStages();
		Scene scene = new Scene(Util.getFxml("login.fxml"));
		stage.get(0).setScene(scene);
	}
	
}
