package utlity;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

	private Properties properties;

	public PropertyReader(String filePath) {
		File file = new File(filePath);
		try {
			FileInputStream input = new FileInputStream(file);
			properties = new Properties();
			properties.load(input);
		} catch (IOException e) {
		}
	}

	public String getPropertyValue(String key) {
		return properties.getProperty(key);
	}

}
