package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

public class JavaUtility 
{
	public int getRandomNum()
	{
		Random r = new Random();
		int r_num = r.nextInt(1000);
		return r_num;
	}
	
	public String getSystemDate()
	{
		Date d_obj = new Date();    
		SimpleDateFormat simple_date = new SimpleDateFormat("yyyy-MM-dd");
		String act_date = simple_date.format(d_obj);
		return act_date;
	}
	
	public String getRequiredDate(int days)            //for how many days from current date should it calculate
	{
		LocalDateTime date=LocalDateTime.now().plusDays(days);
		String req_date = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return req_date;
	}
}
