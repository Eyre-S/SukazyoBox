package cc.sukazyo.sukbox.fx;

import cc.sukazyo.sukbox.SukazyoBox;
import cc.sukazyo.sukbox.util.Logout;
import cc.sukazyo.sukbox.util.Network;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControllerLogin {
	
	@FXML
	private TextField keyInput;
	
	/**
	 * TODO 将任务分解至子线程
	 */
	@FXML
	private void actionButtonLogin () {
		String key = keyInput.getText();
		Logout.info("url=https://srv.sukazyo.cc/suk-box/configure/" + "; key=" + key + "; 正在验证...");
		String re = Network.sendGet("https://srv.sukazyo.cc/suk-box/configure/", "key=" + key);
		if (re.equals("false")) {
			Logout.info("密钥错误");
			Util.infoWarnError (
					"密钥错误",
					"密钥没有通过验证",
					"请检查您的输入是否正确");
		} else if (re.equals("true")) {
			Logout.info("密钥正确，尝试跳转页面");
			/* 启动main */
			SukazyoBox.desktop = new HomeDesktop();
			SukazyoBox.desktop.show();
			Logout.info("退出welcome面板");
			Stage curSt = (Stage)keyInput.getScene().getWindow();
			curSt.close();
		} else {
			Util.infoWarnError("网络错误", "无法连接到网络...\n请稍后再试");
		}
	}
	
}
