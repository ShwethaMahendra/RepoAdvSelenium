package Generic_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * This method is used to read data from properties file
 */
public class File_Utility {
	
	public String getCommonData(String key) throws Throwable {
		//step1 : create path
		/* if the path is changing then we can directly modify the path here once instead of modifing in each 
		& every script in generic utility*/
		/*all paths can be set in IpathConstant interface in generic utility*/
		FileInputStream file = new FileInputStream(IPathConstant.filepath);
		 
		// step2:- load all the keys from properties file
		Properties pro = new Properties();
		pro.load(file);
		
		// step3:- get keys from properties file
		String value = pro.getProperty(key);
		return value;
	}
}

	

