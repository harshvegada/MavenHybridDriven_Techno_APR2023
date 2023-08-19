package testscripts;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {

	public static void main(String[] args) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy_hh:mm:ss");
		String timeStamp = dateFormat.format(new Date());
		System.out.println(timeStamp);
	}
}
