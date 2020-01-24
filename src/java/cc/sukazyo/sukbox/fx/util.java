package cc.sukazyo.sukbox.fx;

import javafx.scene.control.Alert;

public class util {
	
	public static void infoUndoThings(String thing) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("未添加功能");
		alert.setHeaderText(null);
		alert.setContentText("功能<" + thing + ">暂未添加，请耐心等待");
		alert.showAndWait();
	}
	
}
