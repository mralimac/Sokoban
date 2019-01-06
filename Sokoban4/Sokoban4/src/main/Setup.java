package main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;


public class Setup {
	
	//Attributes Section
	
	//End Attributes
	
	//Constructor Section
	public Setup()
	{
		checkIntergityOfPropertiesFile();
	}
	//End Constructor
	
	//Method Section
	private boolean checkIntergityOfPropertiesFile()
	{
		File propertiesFile = new File("config.properties");
		if(!propertiesFile.exists())
		{
			createPropertiesFile(propertiesFile);
			return true;
		}
		return false;
	}
	
	
	
	private void createPropertiesFile(File propertiesFile)
	{
		Properties properties = new Properties();
		OutputStream outputStream = null;
		
		try {
			outputStream = new FileOutputStream(propertiesFile);
			properties.setProperty("NumOfLevels", "5");
			properties.store(outputStream, null);
			
		} catch (IOException e) {			
			e.printStackTrace();
			
		} finally {			
			try {				
				outputStream.close();	
				
			} catch (IOException e) {
				e.printStackTrace();
				
			}
		}
	}
	//End Method
}
