package main;

import javafx.scene.Scene;

public class Setup implements GUI {
	public Setup()
	{
		setupGUI();
	}
	
	private void setupGUI()
	{
		borderPane.setCenter(grid);
		Scene scene = new Scene(borderPane);
		primaryStage.setTitle("Sokoban");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
