package main;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class Gameplay implements GUI{
	
	//Attributes Section
	private ArrayList<File> listOfFiles = new ArrayList<File>();
	private Level currentLevel;
	private int stepsTaken = -1;
	//End Attributes
	
	//Constructor Section
	public Gameplay()
	{
		//This block gets all the level files in the folder
		String folderPath = "src/levels/";
		File levelFolder = new File(folderPath);
		File[] listOfLevelFiles = levelFolder.listFiles();		
		int numberOfFiles = listOfLevelFiles.length;
		
		for(int i = 0; i < numberOfFiles; i++)
		{
			listOfFiles.add(listOfLevelFiles[i]);
		}
		
		//Generates the main menu
		generateMenu();
	}
	//End Constructor
	
	//Method Section
	//This method generates the main menu and its buttons
	private void generateMenu()
	{
		primaryStage.setWidth(getWidthOfWindow());
	    primaryStage.setHeight(getHeightOfWindow());
		resetAll();
		int gridPaneY = 0;
		
		//Creates and adds the label
		Label loadLevelLabel = new Label("Load Level");
		GridPane.setConstraints(loadLevelLabel, 0, gridPaneY);
		grid.getChildren().add(loadLevelLabel);
		loadLevelLabel.setFont(Font.font("Verdana", 15));
		
		//Checks every file in the folder and adds a button for each
		for(int i = 0; i < listOfFiles.size(); i++)
		{
			Button button = new Button("Play " + listOfFiles.get(i).getName());
			
			button.setOnMouseClicked(new EventHandler<MouseEvent>()
	        {
	            @Override
	            public void handle(MouseEvent t) {
	            	String buttonNum = button.getText().substring(button.getText().length() - 5, button.getText().length() - 4);
	            	try
	            	{
	            		loadLevel(Integer.parseInt(buttonNum));
	            	}
	            	catch(NumberFormatException e)
	            	{
	            		System.out.println("File name is incorrect. Please rename to 'level[X].txt' where the [x] is the levels number\neg:Level1.txt");
	            	} catch (IOException e) {
						System.out.println("Problem reading the file");
						e.printStackTrace();
					}
	            	
	            }
	        });
			
			grid.setVgap(10);
			button.setMinWidth(500);			
			button.setMinHeight(50);
			gridPaneY = gridPaneY + 2;
			GridPane.setConstraints(button, 0, gridPaneY);
			grid.getChildren().addAll(button);
			
			
		}
		
	}
	
	private void generateWinScreen()
	{
		primaryStage.setWidth(getWidthOfWindow());
	    primaryStage.setHeight(getHeightOfWindow());
	    grid.setVgap(20);
		resetAll();
		int levelNumber = this.currentLevel.getLevelNumber();
		
		//Creates and adds a label
		Label winLabel = new Label("You have won level " + levelNumber);
		winLabel.setFont(Font.font("Verdana", 15));
		winLabel.setAlignment(Pos.CENTER);
		GridPane.setConstraints(winLabel, 1, 0);
		grid.getChildren().add(winLabel);
		
		//Creates and adds the label indicating how many steps the player took
		Label stepCounter = new Label("You took " + this.stepsTaken + " steps");
		stepCounter.setFont(Font.font("Verdana", 15));
		stepCounter.setAlignment(Pos.CENTER);
		GridPane.setConstraints(stepCounter, 2, 0);
		grid.getChildren().add(stepCounter);
		
	    //Create button to play again and its listener
	    Button playAgain = createButton("Reset Level", new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent t) {
            	try {
            		winHandler.setToWin(false);
            		voidTheLevel();
					loadLevel(levelNumber);
				} catch (IOException e) {					
					e.printStackTrace();
				}
            }
        });
	    GridPane.setConstraints(playAgain, 0, 1);
	    grid.getChildren().add(playAgain);
	    
	    //Create button to pick another level and its listener
	    Button goToLevelMenu = createButton("Go to Main Menu", new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent t) {
            	winHandler.setToWin(false);
            	voidTheLevel();
				generateMenu();
            }
        });
		GridPane.setConstraints(goToLevelMenu, 1, 1);
		grid.getChildren().add(goToLevelMenu);
		
		//Create button to exit program
		Button exitButton = createButton("Exit Program", new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent t) {            	
				System.exit(0);
            }
        });
		GridPane.setConstraints(exitButton, 2, 1);
		grid.getChildren().add(exitButton);
	}

	private Button createButton(String buttonTitle, EventHandler<MouseEvent> doThisOnClick)
	{
		Button button = new Button(buttonTitle);
		button.setAlignment(Pos.CENTER);
	    button.setOnMouseClicked(doThisOnClick);
	    return button;
	}
	
	//This method loads up the selected level and also adds the handling for the player
	private void loadLevel(int levelToLoad) throws IOException
	{
		resetAll();
		this.currentLevel = new Level(levelToLoad);
		primaryStage.setWidth(getWidthOfWindow());
	    primaryStage.setHeight(getHeightOfWindow());
	    
	    HBox levelInfoBox = new HBox();
	    Label levelNumber = new Label("Level " + levelToLoad);
	    levelInfoBox.setAlignment(Pos.CENTER);
	    levelInfoBox.setPrefWidth(getWidthOfWindow()/3);		
	    levelInfoBox.getChildren().add(levelNumber);	    
	    
		HBox controlInterface = new HBox();
		controlInterface.setAlignment(Pos.CENTER);		
		controlInterface.setPrefWidth(getWidthOfWindow()/3);
		controlInterface.getChildren().addAll(
			createButton("Reset Level", new EventHandler<MouseEvent>()
	        {
	            @Override
	            public void handle(MouseEvent t) {
	            	try {
	            		winHandler.setToWin(false);
	            		voidTheLevel();
						loadLevel(levelToLoad);
					} catch (IOException e) {					
						e.printStackTrace();
					}
	            }
	        }), createButton("Go to Main Menu", new EventHandler<MouseEvent>()
	        {
	            @Override
	            public void handle(MouseEvent t) {
	            	winHandler.setToWin(false);
	            	voidTheLevel();
					generateMenu();
	            }
	        }), createButton("Exit Program", new EventHandler<MouseEvent>()
	        {
	            @Override
	            public void handle(MouseEvent t) {            	
					System.exit(0);
	            }
	        })
		);
		
		HBox stepCounterBox = new HBox();
		Label stepCount = new Label("Steps Taken: " + stepsTaken);
		stepCounterBox.setAlignment(Pos.CENTER);
		stepCounterBox.setPrefWidth(getWidthOfWindow()/3);
		stepCounterBox.getChildren().add(stepCount);
		
		HBox topLayer = new HBox();
	    topLayer.setMaxHeight(50);
	    topLayer.setPrefWidth(getWidthOfWindow());
	    topLayer.setPrefHeight(50);
	    topLayer.getChildren().addAll(levelInfoBox, controlInterface, stepCounterBox);
	    borderPane.setTop(topLayer);
	    
		Player playerObject = this.currentLevel.getPlayer();
		playerObject.getRect().setOnKeyTyped(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				
				//This method adds the movement handling for the player
				
				if(playerObject.addMovementHandling(event))
				{
					stepsTaken++;
					stepCount.setText("Steps Taken: " + stepsTaken);
				}
				
				//This little if statement forces the game to be won by pressing T
				if (event.getCharacter().equals("t")) {
					winHandler.setToWin(true);
				}
				
				//This quits to main menu by pressing Q
				if (event.getCharacter().equals("q")) {
					voidTheLevel();
					generateMenu();
				}
				
				//This if statement checks if the game has been won or not
				if(winHandler.isWin())
				{
					generateWinScreen();
				}
			}
		});
	}

	//This tells the GUI what width (in pixels) the screen should be depending on what is currently needed
	//If there is a level in play, it makes a window relevant to the level, if not then it generates a static window based
	private int getWidthOfWindow()
	{
		Level level = getCurrentLevel();
		if(level == null && !winHandler.isWin())
		{
			return 500;
		}
		else if(winHandler.isWin())
		{
			return 500;
		}
		return level.getLevelWidth();
	}
	
	//This tells the GUI what height (in pixels) the screen should be depending on what is currently needed
	//If there is a level in play, it makes a window relevant to the level, if not then it generates a static window based
	public int getHeightOfWindow()
	{
		Level level = getCurrentLevel();
		if(level == null&& !winHandler.isWin())
		{
			return 425;
		}
		else if(winHandler.isWin())
		{
			return 425;
		}
		return level.getLevelHeight();
	}
	
	//This method voids the level, this was required in order to fix a few small bugs
	public void voidTheLevel()
	{
		this.currentLevel = null;
	}
	
	public ArrayList<File> getListOfFiles()
	{
		return this.listOfFiles;
	}
	
	//Returns the current level loaded
	public Level getCurrentLevel()
	{
		return this.currentLevel;
	}
	
	//This little function wipes out the grid and winHandler
	public void resetAll()
	{
		grid.getChildren().clear();
		winHandler.clearAll();
		grid.setVgap(0);
		grid.setHgap(0);
		borderPane.setTop(null);
	}
	
	//End Method
}
