package main;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertHandler 
{
	public AlertHandler() 
	{
		
	}
	
	public void newError(String contentText)
	{
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Warning");
		alert.setContentText(contentText);
		alert.showAndWait();
	}
}
