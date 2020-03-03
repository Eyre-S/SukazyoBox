package cc.sukazyo.sukbox.fx;

import cc.sukazyo.sukbox.SukazyoBox;
import cc.sukazyo.sukbox.laple.GameInfo;
import cc.sukazyo.sukbox.laple.GameSimplePerson;
import cc.sukazyo.sukbox.laple.GameUpdate;
import cc.sukazyo.sukbox.util.Logout;
import com.sun.javaws.progress.Progress;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Date;

public class ControllerLaple {
	
	public Stage mainStage;
	private AnchorPane root;
	
	// 游戏线程
	private GameUpdate upd;
	
	// 进度条实体
	@FXML private ProgressBar health;
	@FXML private Slider temperature;
	@FXML private ProgressBar bloody;
	@FXML private ProgressBar hunger;
	@FXML private ProgressBar water;
	@FXML private ProgressBar clean;
	@FXML private ProgressBar power;
	@FXML private ProgressBar mood;
	
	// 动作实体
	@FXML private Button btGivePoison;
	
	public void load () {
		
		
		Logout.info("======================================================");
		Logout.info("#                                                    #");
		Logout.info("#             Kill Lapis_Apple Start!                #");
		Logout.info("#                                                    #");
		Logout.info("#                              -- Game by Sukazyo    #");
		Logout.info("#                                                    #");
		Logout.info("======================================================");
		
		/** 加载fxml */
		root = Util.getFxml("laple.fxml");
		mainStage.setScene(new Scene(root));
		mainStage.initStyle(StageStyle.TRANSPARENT);
		mainStage.show();
		
	}
	
	/**
	 *
	 * 初始化
	 *
	 * @method doBind 绑定属性
	 * @method unlock 解锁按钮可用性
	 *
	 */
	private void doBind () {
		
		GameInfo.laple = new GameSimplePerson();
		health.progressProperty().bind(GameInfo.laple.health);
		temperature.valueProperty().bind(GameInfo.laple.temperature);
		bloody.progressProperty().bind(GameInfo.laple.bloody);
		hunger.progressProperty().bind(GameInfo.laple.hunger);
		water.progressProperty().bind(GameInfo.laple.water);
		clean.progressProperty().bind(GameInfo.laple.clean);
		power.progressProperty().bind(GameInfo.laple.power);
		mood.progressProperty().bind(GameInfo.laple.mood);
		
	}
	
	private void unlock () {
		btGivePoison.setDisable(false);
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
		System.exit(0);
	}
	
	@FXML
	private void actionButtonAdmin () { // 临时作为启动按钮
//		Logout.info("用户点击admin入口");
//		Util.infoUndoThings("Admin 管理面板");
		
		// 初始化属性
		Logout.info("执行游戏开始动作");
		Logout.info("==============================");
		Logout.info("");
		Logout.info("           开始游戏");
		Logout.info("");
		Logout.info("==============================");
		doBind();
		unlock();
		Logout.info("属性初始化完成");
		
		// 打开游戏更新线程
		upd = new GameUpdate();
		upd.setName("GameUpdate");
		upd.start();
		Logout.info("已启动游戏Update线程");
	}
	
	/**
	 *
	 * 执行动作
	 *
	 */
	
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
		
//		double now = GameInfo.laple.health.get() - 0.2;
//		double nhunger = GameInfo.laple.hunger.get() + 0.03;
//		double nmood = GameInfo.laple.mood.get() - 0.16;
		double nbloody = GameInfo.laple.bloody.get() + 0.3;
		double nt = GameInfo.laple.temperature.get() - 0.3;
		
//		GameInfo.laple.health.set(now<0?0:now);
//		GameInfo.laple.hunger.set(nhunger>1?1:nhunger);
//		GameInfo.laple.mood.set(nmood<0?0:nmood);
		GameInfo.laple.bloody.set(nbloody);
		GameInfo.laple.temperature.set(nt);
		
	}
	
}
