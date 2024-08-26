package com.it360.qa.Utils;

import java.util.Date;

public class Util {
	
	public static String emailWithTimeStamp() {
		Date date = new Date();
		String timeStamp = date.toString().replace(" ", "_").replace(":", "_");
		return "danidei_" + timeStamp  + "@gamil.com";
	}

}
