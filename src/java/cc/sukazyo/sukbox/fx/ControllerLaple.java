package cc.sukazyo.sukbox.fx;

import cc.sukazyo.sukbox.util.Logout;
import com.sun.javaws.progress.Progress;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ControllerLaple {
	
	public Stage mainStage;
	private AnchorPane root;
	
	// 进度条实体
	@FXML private ProgressBar health;
	@FXML private Slider temperature;
	@FXML private ProgressBar bloody;
	@FXML private ProgressBar hunger;
	@FXML private ProgressBar water;
	@FXML private ProgressBar clean;
	@FXML private ProgressBar power;
	@FXML private ProgressBar mood;
	
	public void load () {
		
		/** 加载fxml */
		root = Util.getFxml("laple.fxml");
		mainStage.setScene(new Scene(root));
		mainStage.initStyle(StageStyle.TRANSPARENT);
		mainStage.show();
		
	}
	
	/**
	 *
	 * 顶灯动作
	 *
	 */
	
	@FXML
	private void actionButtonExit () {
		Logout.info("退出应用程序");
		Platform.exit();
	}
	
	@FXML
	private void actionButtonAdmin () {
		Logout.info("用户点击admin入口");
		Util.infoUndoThings("Admin 管理面板");
	}
	
	/**
	 *
	 * 执行动作
	 *
	 */
	
	private void stateChange () {
	
	}
	
	@FXML
	private void giveMedicine () {
		Logout.info("用户执行 喂药 动作");
		
		double now = health.getProgress() + 0.15;
		double nowMood = mood.getProgress() - 0.05;
		
		health.setProgress(now>1?1:now);
		mood.setProgress(nowMood<0?0:nowMood);
	}
	
	@FXML
	private void givePoison () {
		Logout.info("用户执行 投毒 动作");
		
		double now = health.getProgress() - 0.2;
		double nhunger = hunger.getProgress() + 0.03;
		double nmood = mood.getProgress() - 0.16;
		double nt = temperature.getValue() - 0.3;
		
		health.setProgress(now<0?0:now);
		hunger.setProgress(nhunger>1?1:nhunger);
		mood.setProgress(nmood<0?0:nmood);
		temperature.setValue(nt);
		
	}
	
}
