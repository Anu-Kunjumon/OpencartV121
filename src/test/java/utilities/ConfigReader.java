package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader 
{
	
	private static Properties prop;
	static
	{
		try
		{
	
			FileReader file=new FileReader("./src//main//resources//config.properties");
			prop=new Properties();
			prop.load(file);
		}
		catch(IOException e)
		{
			e.printStackTrace();
			throw new RuntimeException("Failed to load the file");
		}
	}
	public static String getPropertyValue(String key) 
	{
		return prop.getProperty(key);
	}

}
