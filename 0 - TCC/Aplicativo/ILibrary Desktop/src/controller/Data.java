package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Data {

	public static String convertSql(String date) {

		try {
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(date);
			return new SimpleDateFormat("yyyy-MM-dd").format(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static String convertString(String date) {
		try {
			Date data = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			return new SimpleDateFormat("dd/MM/yyyy").format(data);
		} catch (NullPointerException | ParseException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static Date convertDate(String date) {
		try {
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(date);
			return data;
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}

	@SuppressWarnings("deprecation")
	public static java.sql.Date convertDateUtilToDateSql(Date date) {
		if (date != null) {
			return new java.sql.Date(date.getDate());
		} else {
			return null;
		}
	}
}
