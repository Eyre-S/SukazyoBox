package cc.sukazyo.sukbox.fx;

import cc.sukazyo.sukbox.util.Logout;
import cc.sukazyo.sukbox.util.Network;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
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
		Logout.info("返回的是：" + re);
		if (re.equals("N/A")) {
			Logout.info("密钥错误");
			Util.infoWarnError (
					"密钥错误",
					"密钥没有通过验证",
					"输错了吧，再试试\n顺带一提，验证链接是 https://srv.sukazyo.cc/suk-box/configure/ 哦(尝试暗示)");
		} else if (re.equals("Eyre_S")) {
			Logout.info("密钥正确，尝试跳转页面");
			/* 启动main */
			HomeDesktop.start();
			Logout.info("退出welcome面板");
			Stage curSt = (Stage)keyInput.getScene().getWindow();
			curSt.close();
		} else if (re.equals("Kill-LAPPLE")) {
			Logout.info("确认Kill-LAPLE命令，尝试执行");
			HomeLaple.start();
			Logout.info("退出welcome面板");
			Stage curSt = (Stage)keyInput.getScene().getWindow();
			curSt.close();
		} else {
			Util.infoWarnError("网络错误", "好像无法连接到网络讷=-=\n请稍后再试");
		}
	}
	
}
