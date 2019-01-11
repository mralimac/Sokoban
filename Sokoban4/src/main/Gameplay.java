package main;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.json.*;

public class Gameplay{
	
	//Attributes Section
	private ArrayList<File> listOfFiles = new ArrayList<File>();
	private Level currentLevel;
	private int stepsTaken;
	private Stage primaryStage;
	private BorderPane borderPane;
	private WinHandler winHandle;
	private GridPane grid;
	private int playerID;
	//End Attributes
	
	//Constructor Section
	public Gameplay(Stage primaryStage, BorderPane borderPane, GridPane grid, int playerID)
	{
		//This block gets all the level files in the folder
		String folderPath = "src/levels/";
		File levelFolder = new File(folderPath);
		File[] listOfLevelFiles = levelFolder.listFiles();
		this.primaryStage = primaryStage;
		int numberOfFiles = listOfLevelFiles.length;
		this.borderPane = borderPane;
		this.grid = grid;
		this.playerID = playerID;
		this.winHandle = new WinHandler(grid);
		
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
	
	//A method to call an API and return its reply as JSON
	private JSONObject sendToAPI(URL urlObject) throws IOException
	{
		HttpURLConnection conn = (HttpURLConnection) urlObject.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("User-Agent", "Mozilla/5.0");
		
		int responseCode = conn.getResponseCode();
		if(responseCode != 200)
		{
			System.out.println("Code: "+ responseCode);
			System.out.print("API miscommuncation occured. Inform Ali");
		}

			
		BufferedReader input = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = input.readLine()) != null) {
	     	response.append(inputLine);
	    }
		input.close();
		
		JSONObject jsonReply;
		try {
			jsonReply = new JSONObject(response.toString());
			return jsonReply;
		} catch (JSONException e) {
			e.printStackTrace();
			System.out.println("JSON Malformed");
		}
		return null;
	}
	
	//Gets the players score for a level and pushes it to an API for multiplayer scoreboard
	private void updatePlayerScore(int levelNumber, int levelScore) throws IOException
	{
		String url = "https://mralimac.com/sokobanAPI2/write.php?id=" + this.playerID + "&level="+ levelNumber + "&steps="+levelScore;		
		System.out.println(url);
		URL urlObject = new URL(url);		
		sendToAPI(urlObject);
	}
	
	private void generateWinScreen()
	{
		primaryStage.setWidth(getWidthOfWindow());
	    primaryStage.setHeight(getHeightOfWindow());
	    grid.setVgap(20);
		resetAll();
		int levelNumber = this.currentLevel.getLevelNumber();
		int stepsTaken = this.stepsTaken;
		
		//Attempts to call the API to update playerscore
		//In a new thread to allow Async operation
		new Thread(() -> { 
			try {
				updatePlayerScore(levelNumber, stepsTaken);
			} catch (IOException e1) {
				e1.printStackTrace();
				System.out.print("Failed to update API");
			}
		}).start();
		
		//Creates and adds a HBox for containing the labels
		HBox winLabelBox = new HBox();
		winLabelBox.setAlignment(Pos.CENTER);
		winLabelBox.setPrefWidth(getWidthOfWindow()/2);
		
		Label winLabel = new Label("You have won level " + levelNumber);
		winLabel.setFont(Font.font("Verdana", 15));
		winLabelBox.getChildren().add(winLabel);
		
		HBox stepLabelBox = new HBox();
		stepLabelBox.setAlignment(Pos.CENTER);
		stepLabelBox.setPrefWidth(getWidthOfWindow()/2);
		
		Label stepCounter = new Label("You took " + stepsTaken + " steps");
		stepCounter.setFont(Font.font("Verdana", 15));
		stepLabelBox.getChildren().add(stepCounter);
		
		
		HBox labelBox = new HBox();
		labelBox.setAlignment(Pos.CENTER);
		labelBox.setPrefWidth(getWidthOfWindow());
		labelBox.getChildren().addAll(winLabelBox, stepLabelBox);
		
		borderPane.setTop(labelBox);
		
		
		//Creates and adds a HBox for containing the buttons
		HBox playAgainBox = new HBox();
		playAgainBox.setPrefWidth(getWidthOfWindow()/3);
		playAgainBox.setAlignment(Pos.CENTER);
		
		HBox menuBox = new HBox();
		menuBox.setPrefWidth(getWidthOfWindow()/3);
		menuBox.setAlignment(Pos.CENTER);
		
		HBox exitBox = new HBox();
		exitBox.setPrefWidth(getWidthOfWindow()/3);
		exitBox.setAlignment(Pos.CENTER);
		
		HBox boxOfButtons = new HBox();
		boxOfButtons.setPrefWidth(getWidthOfWindow());
		boxOfButtons.getChildren().addAll(playAgainBox, menuBox, exitBox);
		
		borderPane.setCenter(boxOfButtons);
		
	    //Create button to play again and its listener
	    Button playAgain = createButton("Reset Level", new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent t) {
            	try {
            		winHandle.setToWin(false);
            		voidTheLevel();
					loadLevel(levelNumber);
				} catch (IOException e) {					
					e.printStackTrace();
				}
            }
        });
	    playAgainBox.getChildren().addAll(playAgain);
	    
	    //Create button to pick another level and its listener
	    Button goToLevelMenu = createButton("Go to Main Menu", new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent t) {
            	winHandle.setToWin(false);
            	voidTheLevel();
				generateMenu();
            }
        });
		menuBox.getChildren().addAll(goToLevelMenu);
		
		//Create button to exit program
		Button exitButton = createButton("Exit Program", new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent t) {            	
				System.exit(0);
            }
        });
		exitBox.getChildren().addAll(exitButton);
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
		this.stepsTaken = 0;
		this.currentLevel = new Level(levelToLoad, listOfFiles.get(levelToLoad-1).getAbsolutePath(), winHandle, grid);
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
	            		winHandle.setToWin(false);
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
	            	winHandle.setToWin(false);
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
				winHandle.checkIfGameIsWon();
				//This method adds the movement handling for the player
				
				if(playerObject.addMovementHandling(event))
				{
					stepsTaken++;
					stepCount.setText("Steps Taken: " + stepsTaken);
				}
				
				//This little if statement forces the game to be won by pressing T
				if (event.getCharacter().equals("t")) {
					winHandle.setToWin(true);
				}
				
				//This quits to main menu by pressing Q
				if (event.getCharacter().equals("q")) {
					voidTheLevel();
					generateMenu();
				}
				
				//This if statement checks if the game has been won or not
				if(winHandle.isWin())
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
		if(level == null && !winHandle.isWin())
		{
			return 500;
		}
		else if(winHandle.isWin())
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
		if(level == null&& !winHandle.isWin())
		{
			return 425;
		}
		else if(winHandle.isWin())
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
		winHandle.clearAll();
		grid.setVgap(0);
		grid.setHgap(0);
		borderPane.setTop(null);
		borderPane.setCenter(grid);
	}
	
	//End Method
}
