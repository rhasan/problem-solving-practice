package refresh2016.cp.exercise.ch1;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Page12Ex_1_2_3_3_Calendar {
	public static void main(String[] args) {
		Calendar calendar = new GregorianCalendar(2010, 7, 9);
		String dayName = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.getDefault());
		System.out.println(dayName);
	}
}
