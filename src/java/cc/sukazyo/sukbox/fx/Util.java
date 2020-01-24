package cc.sukazyo.sukbox.fx;

import cc.sukazyo.sukbox.SukazyoBox;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;

import java.io.IOError;
import java.io.IOException;

/**
 * 和界面相关的util类
 *
 * 用于通用界面消息处理
 */
public class Util {
	
	public static void infoUndoThings(String thing) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("未添加功能");
		alert.setHeaderText(null);
		alert.setContentText("功能<" + thing + ">暂未添加，请耐心等待");
		alert.showAndWait();
	}
	
	/**
	 * 获取一个fxml实例
	 *
	 * TODO 异常提醒处理
	 *
	 * @param loc fxml文件在/fxml/目录下的相对位置
	 * @return 作为AnchorPane返回的root元素
	 */
	public static AnchorPane getFxml(String loc) {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(SukazyoBox.class.getResource("/fxml/" + loc));
		try {
			AnchorPane pane = loader.load();
			System.out.println("[INFO]Success load file.");
			return pane;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
}
