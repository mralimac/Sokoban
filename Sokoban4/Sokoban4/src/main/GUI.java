package main;

import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//An example of an interface 
//Used for handling the GUI over the entire project
public interface GUI 
{
	GridPane grid = new GridPane();
	Stage primaryStage = new Stage();
	WinHandler winHandler = new WinHandler();
}
