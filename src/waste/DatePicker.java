package waste;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePicker {

	public static void main(String[] args) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd/hh/mm/ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
	}
}
