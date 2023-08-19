package utlity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtility {

	public static String getTimeStamp() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy_hhmmss");
		String timeStamp = dateFormat.format(new Date());
		return timeStamp;
	}
}
