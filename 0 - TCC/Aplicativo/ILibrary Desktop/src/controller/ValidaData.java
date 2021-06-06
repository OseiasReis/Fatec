package controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidaData {
	
	public static boolean validarData(Date data) {
		
		DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
		
		df.setLenient(false);
		try {
			System.out.println(df.format(data));
		    df.parse(df.format(data));
		    return true;
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		
		return false;
	}
}


