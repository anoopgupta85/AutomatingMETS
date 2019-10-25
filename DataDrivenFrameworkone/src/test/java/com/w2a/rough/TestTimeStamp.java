package com.w2a.rough;

import java.util.Date;

public class TestTimeStamp {

	public static void main(String[] args) {

		Date d = new Date();
		String screenShotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpeg";
		System.out.println(screenShotName);
		

	}

}
