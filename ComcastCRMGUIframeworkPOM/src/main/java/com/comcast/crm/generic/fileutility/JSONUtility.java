package com.comcast.crm.generic.fileutility;

import java.io.File;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONUtility 
{
	public String getDataFromJsonFile(String key) throws Exception
	{
		File f = new File("./configappdata/jsondata.json");
		FileReader fr = new FileReader(f);   
		JSONParser j = new JSONParser();
		Object obj = j.parse(fr);
		JSONObject json = (JSONObject)obj;
		String data = json.get(key).toString();
		return data;
	}
}
