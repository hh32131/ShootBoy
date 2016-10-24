package net.Y5M2.match.web;

import java.util.Calendar;

public class CalendarHelper {

	public static CalDate getNowCalendarDate() {
		CalDate calDate = new CalDate();
		Calendar cal = Calendar.getInstance();
		calDate.setYear(cal.get(Calendar.YEAR));
		calDate.setMonth(cal.get(Calendar.MONTH) + 1);
		calDate.setDate(cal.get(Calendar.DAY_OF_MONTH));
		calDate.setDay(CalendarHelper.getStartDay(calDate));
	
		return calDate;
	}

	// 연도와 달을 말해주고 첫월이 일수는 1일부터 시작한다.
	public static CalDate getCalendarDate(int year, int month) {
		CalDate calDate = new CalDate();
		calDate.setYear(year);
		calDate.setMonth(month);
		calDate.setDate(1);
		calDate.setDay(CalendarHelper.getStartDay(calDate));
	
		return calDate;
	}

	// 마지막 일수를 말해준다.
	public static int getMaxDate(CalDate calDate) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, calDate.getYear());
		cal.set(Calendar.MONTH, calDate.getMonth() - 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);

		return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	// 요일을 알려준다
	private static int getStartDay(CalDate calDate) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, calDate.getYear());
		cal.set(Calendar.MONTH, calDate.getMonth() - 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);

		return cal.get(Calendar.DAY_OF_WEEK);
	}

	// 몇일인지 알려준다.
	public static int getNowDate(CalDate calDate) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, calDate.getYear());
		cal.set(Calendar.MONTH, calDate.getMonth() - 1);
		
		return cal.get(Calendar.DAY_OF_MONTH);
	}

	public static class CalDate {
		private int year;
		private int month;
		private int date;
		private int day; // 1일의 요일

		public CalDate() {
		}

		public CalDate(int year, int month) {
			this.year = year;
			this.month = month;
			this.date = 1;
		}

		public CalDate(int year, int month, int date) {
			this.year = year;
			this.month = month;
			this.date = date;
		}

		public int getYear() {
			return year;
		}

		public void setYear(int year) {
			this.year = year;
		}

		public int getMonth() {
			return month;
		}

		public void setMonth(int month) {
			this.month = month;
		}

		public int getDate() {
			return date;
		}

		public void setDate(int date) {
			this.date = date;
		}

		public int getDay() {
			return day;
		}

		public void setDay(int day) {
			this.day = day;
		}

	}

}
