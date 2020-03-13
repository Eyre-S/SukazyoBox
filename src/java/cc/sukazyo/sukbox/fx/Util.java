package cc.sukazyo.sukbox.fx;

import cc.sukazyo.sukbox.SukazyoBox;
import cc.sukazyo.sukbox.util.Logout;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;

/**
 * 和界面相关的util类
 *
 * 用于通用界面消息处理
 */
public class Util {
	
	/**
	 * 未实现提醒
	 * 用于在未实现的功能的入口中调用
	 *
	 * @param thing 功能名
	 */
	public static void infoUndoThings(String thing) {
		Logout.info("显示<" + thing + ">功能未启用");
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("未添加功能");
		alert.setHeaderText(null);
		alert.setContentText("<" + thing + "> 还没做哦");
		alert.showAndWait();
	}
	
	/**
	 * 显示一条警告
	 *
	 * @param title 窗口标题
	 * @param header 主标题
	 * @param content 提示内容
	 */
	public static void infoWarnError(String title, String header, String content) {
		Logout.info("显示错误窗口：" + title + "\n\theader:" + header + "\n\tcontent:" + content);
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
	}
	
	/**
	 * 显示一条警告（缩略版）
	 *
	 * @param title 窗口标题
	 * @param content 主标题
	 */
	public static void infoWarnError (String title, String content) {
		infoWarnError(title, null, content);
	}
	
	/**
	 * 获取一个fxml实例
	 *
	 * @param loc fxml文件在/fxml/目录下的相对位置
	 * @return 作为AnchorPane返回的root元素
	 */
	public static AnchorPane getFxml(String loc) {
		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(SukazyoBox.class.getResource("/fxml/" + loc));
			AnchorPane pane = loader.load();
			Logout.info("成功加载资源文件" + loc);
			return pane;
		} catch (Exception e) {
			Logout.error("资源文件<" + loc + ">加载失败：", e);
			return new AnchorPane();
		}
		
	}
	
}
