package com.comcast.crm.generic.fileutility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility 
{
	public String getDataFromPropFile(String key) throws Exception 
	{
		File f = new File("./configappdata/DDT_config.properties");
		FileInputStream fis = new FileInputStream(f);
		Properties p = new Properties();
		p.load(fis);
		String data = p.getProperty(key);
		return data;
		
		//get the data from test case writer and store in key and based on the key get the data and return it
		//to the calling method
	}
}
